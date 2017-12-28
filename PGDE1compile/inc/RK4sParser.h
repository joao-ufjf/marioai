#ifndef RK4SPARSER_H
#define RK4SPARSER_H
#include "SimpleParser.h"
#include "RK4LSIndividuo.h"
#include "DifferencialEvolution.h"

class RK4sParser : public SimpleParser {
  public:
    RK4sParser();
    virtual double Evaluate(Subject* s);
    virtual void Optimize(Subject* s);
    virtual string nameParser();
    virtual void setDataSet(double ** x,int tam);
    virtual ~RK4sParser();
    void printData();
    void printResult(Subject* s);
  protected:

  private:
    /*Ajustar tamanho do passo*/
    DifferencialEvolution* diffEvo;

    double AuxEvaluate(Subject* s, int model, double* dat, double* increments);
    double** RKEvaluate(Subject* s, double* initial, int vars, double h, int iterations);
    double ** RKEvaluateVariable(Subject* s, double** matrix, int vars, double h, int iterations);


};

#endif // RK4SPARSER_H
