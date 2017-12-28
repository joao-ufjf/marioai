#include "SimpleReplace.h"

SimpleReplace::SimpleReplace() {

}
void SimpleReplace::Replace(Subject **pop) {
    for(int i = conf->popSize * conf->elitism, j = 0; i < conf->popSize; i++, j++) {
        swap(pop[i], pop[conf->popSize + j]);
    }
}

SimpleReplace::~SimpleReplace() {

}
