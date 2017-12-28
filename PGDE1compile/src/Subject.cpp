#include "Subject.h"

Subject::Subject() {
    //cout << "subject set fit = 0 \n";
    fitness = INFINITY;
    fitnessTest = INFINITY;
    fitnessValidation = INFINITY;
    optimized = false;
}

void Subject::addTree(Tree* t) {
    trees.push_back(t);
}

Subject::~Subject() {
//   cout << "Destrutor Subject" << endl;
//   cin.get();
    for(Tree* t : trees)
        delete t;
    trees.clear();
    //
}
