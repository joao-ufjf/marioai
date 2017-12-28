//geracao 2 level: 0 fit: 220.134
 if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( landscape[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } }else{ if( enemies[11+ 1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }