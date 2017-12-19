#ifndef DIFFERENCIALEVOLUTION_H
#define DIFFERENCIALEVOLUTION_H

#define _USE_MATH_DEFINES // for C++
#include <cmath>
#include "vector"
#include <time.h>
#include <ctime>
#include <iostream>
#include <fstream>
#include <algorithm>
#include "RK4LSIndividuo.h"
#include "Parser.h"
#include "SimpleIndividuo.h"

#include <random>

#ifndef M_PI
#define M_PI 3.14159265358979323846
#endif

using namespace std;

class DifferencialEvolution {
  public:
    DifferencialEvolution();
    virtual ~DifferencialEvolution();

    void Optimize(Subject* ind, Parser* parser);
    void initialSolutions(double** population, int* dim, double limInf, double limSup, double *initialIndividual);
    double fRand(double fMin, double fMax);
    void vectorialDifference(double *result, double *second, double *third, int dim);
    void vectorialSum(double *result, double *second, double *third, int dim);
    int evaluate(double*** population, double* fitness, int p_size, int* dim);
    void mutation(double*** mut_pop, double*** population, int *dim, int p_size, double mut_factor);
    void crossover(double ***cross_pop, double*** population, double*** mut_pop, double cross_factor, int *dim, int p_size);
    int selection(double ***population, double ***cross_pop, double* fitness, double* fitnessCross, int *dim, int p_size);
    void replace_all_c(Subject* s, double* constants);

  protected:

  private:
    SimpleIndividuo* ind;
    Parser* parser;

    int best;
    double bestFit;

    std::default_random_engine* generator;

    double* fitness;

    int p_size = 10;
    int* dim;
    double mut_factor = 0.8;
    double cross_factor = 0.9;
    double*** population;
    double*** mut_pop;
    double*** cross_pop;
//        double* best;
};

#endif // DIFFERENCIALEVOLUTION_H
