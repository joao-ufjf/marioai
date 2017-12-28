#include "RK4DE.h"

RK4DE::RK4DE()
{
    //ctor
}
string RK4DE::nameParser(){
    return "RK4DE";
}

void RK4DE::setDataSet(double ** x,int tam){
    tamDataset = tam;
    dataset = x;
}

void RK4DE::printResult(Subject* s){
    RK4LSIndividuo * s1 = dynamic_cast<RK4LSIndividuo*>(s);
    double fit = 0;
    double ** serieRK = RKEvaluateVariable(s1,dataset,data->prediction + data->variables,dataset[1][0] - dataset[0][0],tamDataset);


    for(int i = 0 ; i < tamDataset; i++){
         for(int j = 0 ; j < data->prediction + data->variables; j++){
            cout << serieRK[i][j] ;
            if(j!=data->prediction + data->variables-1){
                cout << " ";
            }
         }
         cout << endl;
    }

}

double RK4DE::EvaluateDE(Subject* s){
    RK4LSIndividuo * s1 = dynamic_cast<RK4LSIndividuo*>(s);

//    DifferencialEvolution* de = new DifferencialEvolution(s, this);

    cin.get();

    double fit = 0;
    double ** serieRK = RKEvaluateVariable(s1,dataset,data->prediction + data->variables,dataset[1][0] - dataset[0][0],tamDataset);

    if(s1->rk4 != NULL){
        for(int i = 0; i < s1->rk4Size; i++)
            delete [] s1->rk4[i];
        delete [] s1->rk4;
    }
    s1->rk4 = serieRK;
    s1->rk4Size = tamDataset;

    //s1->fitness  = 0;
    for(int m = 0; m < conf->numTree; m++){
                    s1->trees[m]->fitness = 0;
                    for(int j = 0; j < tamDataset; j++){
                        s1->trees[m]->fitness  += double(pow(dataset[j][data->variables + m] - serieRK[j][data->variables + m], 2)/tamDataset);
                    }
                    if(std::isinf(s1->trees[m]->fitness) || std::isnan(s1->trees[m]->fitness))
                        s1->trees[m]->fitness = INFINITY;
                    fit += double(s1->trees[m]->fitness/conf->numTree);
    //                cout << " ===== " << s1->trees[m]->fitness << endl;
    }

//    for(int i = 0 ; i < tamDataset; i++){
//        for(int j = 0 ; j < data->prediction + data->variables; j++){
//            cout << serieRK[i][j] << " ";
//        }
//        cout << endl;
//
//    }
//    cin.get();


//    for(int i = 0 ; i < tamDataset; i++)
//        delete [] serieRK[i];
//    delete [] serieRK;
    //cout << "*fit " << fit << endl;
    return fit;
}

double RK4DE::Evaluate(Subject* s){
    RK4LSIndividuo * s1 = dynamic_cast<RK4LSIndividuo*>(s);

    cin.get();

    double fit = 0;
    double ** serieRK = RKEvaluateVariable(s1,dataset,data->prediction + data->variables,dataset[1][0] - dataset[0][0],tamDataset);

    if(s1->rk4 != NULL){
        for(int i = 0; i < s1->rk4Size; i++)
            delete [] s1->rk4[i];
        delete [] s1->rk4;
    }
    s1->rk4 = serieRK;
    s1->rk4Size = tamDataset;

    //s1->fitness  = 0;
    for(int m = 0; m < conf->numTree; m++){
                    s1->trees[m]->fitness = 0;
                    for(int j = 0; j < tamDataset; j++){
                        s1->trees[m]->fitness  += double(pow(dataset[j][data->variables + m] - serieRK[j][data->variables + m], 2)/tamDataset);
                    }
                    if(std::isinf(s1->trees[m]->fitness) || std::isnan(s1->trees[m]->fitness))
                        s1->trees[m]->fitness = INFINITY;
                    fit += double(s1->trees[m]->fitness/conf->numTree);
    //                cout << " ===== " << s1->trees[m]->fitness << endl;
    }

//    for(int i = 0 ; i < tamDataset; i++){
//        for(int j = 0 ; j < data->prediction + data->variables; j++){
//            cout << serieRK[i][j] << " ";
//        }
//        cout << endl;
//
//    }
//    cin.get();


//    for(int i = 0 ; i < tamDataset; i++)
//        delete [] serieRK[i];
//    delete [] serieRK;
    //cout << "*fit " << fit << endl;
    return fit;
}

