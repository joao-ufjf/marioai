#include <iostream>
#define _USE_MATH_DEFINES // for C++
#include <cmath>
#include "Search.h"
#include "vector"
#include <time.h>
#include <conio.h>
#include <ctime>
#include <fstream>
#include <algorithm>
#ifndef M_PI
#define M_PI 3.14159265358979323846
#endif

using namespace std;

/// <summary>
/// Metodo para gerar numero real aleatorio dentro do intervalo
/// </summary>
double fRand(double fMin, double fMax)
{
	double f = (double)rand() / RAND_MAX;
	return fMin + f * (fMax - fMin);
}

/// <summary>
/// Metodo para que cada dimensao da posicao do vetor passada seja iniciada aleatoriamente
/// </summary>
void initialSolutions(double *population, int dim, double limInf, double limSup){
	for (int i = 0; i < dim; i++){
		population[i] = fRand(limInf, limSup);
	}
}

/// <summary>
/// Metodo para realizar a diferenca vetorial de dois parametros e armazena-los em result
/// </summary>
void vectorialDifference(double *result, double *second, double *third, int dim){
	for (int i = 0; i < dim; i++){

		result[i] = second[i] - third[i];
	}
}

/// <summary>
/// Metodo para realizar a soma vetorial de dois parametros e armazena-los em result
/// </summary>
void vectorialSum(double *result, double *second, double *third, int dim){
	for (int i = 0; i < dim; i++){
		result[i] = second[i] + third[i];
	}
}

/// <summary>
/// Metodo para realizar o calculo de aptidao de uma populacao e armazenar no vetor fitness
/// </summary>
void evaluate(double** population, double* fitness, int p_size, int dim){
	//For para calcular todas fitness da população
	for (int i = 0; i < p_size; i++)
	{
		//For para calcular o fitness do candidato atual
		fitness[i] = 0;
		for (int j = 0; j < dim; j++)
		{
			//FUNCAO OBJETIVO
			fitness[i] += pow(population[i][j], 2) - 10 * cos(2 * M_PI*population[i][j]) + 10;
			//fitness[i] += ((population[i][j] * -1) * sin(sqrt(abs(population[i][j]))));
			//fitness[i] += pow(population[i][j], 4) - (16 * pow(population[i][j], 2)) + (5 * population[i][j]);
		}
		//fitness[i] = fitness[i] * 1 / 100;
	}
}

/// <summary>
/// Metodo para realizar o calculo de aptidao de um individuo e retorna em um double
/// </summary>
double evaluateOne(double* individuo, int dim){
	double fitness = 0;
	for (int j = 0; j < dim; j++)
	{
		//FUNCAO OBJETIVO
		fitness += pow(individuo[j], 2) - 10 * cos(2 * M_PI*individuo[j]) + 10;
		//fitness += ((individuo[j] * -1) * sin(sqrt(abs(individuo[j]))));
		//fitness += pow(individuo[j], 4) - (16 * pow(individuo[j], 2)) + (5 * individuo[j]);
	}
	//fitness = fitness / 100;
	return fitness;
}

/// <summary>
/// Metodo para realizar a operacao de mutacao
/// </summary>
void mutation(double** mut_pop, double** population, int dim, double limInf, double limSup, int p_size, double mut_factor){
	for (int j = 0; j < p_size; j++){
		//Primeiramente tres individuos sao selecionados aleatoriamente
		int first = (int)fRand(0, p_size-1);
		int second = (int)fRand(0, p_size-1);
			while(first == second)
				second = (int)fRand(0, p_size-1);
		int third = (int)fRand(0, p_size-1);
		while (first == third || second == third)
			third = (int)fRand(0, p_size-1);

		//Temos entao os tres indices escolhidos para mutacao
		//Agora fazemos a diferenca vetorial do segundo pelo terceiro para entao armazenarmos no result
		vectorialDifference(mut_pop[j], population[second], population[third], dim);

		//Agora deve ser realizada a multiplicacao do resultado pelo fator de mutacao
		for (int i = 0; i < dim; i++){
			mut_pop[j][i] = mut_factor * mut_pop[j][i];
		}

		//Por ultimo deve ser realizada a perturbacao sob o primeiro individuo
		vectorialSum(population[first], population[first], mut_pop[j], dim);
	}
	//Repeticao para garantir apenas solucoes factíveis
	for (int k = 0; k < p_size; k++){
		for (int i = 0; i < dim; i++){
			if (mut_pop[k][i] < limInf){
				mut_pop[k][i] = limInf;
			}
			else if (mut_pop[k][i] > limSup){
				mut_pop[k][i] = limSup;
			}
		}
	}
}

