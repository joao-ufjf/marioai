//geracao 99 level: 2 fit: 2462.96
 if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ if( enemies[11+ 1 ][11+ -2 ] != 1 ){ if( observation.mayMarioJump() ){ if( landscape[11+ -1 ][11+ -3 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( enemies[11+ 2 ][11+ 3 ] != 1 ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 } } } if( observation.isMarioOnGround() ){ if( landscape[11+ 1 ][11+ -2 ] != 1 ){ if( enemies[11+ 2 ][11+ 0 ] != 1 ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } action[ Mario.KEY_LEFT ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } } }else{ if( landscape[11+ 3 ][11+ 2 ] != 1 ){ if( enemies[11+ -3 ][11+ 2 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( enemies[11+ 2 ][11+ 3 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 if( landscape[11+ -1 ][11+ 1 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 } if( landscape[11+ 3 ][11+ 3 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } } } }else{ if( landscape[11+ -1 ][11+ -2 ] != 1 ){ if( enemies[11+ 0 ][11+ 0 ] != 1 ){ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 if( enemies[11+ 2 ][11+ 3 ] != 1 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } action[ Mario.KEY_SPEED ] = true ;
 }else{ if( observation.isMarioOnGround() ){ if( enemies[11+ -1 ][11+ 1 ] != 1 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 } } } } if( landscape[11+ -2 ][11+ -1 ] != 1 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ 3 ] != 1 ){ action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } if( enemies[11+ 3 ][11+ 0 ] != 1 ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 } } }