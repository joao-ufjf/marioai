//geracao 99 level: 2 fit: 3467
 if( observation.isMarioOnGround() ){ if( landscape[11+ 1 ][11+ 1 ] != 1 ){ if( enemies[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } if( enemies[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 } if( landscape[11+ -1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 } if( observation.mayMarioJump() ){ if( enemies[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( landscape[11+ -1 ][11+ -1 ] != 1 ){ if( enemies[11+ 0 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ if( enemies[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } }else{ if( landscape[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } } } }