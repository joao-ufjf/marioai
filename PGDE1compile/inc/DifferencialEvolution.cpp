#include "DifferencialEvolution.h"

using namespace std;

void DifferencialEvolution::Optimize(Subject* s, Parser* parser) {
    if(s->optimized)
        return;
    //for(int i = 0; i < 10; i++){
    //    cout << distribution(*generator) << endl;
    //}
    //cin.get();

    this->ind = dynamic_cast<SimpleIndividuo*>(s);
    double* fitness = new double[p_size];
    double* fitnessCross = new double[p_size];

    double* initialIndividual = new double[ind->trees[0]->constantsSize];
    ind->trees[0]->Constants(initialIndividual, 0, ind->trees[0]->root);
//    cout << initialIndividual[0] << endl;
//    ind->print();

    int total = 0;
    for(int i = 0; i < conf->numTree; i++){
        ind->trees[i]->replaceAllConst();
        total += ind->trees[i]->constantsSize;
    }

    if(total == 0)
        return;

    s->optimized = true;

    this->parser = parser;
    clock_t tStart = clock();

////    conf->numTree = 3;
    population = new double**[p_size];
    mut_pop = new double**[p_size];
    cross_pop = new double**[p_size];
    dim = new int[conf->numTree];
    for(int i = 0; i < conf->numTree; i++) {
        dim[i] = s->trees[i]->constantsSize;
    }

    for (int i = 0; i < p_size; i++) {
        population[i] = new double*[conf->numTree];
        mut_pop[i] = new double*[conf->numTree];
        cross_pop[i] = new double*[conf->numTree];
        for(int j =0; j < conf->numTree; j++) {
            population[i][j] = new double[dim[j]];
            mut_pop[i][j] = new double[dim[j]];
            cross_pop[i][j] = new double[dim[j]];
        }
        if(i == 0){
            delete [] population[i][0];
            population[i][0] = initialIndividual;
        }
        else{
            initialSolutions(population[i], dim, -5, 5, initialIndividual); // Aqui entra os valores limite para gerar populacao inicial
        }
    }

//    for (int i = 0; i < p_size; i++) {
//        cout << "I" << i << " = ";
//        for(int j = 0; j < conf->numTree; j++) {
//            cout << "   ";
//            for(int k = 0; k < dim[j]; k++){
//                cout << population[i][j][k] << " ";
//            }
//            cout << endl;
//        }
//        cout << endl;
//    }
//
//    cin.get();

    fitness = new double[p_size];
    evaluate(population, fitness, p_size, dim);

    double time = 0;
    int count = 1;
    int best = 0;
    int generations = 0;
    int budget = conf->optimizationEvaluations;

    while (generations * p_size < budget) {
        generations++;
        conf->evaluations += p_size;

        //Chamada da mutacao
        mutation(mut_pop, population, dim, p_size, mut_factor); //Agora temos em mut_pop a population com a perturbacao do fator de mutacao e as operacoes vetoriais

        //Chamada de cruzamento
        crossover(cross_pop, population, mut_pop, cross_factor, dim, p_size); //Agora temos

        //Chamada de selecao
        best = selection(population, cross_pop, fitness, fitnessCross, dim, p_size);

        count++;
    }

    /*Ideia para modificacao, substituir os _c_ no individuo por seus respectivos valores ajustados*/
    ind->constants = new double*[conf->numTree];
    for(int i = 0; i < conf->numTree; i++) {
        ind->constants[i] = new double[dim[i]];
        for(int j = 0; j < dim[i]; j++) {
            ind->constants[i][j] = population[(int)best][i][j];
            grammar->addConstant(ind->constants[i][j]);
        }
        replace_all_c(s, ind->constants[i]);
    }
    /*Fim da ideia para modificacao*/

    for (int i = 0; i < p_size; i++) {
        for(int j =0; j < conf->numTree; j++) {
            delete [] population[i][j];
            delete [] mut_pop[i][j];
            delete [] cross_pop[i][j];
        }
        delete [] population[i];
        delete [] mut_pop[i];
        delete [] cross_pop[i];
    }

    delete [] population;
    delete [] mut_pop;
    delete [] cross_pop;
    delete [] fitness;
    delete [] fitnessCross;
}

DifferencialEvolution::DifferencialEvolution() {
    generator = new default_random_engine(rand());
}

DifferencialEvolution::~DifferencialEvolution() {
    //dtor
    delete generator;
}

///<sumary>
/// Metodo para substituir todos os _c_ do individuo por seus respectivos valores ajustados
///</sumary>
void DifferencialEvolution::replace_all_c(Subject* s, double* constants){
    int cont = 0;
    s->trees[0]->replaceAllC(constants);
    s->trees[0]->constantsSize = 0;
}

/// <summary>
/// Metodo para gerar numero real aleatorio dentro do intervalo
/// </summary>
double DifferencialEvolution::fRand(double fMin, double fMax) {
    double f = (double)rand() / RAND_MAX;
    return fMin + f * (fMax - fMin);
}

