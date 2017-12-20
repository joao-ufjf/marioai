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
//    cout << s->trees[0]->str() << endl;
//    GPAgent << AGPAgent.str() << s->str() << BGPAgent.str();

//    system("cd marioai \n ant > garbage \n cd classes \n java ch.idsia.scenarios.Play ch.idsia.ai.agents.ai.ForwardAgent > out\n");
    string str = "cd marioai \n ant > garbage \n cd classes \n java ch.idsia.scenarios.CompetitionScore ch.idsia.ai.agents.ai.ForwardAgent ";
    str = str + to_string(rand());
    str = str + " > out\n";
    system(str.c_str());

    ifstream arq("marioai/classes/out");
    string scorestr;
    double score;

    arq >> scorestr;
    arq.close();
    score = atof(scorestr.c_str());
    cout << score << endl;
    return score;
}

MarioParser::~MarioParser()
{
    //dtor
}
