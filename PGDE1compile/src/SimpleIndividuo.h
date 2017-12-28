#ifndef SIMPLEINDIVIDUO_H
#define SIMPLEINDIVIDUO_H
#include "Subject.h"
#include <sstream>

class SimpleIndividuo : public Subject {
  public:
    SimpleIndividuo(bool inicializa = true);
    virtual Subject* clone();// retorna uma copia da instancia atual
    virtual string nameIndividual();
    virtual void print();
    virtual ~SimpleIndividuo();
    double ** constants = NULL;
    bool LocalSearch = false;

  protected:

  private:
};

#endif // SIMPLEINDIVIDUO_H
