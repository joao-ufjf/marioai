#include "Search.h"
#include <vector>

/**
* Construtores da função de busca
*   Recebem todos os parametros relativos a busca
*   Parameters
*       Parser - responsavel por avaliar os individuos
*       PopulationReplace - reponsavel pela substituição da população para a proxima geração
*       IndividuoBuilder - responsavel pela criação de individuos
*       Mutation - Operador de mutação
*       Crossover - Operador genetico de mutação
*       Selection - Operador de seleção de indivudos
**/
Search::Search()
{
    setParser(NULL);
    setPopulationReplace(NULL);
    setIndividuoBuilder(NULL);
    setMutation(NULL);
    setCrossover(NULL);
    setSelection(NULL);

   // omp_set_num_threads(conf->NUM_THREADS);

}


Search::Search(Parser* parser,PopulationReplacement * populationreplace, IndividuoBuilder * individuobuilder)
{
    setParser(parser);
    setPopulationReplace(populationreplace);
    setIndividuoBuilder(individuobuilder);

    setMutation(NULL);
    setCrossover(NULL);
    setSelection(NULL);

   // omp_set_num_threads(conf->NUM_THREADS);

}

/**
    Função privada que instancia e preenche a população inicial de individuos
**/
void Search::createsInitialPopulation(){
//    cout << "Create Initial Population..." << endl;
    pop = new Subject*[conf->popSize * 2];

   // #pragma omp parallel for num_threads(conf->NUM_THREADS)
    for(int i = 0; i < conf->popSize; i++){
        pop[i] = individuoBuilder->generateIndividuo();
    }
}
//Substitui todos os valores constantes por _c_
void Search::replaceAllConst(int initialIndex, int finalIndex){
    #pragma omp parallel for num_threads(conf->NUM_THREADS)
    for(int i = initialIndex; i < finalIndex; i++){
        if(!pop[i]->optimized){
            pop[i]->trees[0]->replaceAllConst();
        }
    }
}

void Search::evolveMario(){
    int tolerance_count = 0;
    cout << "Criar populacao inicial" << endl;
    this->createsInitialPopulation();
    DifferencialEvolution* de = new DifferencialEvolution();
    EvolutionStrategie* es = new EvolutionStrategie();
    //initial population evaluation
//    if(conf->approach != 0)
//        replaceAllConst(0, conf->popSize);
    EvaluatePopulation(0, conf->popSize);

    stable_sort(pop, pop + conf->popSize, SortPopulationFitness);
    cout << "0 " << pop[0]->trees[0]->fitness << endl;

    //cin.get();
    Subject* best = NULL;

    int timeStamp = 100;
    int DECounter = 1;
    int maxEvaluations = 100000;

    conf->optimizationEvaluations = 100;
    vector<double> fitInTime;
    fitInTime.push_back(pop[0]->fitness);


    for(int it = 1; conf->evaluations < maxEvaluations; it++){
        Operate();//Realiza cross e mut

        EvaluatePopulation(conf->popSize, conf->popSize * 2);
        stable_sort(pop + conf->popSize, pop + conf->popSize * 2, SortPopulationFitness);
        replacer->Replace(pop);
        stable_sort(pop, pop + conf->popSize, SortPopulationFitness);

        for(int i = conf->popSize; i < conf->popSize * 2; i++){
            delete pop[i];
        }

        cout << it << " " << pop[0]->trees[0]->fitness << " ";
        pop[0]->print();
        fitInTime.push_back(pop[0]->fitness);
        cin.get();
    }


    cout << "ACABOU TREINAMENTO";
    /*** Com a populacao treinada, hora de realizar a validacao ***/
    for(int i = 0; i < conf->popSize; i++){
        pop[i]->fitnessValidation = parserValidation->Evaluate(pop[i]);
    }
    cout << "VALIDADO:" << endl;
    stable_sort(pop, pop + conf->popSize, SortPopulationFitnessValidation);

    //cin.get();
    pop[0]->fitness = parser->Evaluate(pop[0]);
    pop[0]->fitnessValidation = parserValidation->Evaluate(pop[0]);
    pop[0]->fitnessTest = parserTest->Evaluate(pop[0]);

    fitInTime.push_back(pop[0]->fitnessTest);
    for(int k = 0; k < fitInTime.size(); k++)
        cout << fitInTime.at(k) << endl;
    for(int k = fitInTime.size(); k <= 200; k++)
        cout << fitInTime.at(fitInTime.size() - 1) << endl;

    cout << "--------------Results--------------" << endl;
    pop[0]->print();

    cout << "Fitness test: " << pop[0]->fitnessTest <<endl;
    cout << endl << pop[0]->fitness << " " << pop[0]->fitnessValidation << " " << pop[0]->fitnessTest << endl;
}