/// <summary>
/// Metodo para realizar a operacao de cruzamento
/// </summary>
void crossover(double **cross_pop, double** population, double** mut_pop, double cross_factor, int dim, int p_size){
	//Repeticao para preencher todos individuos da cross_pop
	for (int i = 0; i < p_size; i++){
		//Primeiramente dois individuos sao selecionados aleatoriamente
		int first = (int)fRand(0, p_size-1);
		int second = (int)fRand(0, p_size-1);

		//Repeticao para preencher um individuo da cross_pop
		for (int j = 0; j < dim; j++){
			double rand_val = fRand(0, 1);
			//Se o random for menor que a taxa, entao eh transmitido o gene mutado
			if (cross_factor > rand_val)
				cross_pop[i][j] = mut_pop[second][j];
			else
				cross_pop[i][j] = population[first][j];
		}
	}
}

/// <summary>
/// Metodo para realizar a selecao dos melhores entre cross_pop e population
/// </summary>
int selection(double **population, double **cross_pop, int dim, int p_size){
	double* fitness = new double[p_size];
	double* fitnessCross = new double[p_size];
	evaluate(population, fitness, p_size, dim);
	evaluate(cross_pop, fitnessCross, p_size, dim);

	//Agora temos fitness de ambas populacoes
	for (int i = 0; i < p_size; i++){
		if (fitness[i] > fitnessCross[i]){
			for (int j = 0; j < dim; j++){
				population[i][j] = cross_pop[i][j];
			}
		}
	}

	evaluate(population, fitness, p_size, dim);
	int best = 0;
	for (int i = 0; i < p_size; i++){
		if (fitness[best] > fitness[i])
			best = i;
	}
	cout << endl;
	return best;
}

int main()
{
	clock_t tStart = clock();
	srand(time(NULL));
	double limInf = -5.12;
	double limSup = 5.12;
	int p_size = 10;
	int dim = 30;
	double mut_factor = 0.5;
	double cross_factor = 0.8;
	double** population = new double*[p_size];
	double** mut_pop = new double*[p_size];
	double** cross_pop = new double*[p_size];
	double* best = new double[dim];
	ofstream myfile;
	myfile.open("C:\\TESTE\\plot.dat", std::ios_base::app);

	for (int i = 0; i < p_size; i++){
		population[i] = new double[dim];
		mut_pop[i] = new double[dim];
		cross_pop[i] = new double[dim];
		initialSolutions(population[i], dim, limInf, limSup);

	}

	for (int j = 0; j < dim; j++)
		best[j] = population[0][j];

	double time = 0;
	int count = 1;
	while(time < 1){
		//Chamada da mutacao
		mutation(mut_pop, population, dim, limInf, limSup, p_size, mut_factor);

		//Chamada de cruzamento
		crossover(cross_pop, population, mut_pop, cross_factor, dim, p_size);

		//Chamada de selecao
		int best_index = selection(population, cross_pop, dim, p_size);

		if (evaluateOne(best, dim) > evaluateOne(population[best_index], dim)){
			//Colocamos o melhor da populacao em best
			for (int j = 0; j < dim; j++){
				best[j] = population[best_index][j];
			}
		}
		cout << count << ' ' << evaluateOne(best, dim) << endl;
		myfile.flush();
		count++;
		time = (double)(clock() - tStart) / CLOCKS_PER_SEC;

	}
	getch();
	return 0;
}
