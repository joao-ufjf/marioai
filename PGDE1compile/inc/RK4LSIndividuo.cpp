#include "RK4LSIndividuo.h"

RK4LSIndividuo::RK4LSIndividuo(bool inicializa) {
    if(inicializa == true) {
        for(int i = 0 ; i < conf->numTree; i++) {
            addTree(new Tree());
        }
    }
}

string RK4LSIndividuo::nameIndividual() {
    return "RK4LSIndividuo";
}


Subject* RK4LSIndividuo::clone() {
    //cout << "CLONE:" << endl;
    Subject* k = new RK4LSIndividuo(false);
    k->fitness = fitness;
    k->fitnessTest = fitnessTest;
    k->fitnessValidation = fitnessValidation;

    for(int i = 0; i < conf->numTree; i++) {
        k->trees.push_back(trees.at(i)->clone());
    }
    k->fitness = fitness;

    return k;
}

void RK4LSIndividuo::print() {
    cout << fitness << " " << fitnessValidation << " " << fitnessTest << " " <<  endl;
    for(int m = 0; m < conf->numTree; m++) {
        cout << "   f" << m << "() = (" << trees[m]->fitness << ") ";
        trees[m]->root->print();

        cout << "leastSquare=[";
        if(leastSquare)
            for(int j = 0; j < leastSquareSize[m]; j++)
                cout << leastSquare[m][j] << ", ";
        cout << "]";

        cout << "_c_=" << trees[m]->constantsSize << " =[";
        if(constants)
            for(int j = 0; j < trees[m]->constantsSize; j++)
                cout << constants[m][j] << ", ";
        cout << "]" << endl;
    }
    cout << endl;
}

RK4LSIndividuo::~RK4LSIndividuo() {

    if(leastSquare !=NULL) {
        for (int i = 0; i < conf->numTree; i++) {
            if( leastSquare[i] != NULL )
                delete [] leastSquare[i];
        }
        delete[]leastSquare;

        //leastSquare = NULL;
    }
    ///COMENTEI ISSO QUANDO ACERTEI O DE
//    if(leastSquareSize!=NULL){
//        delete[]leastSquareSize;
//        //leastSquareSize = NULL;
//    }

    if(constants != NULL) {
        for(int i = 0; i < conf->numTree; i++)
            delete [] constants[i];
        delete [] constants;
    }


    if(rk4 != NULL) {
        for(int i = 0; i < rk4Size; i++)
            delete [] rk4[i];
        delete [] rk4;
    }



    for(Tree* t : trees)
        delete t;
    trees.clear();

}