/**
*
*   Realiza a busca atravez do processo evolutivo
*   @return void
**/
void Search::evolve(){
    int tolerance_count = 0;
    cout << "Criar populacao inicial" << endl;
    this->createsInitialPopulation();
    DifferencialEvolution* de = new DifferencialEvolution();
    EvolutionStrategie* es = new EvolutionStrategie();
    //initial population evaluation
//    if(conf->approach != 0)
//        replaceAllConst(0, conf->popSize);
    EvaluatePopulation(0, conf->popSize);

    stable_sort(pop, pop + conf->popSize, SortPopulationFitness);
    cout << "0 " << pop[0]->trees[0]->fitness << endl;

    //cin.get();
    Subject* best = NULL;

    int timeStamp = 100;
    int DECounter = 1;
    int maxEvaluations = 100000;

    conf->optimizationEvaluations = 100;
    vector<double> fitInTime;
    fitInTime.push_back(pop[0]->fitness);

    // Para todos os casos que o otimizador executara no fim
    if(conf->approach == 1 || conf->approach == 6 || conf->approach == 7 || conf->approach == 8 ||
       conf->approach == 13 || conf->approach == 18 || conf->approach == 19 || conf->approach == 20){
        conf->optimizationEvaluations = maxEvaluations * 0.1;
        maxEvaluations *= 0.9;
    }else if (conf->approach == 9 || conf->approach == 10 || conf->approach == 11 || conf->approach == 12 ||
              conf->approach == 21 || conf->approach == 22 || conf->approach == 23 || conf->approach == 24){
        conf->optimizationEvaluations = maxEvaluations * 0.05;
        maxEvaluations *= 0.95;
    }

    for(int it = 1; conf->evaluations < maxEvaluations; it++){
        Operate();//Realiza cross e mut

        if(conf->evaluations > DECounter * 0.1 * maxEvaluations){//Entao devo trocar as constantes por C
            if(conf->approach == 2 || conf->approach == 3 || conf->approach == 4 || conf->approach == 5){ // faz DE no best
                for(int x = 0; x < conf->popSize; x++){
                    pop[x]->fitnessValidation = parserValidation->Evaluate(pop[x]);
                }
                cout << "VALIDADO PARA OTIMIZAR:" << endl;
                stable_sort(pop, pop + conf->popSize, SortPopulationFitnessValidation);

                ++DECounter;
                // neste caso, a avaliação executa o DE ou EE para o range indicado
                EvaluatePopulation(0, 1, 1);
            }
            else if(conf->approach == 14 || conf->approach == 15 || conf->approach == 16 || conf->approach == 17){ // faz DE no best
                for(int x = 0; x < conf->popSize; x++){
                    pop[x]->fitnessValidation = parserValidation->Evaluate(pop[x]);
                }
                cout << "VALIDADO PARA OTIMIZAR:" << endl;
                stable_sort(pop, pop + conf->popSize, SortPopulationFitnessValidation);

                ++DECounter;
                // neste caso, a avaliação executa o DE ou EE para o range indicado
                EvaluatePopulation(0, conf->elitism * conf->popSize, 1);
            }
        }

        //Avalia população
        EvaluatePopulation(conf->popSize, conf->popSize * 2);
        stable_sort(pop + conf->popSize, pop + conf->popSize * 2, SortPopulationFitness);
        replacer->Replace(pop);
        stable_sort(pop, pop + conf->popSize, SortPopulationFitness);

//        stable_sort(pop, pop + conf->popSize, SortPopulationFitness);

        for(int i = conf->popSize; i < conf->popSize * 2; i++){
            delete pop[i];
        }

        cout << it << " " << DECounter << " " << pop[0]->trees[0]->fitness << " ";
        pop[0]->print();
        fitInTime.push_back(pop[0]->fitness);
    }


    cout << "ACABOU TREINAMENTO";
    /*** Com a populacao treinada, hora de realizar a validacao ***/
    for(int i = 0; i < conf->popSize; i++){
        pop[i]->fitnessValidation = parserValidation->Evaluate(pop[i]);
    }
    cout << "VALIDADO:" << endl;
    stable_sort(pop, pop + conf->popSize, SortPopulationFitnessValidation);


    /// The best in validation will be optimized by some optimizer
    if(conf->approach == 1 || conf->approach == 6 || conf->approach == 7 || conf->approach == 8
    || conf->approach == 9 || conf->approach == 10 || conf->approach == 11 || conf->approach == 12){
        cout << "Ind que entra na opt " << pop[0]->fitness << " " << pop[0]->fitnessValidation << endl;
        EvaluatePopulation(0,1,1);
        cout << "Ind que sai da opt " << pop[0]->fitness << " " << pop[0]->fitnessValidation << endl;
        cout << " " << DECounter << " " << pop[0]->trees[0]->fitness << " ";
        pop[0]->print();
    }
    else if(conf->approach == 13 || conf->approach == 18 || conf->approach == 19 || conf->approach == 20
    || conf->approach == 21 || conf->approach == 22 || conf->approach == 23 || conf->approach == 24){
        cout << "Ind que entra na opt " << pop[0]->fitness << " " << pop[0]->fitnessValidation << endl;
        EvaluatePopulation(0,conf->elitism * conf->popSize,1);
        cout << "Ind que sai da opt " << pop[0]->fitness << " " << pop[0]->fitnessValidation << endl;
        cout << " " << DECounter << " " << pop[0]->trees[0]->fitness << " ";
        pop[0]->print();
    }

    //cin.get();
    pop[0]->fitness = parser->Evaluate(pop[0]);
    pop[0]->fitnessValidation = parserValidation->Evaluate(pop[0]);
    pop[0]->fitnessTest = parserTest->Evaluate(pop[0]);

    fitInTime.push_back(pop[0]->fitnessTest);
    for(int k = 0; k < fitInTime.size(); k++)
        cout << fitInTime.at(k) << endl;
    for(int k = fitInTime.size(); k <= 200; k++)
        cout << fitInTime.at(fitInTime.size() - 1) << endl;

    cout << "--------------Results--------------" << endl;
    pop[0]->print();

    cout << "Fitness test: " << pop[0]->fitnessTest <<endl;
    cout << endl << pop[0]->fitness << " " << pop[0]->fitnessValidation << " " << pop[0]->fitnessTest << endl;
}

