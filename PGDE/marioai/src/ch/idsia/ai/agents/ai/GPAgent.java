package ch.idsia.ai.agents.ai;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.utils.MathX;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy
 * Date: Apr 8, 2009
 * Time: 4:03:46 AM
 * Package: ch.idsia.ai.agents.ai;
 */
public class GPAgent extends BasicAIAgent implements Agent
{
    int trueJumpCounter = 0;
    int trueSpeedCounter = 0;

    public GPAgent()
    {
        super("GPAgent");
        reset();
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfButtons];
        //action[Mario.KEY_RIGHT] = true;
        //action[Mario.KEY_SPEED] = true;
        trueJumpCounter = 0;
        trueSpeedCounter = 0;
    }

    private boolean DangerOfGap(byte[][] levelScene)
    {
        for (int x = 9; x < 13; ++x)
        {
            boolean f = true;
            for(int y = 12; y < 22; ++y)
            {
                if  (levelScene[y][x] != 0)
                    f = false;
            }
            if (f && levelScene[12][11] != 0)
                return true;
        }
        return false;
    }

    private byte[][] decode(String estate)
    {
        byte[][] dstate = new byte[Environment.HalfObsWidth*2][Environment.HalfObsHeight*2];
        for (int i = 0; i < dstate.length; ++i)
            for (int j = 0; j < dstate[0].length; ++j)
                dstate[i][j] = 2;
        int row = 0;
        int col = 0;
        int totalBitsDecoded = 0;

        for (int i = 0; i < estate.length(); ++i)
        {
            char cur_char = estate.charAt(i);
            if (cur_char != 0)
            {
                //MathX.show(cur_char);
            }
            for (int j = 0; j < 16; ++j)
            {
                totalBitsDecoded++;
                if (col > Environment.HalfObsHeight*2 - 1)
                {
                    ++row;
                    col = 0;
                }

//                if ((MathX.pow(2,j) & cur_char) != 0)
                if ((MathX.powsof2[j] & cur_char) != 0)
                {

                    try{
                        dstate[row][col] = 1;
//                        show(cur_char);
                    }
                    catch (Exception e)
                    {
                        //System.out.println("row = " + row);
                        //System.out.println("col = " + col);
                    }
                }
                else
                {
                    dstate[row][col] = 0; //TODO: Simplify in one line of code.
                }
                ++col;
                if (totalBitsDecoded == 484)
                    break;
            }
        }

        //System.out.println("totalBitsDecoded = " + totalBitsDecoded);
        return dstate;
    }


    public boolean[] getAction(Environment observation)
    {
        //TODO: Discuss increasing diffuculty for handling the gaps.
        // this Agent requires observation.

        assert(observation != null);
        byte[][] levelScene = observation.getCompleteObservation(/*1, 0*/);
        float[] marioPos = observation.getMarioFloatPos();
        float[] enemiesPos = observation.getEnemiesFloatPos();
	byte[][] enemies = observation.getEnemiesObservation(); // default: ZLevelEnemies = 0
	byte[][] landscape = observation.getLevelSceneObservation();// default: ZLevelScene = 1  
	
  if(levelScene[ 1 ][ 8 ] != ( 1 - 2 )){ action[ Mario.KEY_JUMP ] = false ; action[ Mario.KEY_SPEED ] = false ; action[ Mario.KEY_SPEED ] = false ; action[ Mario.KEY_JUMP ] = true ; action[ Mario.KEY_JUMP ] = true ; if(levelScene[ 14 ][ 0 ] != ( 2 + 2 )){ action[ Mario.KEY_SPEED ] = false ; }else{ if(levelScene[ 10 ][ 7 ] != ( 0 - 1 )){ if(levelScene[ 7 ][ 12 ] != ( 0 - 1 )){ if(levelScene[ 20 ][ 21 ] != ( 0 + 0 )){ if(levelScene[ 9 ][ 9 ] != ( 0 + 2 )){ action[ Mario.KEY_SPEED ] = true ; }else{ action[ Mario.KEY_JUMP ] = false ; } action[ Mario.KEY_JUMP ] = false ; if(levelScene[ 1 ][ 12 ] != ( 1 + 1 )){ if(levelScene[ 9 ][ 1 ] != ( 2 + 2 )){ action[ Mario.KEY_JUMP ] = true ; action[ Mario.KEY_RIGHT ] = false ; }else{ action[ Mario.KEY_RIGHT ] = true ; } }else{ if(levelScene[ 18 ][ 17 ] != ( 0 + 0 )){ action[ Mario.KEY_JUMP ] = false ; }else{ action[ Mario.KEY_JUMP ] = false ; } action[ Mario.KEY_JUMP ] = true ; action[ Mario.KEY_RIGHT ] = true ; } }else{ if(levelScene[ 20 ][ 16 ] != ( 2 - 2 )){ action[ Mario.KEY_SPEED ] = true ; }else{ action[ Mario.KEY_RIGHT ] = false ; } if(levelScene[ 20 ][ 2 ] != ( 0 - 0 )){ action[ Mario.KEY_SPEED ] = true ; }else{ action[ Mario.KEY_JUMP ] = true ; } } }else{ if(levelScene[ 14 ][ 6 ] != ( 1 + 2 )){ action[ Mario.KEY_RIGHT ] = false ; }else{ if(levelScene[ 1 ][ 2 ] != ( 2 + 0 )){ action[ Mario.KEY_RIGHT ] = false ; if(levelScene[ 18 ][ 0 ] != ( 2 - 2 )){ action[ Mario.KEY_RIGHT ] = true ; }else{ action[ Mario.KEY_SPEED ] = false ; } }else{ if(levelScene[ 8 ][ 2 ] != ( 0 + 2 )){ if(levelScene[ 20 ][ 17 ] != ( 0 + 0 )){ if(levelScene[ 3 ][ 9 ] != ( 2 - 2 )){ action[ Mario.KEY_RIGHT ] = false ; action[ Mario.KEY_JUMP ] = false ; }else{ action[ Mario.KEY_SPEED ] = false ; action[ Mario.KEY_SPEED ] = true ; } }else{ if(levelScene[ 6 ][ 5 ] != ( 1 + 0 )){ action[ Mario.KEY_JUMP ] = false ; action[ Mario.KEY_SPEED ] = false ; }else{ action[ Mario.KEY_JUMP ] = true ; } } }else{ action[ Mario.KEY_JUMP ] = false ; } } } } }else{ if(levelScene[ 15 ][ 7 ] != ( 0 - 0 )){ action[ Mario.KEY_JUMP ] = false ; }else{ action[ Mario.KEY_SPEED ] = true ; } action[ Mario.KEY_JUMP ] = false ; action[ Mario.KEY_RIGHT ] = true ; if(levelScene[ 2 ][ 9 ] != ( 1 - 2 )){ if(levelScene[ 14 ][ 7 ] != ( 0 + 2 )){ action[ Mario.KEY_SPEED ] = true ; action[ Mario.KEY_SPEED ] = true ; action[ Mario.KEY_JUMP ] = false ; action[ Mario.KEY_SPEED ] = false ; if(levelScene[ 17 ][ 15 ] != ( 0 - 2 )){ action[ Mario.KEY_SPEED ] = false ; }else{ action[ Mario.KEY_RIGHT ] = false ; } action[ Mario.KEY_SPEED ] = true ; }else{ action[ Mario.KEY_RIGHT ] = false ; } }else{ if(levelScene[ 12 ][ 4 ] != ( 2 + 0 )){ if(levelScene[ 21 ][ 21 ] != ( 2 - 1 )){ action[ Mario.KEY_SPEED ] = true ; }else{ action[ Mario.KEY_RIGHT ] = false ; if(levelScene[ 17 ][ 18 ] != ( 2 - 1 )){ action[ Mario.KEY_JUMP ] = true ; action[ Mario.KEY_JUMP ] = false ; }else{ action[ Mario.KEY_SPEED ] = false ; action[ Mario.KEY_SPEED ] = false ; } } }else{ action[ Mario.KEY_RIGHT ] = false ; action[ Mario.KEY_SPEED ] = false ; action[ Mario.KEY_RIGHT ] = true ; action[ Mario.KEY_SPEED ] = false ; action[ Mario.KEY_JUMP ] = true ; } } } } }else{ action[ Mario.KEY_SPEED ] = true ; } 		
	//Begin of BGPAgent
	return action;
    }
}