double ** RK4DE::RKEvaluateVariable(Subject* s, double** matrix, int vars, double h, int iterations){

    double k[vars][4];
    double** r = new double*[iterations];
    for(int i = 0; i < iterations; i++)
        r[i] = new double[vars];

    for(int i = 0; i < vars; i++){
        r[0][i] = matrix[0][i];
    }

    //assuming initial[0] is x and initial[1 ... vars - 1] is f0(x) ... fn(x)

    for(int i = 0; i < iterations - 1; i++){
        double h = matrix[i+1][0] - matrix[i][0];

        double* increments = new double[vars];
        r[i + 1][0] = r[i][0] + h;

        // k0
        increments[0] = 0;
        for(int j = 1; j < vars; j++)
            increments[j] = 0;
        for(int j = 1; j < vars; j++) // s: modelos j:especific model r[i]:variables increments:vector
            k[j][0] = h * AuxEvaluate(s, j, r[i], increments);

        // k1
        increments[0] = h/2.0;
        for(int j = 1; j < vars; j++)
            increments[j] = k[j][0]/2.0;
        for(int j = 1; j < vars; j++)
            k[j][1] = h * AuxEvaluate(s, j, r[i], increments);

        // k2
        increments[0] = h/2.0;
        for(int j = 1; j < vars; j++)
            increments[j] = k[j][1]/2.0;
        for(int j = 1; j < vars; j++)
            k[j][2] = h * AuxEvaluate(s, j, r[i], increments);

        // k3
        increments[0] = h;
        for(int j = 1; j < vars; j++)
            increments[j] = k[j][2];
        for(int j = 1; j < vars; j++)
            k[j][3] = h * AuxEvaluate(s, j, r[i], increments);

        delete [] increments;



        for(int j = 1; j < vars; j++){
            r[i + 1][j] = r[i][j] + ((k[j][0] + 2*(k[j][1] + k[j][2]) + k[j][3]))/6.0;
        }

    }


    return r;

}



double** RK4DE::RKEvaluate(Subject* s, double* initial, int vars, double h, int iterations){
//    cout << "h = " << h << endl;
//    for(int i = 0; i < vars - 1; i++){
//        cout << "f" << i << " = ";
//        s->trees[i]->root->print();
//        cout << endl;
//    }

//    double k[vars][4];
    double k[vars][4];
    double** r = new double*[iterations];
    for(int i = 0; i < iterations; i++)
        r[i] = new double[vars];

    for(int i = 0; i < vars; i++){
        r[0][i] = initial[i];
//        cout << r[0][i] << " ";
    }
//    cout << endl;

    //assuming initial[0] is x and initial[1 ... vars - 1] is f0(x) ... fn(x)

    for(int i = 0; i < iterations - 1; i++){
        double* increments = new double[vars];
        r[i + 1][0] = r[i][0] + h;

        // k0
        increments[0] = 0;
        for(int j = 1; j < vars; j++)
            increments[j] = 0;
        for(int j = 1; j < vars; j++) // s: modelos j:especific model r[i]:variables increments:vector
            k[j][0] = h * AuxEvaluate(s, j, r[i], increments);

        // k1
        increments[0] = h/2.0;
        for(int j = 1; j < vars; j++)
            increments[j] = k[j][0]/2.0;
        for(int j = 1; j < vars; j++)
            k[j][1] = h * AuxEvaluate(s, j, r[i], increments);

        // k2
        increments[0] = h/2.0;
        for(int j = 1; j < vars; j++)
            increments[j] = k[j][1]/2.0;
        for(int j = 1; j < vars; j++)
            k[j][2] = h * AuxEvaluate(s, j, r[i], increments);

        // k3
        increments[0] = h;
        for(int j = 1; j < vars; j++)
            increments[j] = k[j][2];
        for(int j = 1; j < vars; j++)
            k[j][3] = h * AuxEvaluate(s, j, r[i], increments);

        delete [] increments;

//        for(int m = 1; m < vars; m++){
//            cout << "   ";
//            for(int l = 0; l < 4; l++)
//                cout << k[m][l] << " ";
//            cout << endl;
//        }


        for(int j = 1; j < vars; j++){
//            cout << r[i][j] + ((k[j][0] + 2*(k[j][1] + k[j][2]) + k[j][3]))/6.0 << " ";
            r[i + 1][j] = r[i][j] + ((k[j][0] + 2*(k[j][1] + k[j][2]) + k[j][3]))/6.0;
        }
//        cout << endl;

//        for(int j = 0; j < vars; j++)
//            cout << r[i + 1][j] << " ";
//        cout << endl;

//        cout << r[i + 1][0] << " ";
//
//        for(int j = 1; j < vars; j++){ // for every fn(x) calculate
//            k[0] = Evaluate(s, j, r[i], 0, 0);
//            k[1] = Evaluate(s, j, r[i], 0.5 * h, 0.5 * k[0]);
//            k[2] = Evaluate(s, j, r[i], 0.5 * h, 0.5 * k[1]);
//            k[3] = Evaluate(s, j, r[i], h, k[2]);
//
////            cout << "    For " << j << " " << k[0] << " " << k[1] << " " << k[2] << " " << k[3] << endl;
////            cout << "K[1...4] = " << k[0] << " " << k[1] << " " << k[2] << " " << k[3] << endl;
//
//            r[i + 1][j] = r[i][j] + (h * (k[0] + 2*(k[1] + k[2]) + k[3]))/6.0;
//            cout << r[i + 1][j] << " ";
//        }
//        cout << endl;
    }

//    for(int i = 0; i < iterations; i++)
//        delete [] r[i];
//    delete [] r;
    return r;
}



