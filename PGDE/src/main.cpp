#include <iostream>
#include "Database.h"
#include "Grammar.h"
#include "No.h"
#include "Configures.h"
#include "Search.h"
#include "Configures.h"
#include "SimpleParser.h"
#include "../inc/ParserDerivadas.h"
#include "../inc/LeastSquareParser.h"
#include "../inc/LSDerivadasParser.h"
#include "IndividuoBuilder.h"
#include "LeastSquareIndividuoBuilder.h"
#include "../inc/RK4LSDerivadasParser.h"
#include "../inc/RK4LSIndividuoBuilder.h"
#include "Subject.h"
#include "RK4sParser.h"
#include "../inc/RK4AGParser.h"
#include "RK4LSDParser.h"
#include "MarioParser.h"
#include <sstream>
//#include "DifferencialEvolution.h"

using namespace std;

#define simpleParser
//#define RK4Parser
int main(int argc, char** argv){
    cout << "Hello GP-ufjf!" << endl;
//    return 0;
    conf = new Configures();

    conf->approach = atoi(argv[5]);
	srand(atoi(argv[1]));

    //set parametros
    conf->MAXDEEP = 15;

    conf->generations = 1000;
    conf->popSize = 50;
    conf->elitism = 0.1;
    conf->crossoverRate = 0.9;
    conf->mutationRate = 0.9;

    conf->NUM_THREADS = 1;

    /// Loading database and grammar
	data = new Database(argv[3]);
	data->loadGroup(argv[4]); // 1000.grp pra 1000, pgDE pra 50
//	grammar = new Grammar("input/grammar/itaDE.dat"); // itaDE.dat para DE, ita.dat para apenas PG
	grammar = new Grammar(argv[2]); // itaDE.dat para DE, ita.dat para apenas PG
#define normal

#ifdef normal

    conf->numTree = data->prediction; // seta o numero de variaveis a serem preditas. dependente do problema a ser tratado
    cout << "NumTree: " << conf->numTree << endl;
//    grammar->print();
//    cin.get();
   // data->print();
    double** dados_treino = data->values;
    //cout << "total training " << data->totalTraining << " total test " << data->totalTest << " total validation "<< data->totalValidation << endl;

     IndividuoBuilder * individuoBuilder = NULL;

    /// Setting parser

    #ifdef simpleParser
        SimpleParser * parser = new MarioParser();
        SimpleParser * parserTest = new MarioParser();
        SimpleParser * parserValidation = new MarioParser();
        individuoBuilder = new SimpleIndividuoBuilder();
    #endif

//    cout << "Seed : " << seed << endl;
    cout << "TotalTrain : " << data->totalTraining << endl;
    cout << "TotalTest : " << data->totalTest << endl;
    cout << "TotalValidation : " << data->totalValidation << endl;


    parser->setDataSet(data->training,data->totalTraining);
    parserTest->setDataSet(data->test,data->totalTest);
    parserValidation->setDataSet(data->validation,data->totalValidation);

    Search* s = new Search(parser, NULL, individuoBuilder);
    s->setParserTest(parserTest);
    s->setParserValidation(parserValidation);
    s->stepByStep = false;

    s->evolveMario();
#endif

    return 0;
}
