package ch.idsia.scenarios;

import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.agents.AgentsPool;
import ch.idsia.ai.agents.human.HumanKeyboardAgent;
import ch.idsia.ai.tasks.ProgressTask;
import ch.idsia.ai.tasks.Task;
import ch.idsia.tools.CmdLineOptions;
import ch.idsia.tools.EvaluationOptions;

/**
 * Created by IntelliJ IDEA.
 * User: João Marcos
 * Date: Dec 26, 2017
 * Time: 07:10:43 AM
 */
public class GPPlay {

    public static void main(String[] args) {
        Agent controller = AgentsPool.load (args[0]);
        AgentsPool.addAgent(controller);
        EvaluationOptions options = new CmdLineOptions(new String[0]);
        options.setAgent(controller);
        Task task = new ProgressTask(options);
        options.setMaxFPS(true);
        options.setVisualization(true);
        options.setNumberOfTrials(1);
        options.setMatlabFileName("");
        options.setLevelRandSeed(Integer.parseInt(args[1]));
        options.setLevelDifficulty(Integer.parseInt(args[2]));
        task.setOptions(options);

        System.out.println (task.evaluate (controller)[0]);
	System.exit(1);
    }
}