double RK4DE::AuxEvaluate(Subject* s, int model, double* dat, double* increments){
//    for(int i = 0; i < 3; i++)
//        cout << increments[i] << " e ";
//    cout << model << endl;
    RK4LSIndividuo * s1 = dynamic_cast<RK4LSIndividuo*>(s);
    int coeficientCount = 0;
    stack<double> stk;
    for(tuple<double, double> t : s->trees[model - 1]->linearModel){// -1 because model is the n-1 tree of s and n y ou fn(x)
        int var = (int)get<0>(t);
        if( var == conf->constant ) { // constant
            stk.push(get<1>(t));
        }
        else if( var == conf->variable ){ // variable;
            stk.push(dat[(int)get<1>(t)] + increments[(int)get<1>(t)]);
        }
        else if( var == conf->bynaryArithmeticOperators){ // bynaryArithmeticOperators
            double b = stk.top();
            stk.pop();
            double a = stk.top();
            stk.pop();
            stk.push(Operate(get<0>(t), get<1>(t), a, b));
        }
        else if( var ==  conf->unaryArithmeticOperators){ // unaryArithmeticOperators
            double a = stk.top();
            stk.pop();
            stk.push(Operate(get<0>(t), get<1>(t), a));
        }
        else if( var == conf->binaryLogicalOperators){ // binaryLogicalOperators
            double b = stk.top();
            stk.pop();
            double a = stk.top();
            stk.pop();
            stk.push(Operate(get<0>(t), get<1>(t), a, b));
        }
        else if( var == conf->unaryLogicalOperators){ // unaryLogicalOperators
            double a = stk.top();
            stk.pop();
            stk.push(Operate(get<0>(t), get<1>(t), a));
        }
        else if( var == conf->comparisonOperators){ // comparisonOperators
            double b = stk.top();
            stk.pop();
            double a = stk.top();
            stk.pop();
            stk.push(Operate(get<0>(t), get<1>(t), a, b));
        }
        else if( var == conf->programOperators){
            //programOperators
        }
        else if( var == conf->adjustedCoeficient ) { // constant
//            cout << "   " << coeficientCount << endl;
            stk.push(s1->constants[model - 1][coeficientCount]);
//            cout << s1->constants[model - 1][coeficientCount] << " " << coeficientCount << endl;
            coeficientCount++;
        }
    }
//    cout << "saiu" << endl;
//    cin.get();
    return stk.top();
}

void RK4DE::printData(){
    for(int i = 0 ; i < tamDataset; i++){
        for(int j = 0 ; j< data->variables + data->prediction; j++){
            cout << dataset[i][j] << " ";
        }
        cout << endl;
    }
}
RK4DE::~RK4DE()
{
    //dtor
}
