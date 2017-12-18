#include "No.h"
#include <iostream>   // std::cout
#include <string>     // std::string, std::to_string

No::No() {
    //ctor
}

No::No(double t, double v, string m, int h) {
    type = t;
    value = v;
    mask = m;
    deep = h;
}

void No::print(int format) {
    for(int i = 0; i < format; i++)
        cout << " ";
    cout << height << " " << mask << endl;

    for(No* n : sons)
        n->print(format + 1);
}

int No::replaceAllC(double* constants, int index){
    if(type == 9){
        std::ostringstream strs;
        strs << constants[index];
        mask = strs.str();
        type = 0;
        value = constants[index++];
    }
    for(No* n : sons)
        index = n->replaceAllC(constants, index);
    return index;
}
//Deve ser realizada a contagem de todos os _c_ para que possa retornar quantas constantes ha atualmente
int No::replaceAllConst(int constantCount){
    int counter = 0;
    if(type == 0){
        mask = "_c_";
        type = 9;
        value = 0;
        counter++;
    }
    for(No* n : sons)
        counter += n->replaceAllConst(constantCount);
    return counter;
}

void No::print() {
    if(type != -1)
        cout << mask << " ";
        //cout << "[" << mask << "," << type << "] ";

    for(No* n : sons)
        n->print();
}

void No::addSon(No* n) {
    sons.push_back(n);
}

void No::erase() {
    for(No* n : sons)
        delete n;
    sons.clear();
}

void No::str(std::ostream& model) {
     if(type != -1)
        model << " " << mask;
    for(No* n : sons)
        n->str(model);
}

No* No::clone() {
    No* n = new No(type, value, mask, deep);
    return n;
}

No::~No() {
#ifdef debug
    cout << "DELETANDO NO" << endl;
    cin.get();
#endif // debug

    for(No* n : sons)
        delete n;
    sons.clear();

}

void No::destrutor(No * p) {
    if(p == NULL) {
        delete p;
    } else {
        for(int i = 0; i < p->sons.size(); i++) {
            p->sons[i]->father = NULL;
            destrutor(p->sons[i]);
        }
    }
}
