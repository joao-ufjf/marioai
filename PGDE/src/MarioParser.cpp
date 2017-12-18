#include "MarioParser.h"

MarioParser::MarioParser()
{
    ifstream AGPAgentFile, BGPAgentFile;
    AGPAgentFile.open("AGPAgent.parc");
    BGPAgentFile.open("BGPAgent.parc");

    AGPAgent << AGPAgentFile.rdbuf();
    BGPAgent << BGPAgentFile.rdbuf();
}

double MarioParser::Evaluate(Subject* s){
    stringstream GPAgent;
    cout << s->trees[0]->str() << endl;
//    GPAgent << AGPAgent.str() << s->str() << BGPAgent.str();


//    system("cd marioai\nant\njava ch.idsia.scenarios.Play ch.idsia.agents.ai.GPAgent");

    return 0;
}

MarioParser::~MarioParser()
{
    //dtor
}
