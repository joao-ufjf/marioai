//geracao 99 level: 2 fit: 2905.57
 if( landscape[11+ -2 ][11+ -1 ] != 1 ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( landscape[11+ 1 ][11+ -1 ] != 1 ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( enemies[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } } } } action[ Mario.KEY_DOWN ] = false ;
 if( enemies[11+ 0 ][11+ -2 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } if( enemies[11+ -1 ][11+ 2 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } if( enemies[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_SPEED ] = true ;
 } }else{ if( observation.mayMarioJump() ){ if( landscape[11+ 2 ][11+ 0 ] != 1 ){ if( landscape[11+ -1 ][11+ -1 ] != 1 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } } } if( landscape[11+ -2 ][11+ 0 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 } if( landscape[11+ -2 ][11+ -1 ] != 1 ){ if( enemies[11+ 0 ][11+ 2 ] != 1 ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } } }else{ if( landscape[11+ -1 ][11+ 2 ] != 1 ){ if( landscape[11+ -2 ][11+ 0 ] != 1 ){ if( observation.isMarioOnGround() ){ if( enemies[11+ 2 ][11+ 2 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 } } }else{ if( enemies[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_SPEED ] = false ;
 } } }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } }