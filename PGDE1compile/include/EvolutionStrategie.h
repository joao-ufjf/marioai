#ifndef EVOLUTIONSTRATEGIE_H
#define EVOLUTIONSTRATEGIE_H

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

class EvolutionStrategie
{
    public:
        EvolutionStrategie();
        void Optimize(Subject* s, Parser* parser);
        virtual ~EvolutionStrategie();
        double evaluate(double** population);
        double** mutate_problem(double** parentProblem, double** parentStrategy, int dimension_index);
        double** mutate_strategy(double** parentStrategy, int dimension_index);
        void replace_all_c(Subject* s, double* constants);


    protected:

    private:
        SimpleIndividuo* ind;
        Parser* parser;

        std::default_random_engine* generator;

        int* dim;
        double** child;
        double** childStd;
        double*** population;
        double*** populationStd;
        double*** children;
        double*** childrenStd;
        int tamLambda;
        int tamMi = 1;
};

#endif // EVOLUTIONSTRATEGIE_H