void Search::Replace(){
    stable_sort(pop, pop + conf->popSize * 2, SortPopulationFitness);
}

/**
    Parameters
        int initialIndex - indice inicial a ser avaliado
        int finalIndex - indice final a pop sera avaliada até o finalIndex -1
    Percorre o vetor pop (população) avaliando os individuos do indice initialIndex até finalIndex
    @return void
**/
void Search::EvaluatePopulation(int initialIndex, int finalIndex, int optimizeRange){
    #pragma omp parallel for num_threads(conf->NUM_THREADS)
    for(int i = initialIndex; i < finalIndex; i++){
        if(i < optimizeRange && !pop[i]->optimized){
            Subject* ind_ = pop[i]->clone();
            parser->Evaluate(ind_);
            parser->Optimize(ind_);
            if(ind_->fitness < pop[i]->fitness){
                cout << pop[i]->fitness << " " << ind_->fitness << endl;
                swap(pop[i], ind_);
                delete ind_;
            }
        }
        else{
            pop[i]->fitness = parser->Evaluate(pop[i]);
        }
        conf->evaluations++;
//        cout << "   " << i << " " << pop[i]->fitness << endl;
    }

//    #pragma omp parallel for num_threads(conf->NUM_THREADS)
//    for(int i = initialIndex; i < finalIndex; i++){
//        parser->Optimize(pop[i]);
//        pop[i]->fitness = parser->Evaluate(pop[i]);
//        conf->evaluations++;
////        cout << "   " << i << " " << pop[i]->fitness << endl;
//    }
}

void Search::EvaluatePopulationValidation(int initialIndex, int finalIndex, int optimizeRange){
    #pragma omp parallel for num_threads(conf->NUM_THREADS)
    for(int i = initialIndex; i < finalIndex; i++){
        if(i < optimizeRange && !pop[i]->optimized){
            Subject* ind_ = pop[i]->clone();
//            ind_->trees[0]->replaceAllConst();
            parserValidation->Optimize(ind_);
            ind_->fitness = parser->Evaluate(ind_);
            if(ind_->fitness < pop[i]->fitness){
                cout << ind_->fitness << " " << pop[i]->fitness << endl;
//                cin.get();
                swap(pop[i], ind_);
                delete ind_;
            }
        }
        else{
            pop[i]->fitness = parser->Evaluate(pop[i]);
        }
        conf->evaluations++;
//        cout << "   " << i << " " << pop[i]->fitness << endl;
    }

//    #pragma omp parallel for num_threads(conf->NUM_THREADS)
//    for(int i = initialIndex; i < finalIndex; i++){
//        parser->Optimize(pop[i]);
//        pop[i]->fitness = parser->Evaluate(pop[i]);
//        conf->evaluations++;
////        cout << "   " << i << " " << pop[i]->fitness << endl;
//    }
}

