#ifndef RK4AGPARSER_H
#define RK4SAGARSER_H
#include "SimpleParser.h"
#include "RK4LSIndividuo.h"

class RK4AGParser : public SimpleParser {
  public:
    RK4AGParser();
    virtual double Evaluate(Subject* s);
    virtual void Optimize(Subject* s) {}

    virtual string nameParser();
    virtual void setDataSet(double ** x,int tam);
    virtual ~RK4AGParser();
    void printData();
  protected:

  private:
    /*Ajustar tamanho do passo*/
    double AuxEvaluate(Subject* s, int model, double* dat, double* increments);
    double** RKEvaluate(Subject* s, double* initial, int vars, double h, int iterations);
    double ** RKEvaluateVariable(Subject* s, double** matrix, int vars, double h, int iterations);
};

#endif // RK4AGPARSER_H
