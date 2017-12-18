#ifndef MARIOPARSER_H
#define MARIOPARSER_H

#include "SimpleParser.h"
#include <strstream>
#include <fstream>

using namespace std;

class MarioParser : public SimpleParser
{
    public:
        MarioParser();
        virtual ~MarioParser();

        virtual string nameParser(){return "Mario Parser";}
        virtual double Evaluate(Subject* s);
        virtual void Optimize(Subject* s){};
        virtual double Operate(int opType, int opValue, double a, double b = NULL, double c = NULL){};
        virtual void printResult(Subject * s) {};


        stringstream AGPAgent, BGPAgent;

    protected:
    private:
};

#endif // MARIOPARSER_H
