#include "Tree.h"

Tree::Tree() {
    No* n = new No(-1, 0, "<expr>", 0);
    if(rand() % 2 == 0){
        grammar->derivate(n);
    }else{
        int deep = (rand() % conf->MAXDEEP) + 1;
        while(deep <= 2) {
            deep = (rand() % conf->MAXDEEP) + 1;
        }
        grammar->createInitialPopulation(n, deep);
    }
    root = n;
//    cout << "Criando arvore com raiz " << root->mask << endl;
    update();
    fitness = 0;
}
Tree::Tree(No* n) {
    //ctor
    root = n;
    update();
    fitness = 0;
}

void Tree::replaceAllC(double* constants){
    root->replaceAllC(constants, 0);
}

void Tree::replaceAllConst(){
    constantsSize = root->replaceAllConst(0);
    update();
}

void Tree::print() {
    root->print();
}

//void Tree::printInfix(){
//    stack<string> stk;
//    for(tuple<double, double> t : linearModel) {
//        stringstream str;
//        int var = (int)get<0>(t);
//        if( var == conf->constant ) { // constant
//            stk.push(get<1>(t));
//        } else if( var == conf->variable ) { // variable;
//            stk.push(dat[(int)get<1>(t)]);
//        } else if( var == conf->bynaryArithmeticOperators) { // bynaryArithmeticOperators
//            double b = stk.top();
//            stk.pop();
//            double a = stk.top();
//            stk.pop();
//            stk.push(Operate(get<0>(t), get<1>(t), a, b));
//        } else if( var ==  conf->unaryArithmeticOperators) { // unaryArithmeticOperators
//            double a = stk.top();
//            stk.pop();
//            stk.push(Operate(get<0>(t), get<1>(t), a));
//        } else if( var == conf->binaryLogicalOperators) { // binaryLogicalOperators
//            double b = stk.top();
//            stk.pop();
//            double a = stk.top();
//            stk.pop();
//            stk.push(Operate(get<0>(t), get<1>(t), a, b));
//        } else if( var == conf->unaryLogicalOperators) { // unaryLogicalOperators
//            double a = stk.top();
//            stk.pop();
//            stk.push(Operate(get<0>(t), get<1>(t), a));
//        } else if( var == conf->comparisonOperators) { // comparisonOperators
//            double b = stk.top();
//            stk.pop();
//            double a = stk.top();
//            stk.pop();
//            stk.push(Operate(get<0>(t), get<1>(t), a, b));
//        } else if( var == conf->programOperators) {
//            //programOperators
//        } else if( var == conf->adjustedCoeficient ) { // constant
////            cout << "   " << coeficientCount << endl;
//            if(s1->constants != NULL)
//                stk.push(s1->constants[model - 1][coeficientCount]);
//            else
//                stk.push(1);
////            cout << s1->constants[model - 1][coeficientCount] << " " << coeficientCount << endl;
//            coeficientCount++;
//        }
//    }
//
//    return stk.top();
//}

No* Tree::subTree() {
    return nonTerminals.at(rand() % nonTerminals.size()); // returns a random subtree
};

No* Tree::targetSubTree(No* n) {
    targetedNonTerminalCount(n, root);
    if(targetedNonTerminals.size() > 0)
        return targetedNonTerminals.at(rand() % targetedNonTerminals.size());
    return NULL;
};

void Tree::targetedNonTerminalCount(No* n, No* m) {
    if(n->type == m->type &&
            n->value == m->value &&
            n->deep + m->height < conf->MAXDEEP &&
            m->deep + n->height < conf->MAXDEEP)
        targetedNonTerminals.push_back(m);
    for(No* p : m->sons)
        targetedNonTerminalCount(n, p);
}

void Tree::nonTerminalCount(No* n) {
    if(n->type == NONTERMINAL) {
        nonTerminals.push_back(n);
    } else {
        linearModel.push_back(make_tuple(n->type,n->value));
    }
    for(No* m : n->sons)
        nonTerminalCount(m);
}

Tree * Tree::clone() {
    No * n = clone(root);
    Tree * t = new Tree(n);
    t->update();
    return t;
}

void Tree::update() {
    nonTerminals.clear();
    linearModel.clear();
    constantsSize = 0;
    update(root);
}

void Tree::update(No* n) {
    if(n->type == NONTERMINAL) {
        nonTerminals.push_back(n);
        n->height = 0;

        for(No* m : n->sons) {
            m->deep = n->deep + 1;
            update(m);

            if(m->height + 1 > n->height)
                n->height = m->height + 1;
        }
    } else {
        //DE
        if(n->type == conf->adjustedCoeficient | n->type == 0)
            constantsSize++;
        n->height = 0;
        //cout << "1: " << n->type << " 2: " << n->value << endl;
        //cin.get();
        linearModel.push_back(make_tuple(n->type,n->value));
    }
}

No* Tree::clone(No* n) {
    No* m = n->clone();

    for(No* f : n->sons) {
        m->addSon(clone(f));
    }

    return m;
}

string Tree::str(){
    stringstream model;
    root->str(model);
    return model.str();
}

Tree::~Tree() {
    //dtor
    delete root;
#ifdef debug
    cout << "deletando ARVORE" << endl;
    cin.get();
#endif // debug
    nonTerminals.clear();
    targetedNonTerminals.clear();
    linearModel.clear();
//    if(leastSquare!=NULL)
//        delete [] leastSquare;

}

int Tree::Constants(double* initial, int pos, No* n){
    if(n->type == 0){
        initial[pos] = n->value;
//        cout << initial[pos] << " " << pos << endl;
        pos++;
    }
    for(No* m : n->sons)
        pos = Constants(initial, pos, m);
    return pos;
}