/// <summary>
/// Metodo para que cada dimensao da posicao do vetor passada seja iniciada aleatoriamente
/// </summary>
void DifferencialEvolution::initialSolutions(double **population, int *dim, double limInf, double limSup, double *initialIndividual) {
    /*cout << "Initial individual: ";
    for(int i = 0; i < dim[0]; i++) {
        cout << initialIndividual[i] << " ";
    }*/
    //cout << endl;
    std::normal_distribution<double> distribution(0,1);
    double rands = distribution(*generator);
    for(int k = 0; k < conf->numTree; k++) {
        for (int i = 0; i < dim[k]; i++) {
            population[k][i] = initialIndividual[i] + rands;
            //cout << initialIndividual[i] << " ; " <<rands << " ; " << population[k][i] << endl;
            //cin.get();
            //population[k][i] = fRand(limInf, limSup);
        }
    }
}

/// <summary>
/// Metodo para realizar a diferenca vetorial de dois parametros e armazena-los em result
/// </summary>
void DifferencialEvolution::vectorialDifference(double *result, double *second, double *third, int dim) {
    for (int i = 0; i < dim; i++) {
        result[i] = second[i] - third[i];
    }
}

/// <summary>
/// Metodo para realizar a soma vetorial de dois parametros e armazena-los em result
/// </summary>
void DifferencialEvolution::vectorialSum(double *result, double *second, double *third, int dim) {
    for (int i = 0; i < dim; i++) {
        result[i] = second[i] + third[i];
    }
}

/// <summary>
/// Metodo para realizar o calculo de aptidao de uma populacao e armazenar no vetor fitness
/// </summary>
int DifferencialEvolution::evaluate(double*** population, double* fitness, int p_size, int* dim) {
    //For para calcular todas fitness da população
    int best_index = 0;
    for (int i = 0; i < p_size; i++) {
        ind->constants = population[i];
        fitness[i] = parser->Evaluate(ind);
        if (fitness[i] < fitness[best_index])
            best_index = i;
    }
    return best_index;
}

/// <summary>
/// Metodo para realizar a operacao de mutacao
/// </summary>
void DifferencialEvolution::mutation(double*** mut_pop, double*** population, int* dim, int p_size, double mut_factor) {
    for (int k = 0; k < conf->numTree; k++) {
        for (int j = 0; j < p_size; j++) {
            //Primeiramente tres individuos sao selecionados aleatoriamente
            int first = (int)fRand(0, p_size - 1);
            int second = (int)fRand(0, p_size - 1);
            while (first == second)
                second = (int)fRand(0, p_size - 1);
            int third = (int)fRand(0, p_size - 1);
            while (first == third || third == second)
                third = (int)fRand(0, p_size - 1);

            //Temos entao os tres indices escolhidos para mutacao
            //Agora fazemos a diferenca vetorial do segundo pelo terceiro para entao armazenarmos no result
            vectorialDifference(mut_pop[j][k], population[first][k], population[second][k], dim[k]);

            //Agora deve ser realizada a multiplicacao do resultado pelo fator de mutacao
            for (int i = 0; i < dim[k]; i++) {
                mut_pop[j][k][i] = mut_factor * mut_pop[j][k][i];
            }

            //Por ultimo deve ser realizada a perturbacao sob o primeiro individuo
            vectorialSum(mut_pop[j][k], population[third][k], mut_pop[j][k], dim[k]);
        }
    }
}

/// <summary>
/// Metodo para realizar a operacao de cruzamento
/// </summary>
void DifferencialEvolution::crossover(double ***cross_pop, double*** population, double*** mut_pop, double cross_factor, int* dim, int p_size) {
    //Repeticao para preencher todos individuos da cross_pop
    for (int k = 0; k < conf->numTree; k++) {
        for (int i = 0; i < p_size; i++) {
            //Repeticao para preencher um individuo da cross_pop
            int l = rand()%dim[k];
            for (int j = 0; j < dim[k]; j++) {
                double rand_val = fRand(0, 1);
                //Se o random for menor que a taxa, entao eh transmitido o gene mutado
                if (cross_factor > rand_val || j==l)
                    cross_pop[i][k][j] = mut_pop[i][k][j];
                else
                    cross_pop[i][k][j] = population[i][k][j];
            }
        }
    }
}

// <summary>
/// Metodo para realizar a selecao dos melhores entre cross_pop e population
/// </summary>
int DifferencialEvolution::selection(double ***population, double ***cross_pop, double* fitness, double* fitnessCross, int *dim, int p_size) {
    evaluate(cross_pop, fitnessCross, p_size, dim);

    int best_fit = 0;
    //Agora temos fitness de ambas populacoes
    //Repeticao para substituir os elementos de population que sao piores do que os de cross pop
    for (int i = 0; i < p_size; i++) {
        if (fitness[i] >= fitnessCross[i]) {
            for (int k = 0; k < conf->numTree; k++) {
                for (int j = 0; j < dim[k]; j++) {
                    population[i][k][j] = cross_pop[i][k][j];
                }
            }
            fitness[i] = fitnessCross[i];
        }
    }
    for(int i = 1; i < p_size; i++) {
        if(fitness[best_fit] > fitness[i]) {
            best_fit = i;
        }
    }
    return best_fit;

}
