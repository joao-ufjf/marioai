//geracao 3 level: 2 fit: 3594.01
 action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 if( enemies[11+ 1 ][11+ 0 ] != 1 ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_DOWN ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( enemies[11+ -1 ][11+ 0 ] != 1 ){ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 } } } } action[ Mario.KEY_RIGHT ] = true ;
