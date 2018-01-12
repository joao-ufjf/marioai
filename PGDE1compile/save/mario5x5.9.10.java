//geracao 99 level: 0 fit: 1164.13
 if( observation.isMarioOnGround() ){ if( enemies[11+ 1 ][11+ 2 ] != 1 ){ if( enemies[11+ 2 ][11+ 0 ] != 1 ){ if( landscape[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } }else{ action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ if( enemies[11+ 2 ][11+ 1 ] != 1 ){ action[ Mario.KEY_DOWN ] = true ;
 } } } if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 } } if( enemies[11+ 2 ][11+ 2 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } if( enemies[11+ -1 ][11+ 2 ] != 1 ){ if( enemies[11+ 1 ][11+ -1 ] != 1 ){ if( landscape[11+ 2 ][11+ 1 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 } } } } }