#include "SimpleIndividuo.h"

SimpleIndividuo::SimpleIndividuo(bool inicializa) {
    if(inicializa == true) {
        for(int j = 0 ; j < conf->numTree; j++) {
            addTree(new Tree());
        }
    } else {
        //cout << "Inicializa == false " << endl;
        //cin.get();
    }
}
string SimpleIndividuo::nameIndividual() {
    return "SimpleIndividuo";
}

void SimpleIndividuo::print() {
    for(int m = 0; m < conf->numTree; m++) {
        cout << "   f" << m << "() = (" << trees[m]->fitness << ") ";
        trees[m]->root->print();
//        cout << "[";
//        for(int j = 0; j < trees[m]->constantsSize; j++)
//            cout << constants[m][j] << ", ";
//        cout << "]";
    }
    cout << endl;

}

//string SimpleIndividuo::str() {
//    stringstream model;
//    trees[0]->root->str(model);
//    return model.str();
//}

Subject* SimpleIndividuo::clone() {
    //cout << "Clone " << endl;
    Subject* s = new SimpleIndividuo(false);

    for(int i = 0; i < conf->numTree; i++) {
        s->trees.push_back(trees.at(i)->clone());
    }
    s->fitness = fitness;
    s->fitnessValidation = fitnessValidation;
    s->fitnessTest = fitnessTest;

    return s;
}

SimpleIndividuo::~SimpleIndividuo() {
    //cout << "Destrutor SimpleIndividuo" << endl;
    // cin.get();

    if(constants != NULL){
        for(int i = 0; i < conf->numTree; i++){
            delete [] constants[i];
        }
        delete [] constants;
    }

    for(Tree* t : trees)
        delete t;
    trees.clear();
}
