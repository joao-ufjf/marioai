package ch.idsia.ai.agents.ai;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 25, 2009
 * Time: 12:30:41 AM
 * Package: ch.idsia.ai.agents.ai;
 */
public class GPAgent implements Agent
{
    protected boolean action[] = new boolean[Environment.numberOfButtons];
    protected String name = "Instance_of_BasicAIAgent._Change_this_name";

    public GPAgent(String s)
    {
        setName(s);
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfButtons];// Empty action
    }

    public boolean[] getAction(Environment observation)
    {
        byte[][] levelScene = observation.getCompleteObservation(/*1, 0*/);
        float[] marioPos = observation.getMarioFloatPos();
        float[] enemiesPos = observation.getEnemiesFloatPos();
	//End of AGPAgent

	//Begin of BGPAgent
	return action;
    }

    public AGENT_TYPE getType()
    {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {        return name;    }

    public void setName(String Name) { this.name = Name;    }
}
