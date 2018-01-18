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
public class 
  action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 if( landscape[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_JUMP ] = false ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_SPEED ] = true ;
 if( landscape[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 } } action[ Mario.KEY_JUMP ] = false ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } action[ Mario.KEY_DOWN ] = false ;
 if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 if( enemies[11+ -1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } } if( enemies[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 if( enemies[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( observation.mayMarioJump() ){ if( landscape[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } action[ Mario.KEY_JUMP ] = false ;
 } if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 }else{ if( landscape[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_LEFT ] = false ;
 } if( enemies[11+ 0 ][11+ -1 ] != 1 ){ if( landscape[11+ -1 ][11+ 0 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } } if( observation.isMarioOnGround() ){ if( enemies[11+ 0 ][11+ -1 ] != 1 ){ if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } action[ Mario.KEY_DOWN ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 } } }  extends BasicAIAgent implements Agent
{
	
    int trueJumpCounter = 0;
    int trueSpeedCounter = 0;
    
    public 
