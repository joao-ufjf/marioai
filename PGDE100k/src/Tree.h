#ifndef TREE_H
#define TREE_H

#include "No.h"
#include "Configures.h"
#include <iostream>
#include <vector>
#include <tuple>

class Tree {
  public:
    Tree();
    Tree(No* n);
    virtual ~Tree();
    No* root;
    vector<No*> nonTerminals;
    vector<No*> targetedNonTerminals;
    vector<tuple<double,double> > linearModel;
    double fitness;

//        double * leastSquare = NULL;
//        int leastSquareSize;

    // DE
    int constantsSize;
    double* constants;

    No* subTree();
    No* targetSubTree(No* n);
    No* getSubTree(int i);
    void replaceAllC(double* constants);
    void replaceAllConst();
    void nonTerminalCount(No* n);
    void targetedNonTerminalCount(No* n, No* m);
    void update();
    void update(No* n);
    Tree * clone();
    No* clone(No * n);
    void print();
    string str();
    void printInfix();
    int Constants(double* initial, int pos, No* n);

  protected:
  private:
};

#endif // TREE_H
