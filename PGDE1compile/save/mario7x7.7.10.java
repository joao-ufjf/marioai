//geracao 99 level: 2 fit: 3723
 if( landscape[11+ 1 ][11+ -2 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } if( enemies[11+ -1 ][11+ 0 ] != 1 ){ if( enemies[11+ 2 ][11+ -3 ] != 1 ){ if( enemies[11+ -3 ][11+ 1 ] != 1 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 } } } if( landscape[11+ -3 ][11+ 3 ] != 1 ){ if( observation.isMarioOnGround() ){ if( landscape[11+ 1 ][11+ -3 ] != 1 ){ if( enemies[11+ 1 ][11+ -3 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 } } } }else{ if( enemies[11+ 2 ][11+ 0 ] != 1 ){ if( enemies[11+ 2 ][11+ 0 ] != 1 ){ if( landscape[11+ 2 ][11+ -3 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } }else{ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 } } } }else{ if( enemies[11+ -2 ][11+ -2 ] != 1 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } }else{ action[ Mario.KEY_JUMP ] = true ;
 } }