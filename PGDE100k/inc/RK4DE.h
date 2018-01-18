#ifndef RK4DE_H
#define RK4DE_H

#include "SimpleParser.h"
#include "RK4LSIndividuo.h"
#include "DifferencialEvolution.h"

class RK4DE : public SimpleParser
{
    public:
        RK4DE();
        virtual double Evaluate(Subject* s);
        virtual double EvaluateDE(Subject* s);
        virtual string nameParser();
        virtual void setDataSet(double ** x,int tam);
        virtual ~RK4DE();
        void printData();
        void printResult(Subject* s);
    protected:

    private:
        /*Ajustar tamanho do passo*/
        double AuxEvaluate(Subject* s, int model, double* dat, double* increments);
        double** RKEvaluate(Subject* s, double* initial, int vars, double h, int iterations);
        double ** RKEvaluateVariable(Subject* s, double** matrix, int vars, double h, int iterations);
};

#endif // RK4DE_H
