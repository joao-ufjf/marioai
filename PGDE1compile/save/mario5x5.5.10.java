//geracao 99 level: 2 fit: 1270.42
 if( enemies[11+ 1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ if( observation.isMarioOnGround() ){ if( landscape[11+ 2 ][11+ -2 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } }else{ if( landscape[11+ 0 ][11+ -2 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 } } } } if( landscape[11+ -2 ][11+ 1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 if( enemies[11+ -1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_SPEED ] = true ;
 if( enemies[11+ 2 ][11+ -2 ] != 1 ){ if( observation.mayMarioJump() ){ if( enemies[11+ -1 ][11+ 2 ] != 1 ){ if( landscape[11+ 1 ][11+ -2 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = true ;
 } } }else{ if( landscape[11+ -2 ][11+ -2 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } } action[ Mario.KEY_DOWN ] = true ;
 } }