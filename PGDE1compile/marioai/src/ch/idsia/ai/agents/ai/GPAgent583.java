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
public class GPAgent583 extends BasicAIAgent implements Agent
{
	
    int trueJumpCounter = 0;
    int trueSpeedCounter = 0;
    
    public GPAgent583()
    {
        super("GPAgent583");
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
	
	 if( enemies[11+ 1 ][11+ 0 ] != 1 ){ if( observation.isMarioOnGround() ){ if( landscape[11+ 0 ][11+ -1 ] != 1 ){ if( enemies[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 if( landscape[11+ 1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( landscape[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } } } }else{ if( enemies[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 if( landscape[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 } } }else{ if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_DOWN ] = true ;
 } if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_DOWN ] = true ;
 }else{ if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } } if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.isMarioOnGround() ){ if( landscape[11+ -1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 } } if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 } } if( enemies[11+ 0 ][11+ 0 ] != 1 ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( enemies[11+ 1 ][11+ 1 ] != 1 ){ if( enemies[11+ 0 ][11+ 0 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } if( enemies[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } } } if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 }else{ if( landscape[11+ 1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( enemies[11+ -1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } if( enemies[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } if( landscape[11+ 1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 } } action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 if( landscape[11+ -1 ][11+ -1 ] != 1 ){ if( enemies[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 }else{ if( enemies[11+ 1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } } if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( landscape[11+ -1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } } }else{ if( enemies[11+ 1 ][11+ -1 ] != 1 ){ if( enemies[11+ 0 ][11+ 1 ] != 1 ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_DOWN ] = true ;
 } } 	
	//Begin of BGPAgent
	return action;
    }
}