/**
    Aplica os operadores genéticos de mutação e cruzamento
    @return void
**/
void Search::Operate(){
    int num_individuos = seletor->tam_selection;
    Subject ** selecionados;

    //#pragma omp parallel for private(selecionados)
    for(int i = conf->popSize; i < conf->popSize * 2; i += num_individuos){

        selecionados = new Subject*[num_individuos];

        for(int j = 0; j < num_individuos; j++){
            selecionados[j] = seletor->selects(pop)->clone();
            pop[i+j] = selecionados[j];
        }

        crossoverOperator->cross(selecionados,num_individuos);

        for(int j = 0; j < num_individuos; j++){
            mutationOperator->mutate(selecionados[j]);
        }

        for(int j = 0; j < num_individuos; j++){
            selecionados[j] = NULL;
        }
        delete selecionados;
    }

}


/**
    Set Parameters
**/
void Search::setParser(Parser * parser){
  if(parser==NULL){
        SimpleParser * avaliador  = new SimpleParser();
        avaliador->setDataSet(data->training,data->totalTraining);
        this->parser = avaliador;
    }else{
        this->parser = parser;
    }
}

void Search::setPopulationReplace(PopulationReplacement * popReplace){
    if(popReplace == NULL){
        this->replacer = new SimpleReplace();
    }else{
        this->replacer = popReplace;
    }
}

void Search::setIndividuoBuilder(IndividuoBuilder * indBuilder){
    if(indBuilder == NULL){
        this->individuoBuilder = new SimpleIndividuoBuilder();
    }else{
        this->individuoBuilder = indBuilder;
    }
}

void Search::setMutation(Mutation * opMutation){
    if(opMutation==NULL){
        mutationOperator = new SimpleMutation();
    }else{
        mutationOperator = opMutation;
    }
}

void Search::setCrossover(Crossover * opCrossover){
    if(opCrossover==NULL){
        crossoverOperator = new SimpleCrossover();
    }else{
        crossoverOperator = opCrossover;
    }
}

void Search::setSelection(Selection * seletor){
    if(seletor==NULL){
        this->seletor = new TournamentSelection();
    }else{
        this->seletor = seletor;
    }
}

/** Print Functions **/
void Search::printParameters(){
    cout << endl;
    cout << "************* PARAMETERS **************" << endl;
    cout << "*   GENERATIONS    " << conf->generations << endl;
    cout << "*   POP SIZE       " << conf->popSize << endl;
    cout << "*   ELITISM        " << conf->elitism << endl;
    cout << "*   MAXDEEP        " << conf->MAXDEEP << endl;
    cout << "*   CROSSOVER RATE " << conf->crossoverRate << endl;
    cout << "*   MUTATION RATE  " << conf->mutationRate << endl;
    cout << "*   INDIVIDUO      " << individuoBuilder->nameIndividuo() << endl;
    cout << "*   PARSER         " << parser->nameParser() << endl;
    cout << "***************************************" << endl << endl;
}

void Search::printResult(){
    cout << "--------------Results--------------" << endl;
    pop[0]->print();
//    cout <<  "SERIE TREINO" << endl;
    parser->printResult(pop[0]);
//    cout <<  "\nSERIE VALIDAÇÃO" << endl;
    parserValidation->printResult(pop[0]);
//    cout <<  "\n\nSERIE TESTE" << endl;
    parserTest->printResult(pop[0]);
}

void Search::printBestIndividuo(){

        pop[0]->print();
//        cout << " (" << pop[0]->fitness << ") " << endl;
//        for(int m = 0; m < conf->numTree; m++){
//            cout << "   f" << m << "() = (" << pop[0]->trees[m]->fitness << ") ";
//            pop[0]->trees[m]->root->print();
////            cout << "leastSquare=[";
////            for(int j = 0; j < pop[0]->trees[m]->leastSquareSize; j++)
////                cout << pop[0]->trees[m]->leastSquare[j] << ", ";
////            cout << "]";
//        }
        cout << endl;
}

 bool Search::SortPopulationFitness(Subject* a, Subject* b){
     //cout << "FITNESS: " << a->trees[0]->fitness << " - " << b->trees[0]->fitness << endl;
     return a->trees[0]->fitness < b->trees[0]->fitness;
 }
 bool Search::SortPopulationFitnessValidation(Subject* a, Subject* b){
    return a->fitnessValidation < b->fitnessValidation;
 }

Search::~Search()
{
    //dtor
}
