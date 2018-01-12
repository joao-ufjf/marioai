//geracao 6 level: 0 fit: 220.134
 if( observation.isMarioOnGround() ){ if( landscape[11+ 0 ][11+ 0 ] != 1 ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( landscape[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_DOWN ] = false ;
 if( observation.isMarioOnGround() ){ if( landscape[11+ 1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 } } } if( enemies[11+ 1 ][11+ 1 ] != 1 ){ if( enemies[11+ 1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } } } }else{ if( landscape[11+ 1 ][11+ 1 ] != 1 ){ if( landscape[11+ 1 ][11+ 0 ] != 1 ){ if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ 1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 } if( landscape[11+ 0 ][11+ 1 ] != 1 ){ action[ Mario.KEY_SPEED ] = true ;
 } } } }else{ if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ if( enemies[11+ 1 ][11+ -1 ] != 1 ){ action[ Mario.KEY_DOWN ] = true ;
 } } if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } }else{ if( landscape[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } } }