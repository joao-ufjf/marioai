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
    ///cria o arquivo do controlador
        ///verificar se realmente precisa do stringstream pra ler o buif dos arquivos
    stringstream GPAgent;
//    GPAgent << AGPAgent.str() << s->str() << BGPAgent.str();
    ofstream agent("marioai/src/ch/idsia/ai/agents/ai/GPAgent.java");
//    cout << s->trees[0]->str() << endl;
    agent << AGPAgent.str() << " " << s->trees[0]->str() << " " << BGPAgent.str();
    agent.close();

    ///Compila e executa o emulador
//    system("cd marioai \n ant > garbage \n cd classes \n java ch.idsia.scenarios.Play ch.idsia.ai.agents.ai.ForwardAgent > out\n");
//    string str = "cd marioai \n ant > garbage \n cd classes \n java ch.idsia.scenarios.CompetitionScore ch.idsia.ai.agents.ai.GPAgent ";
//    string str = "cd marioai \n ant > garbage \n cd classes \n java ch.idsia.scenarios.Play ch.idsia.ai.agents.ai.GPAgent ";
    string str = "cd marioai \n ant >> garbage \n cd classes \n java ch.idsia.scenarios.GPPlay ch.idsia.ai.agents.ai.GPAgent ";
//    str = str + to_string(rand());
    str = str + to_string(conf->seed);
    str = str + " ";
    str = str + to_string(conf->level);
    str = str + " > out\n";
    system(str.c_str());

    ///lê o score
    ifstream arq("marioai/classes/out");
    string scorestr;
    double score;
    arq >> scorestr;
    arq.close();
    score = atof(scorestr.c_str());
//    cout << score << endl;
//    cin.get();

    return score;
}

MarioParser::~MarioParser()
{
    //dtor
}
