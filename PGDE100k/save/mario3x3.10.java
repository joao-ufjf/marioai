//geracao 9 level: 0 fit: 220.134
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 } if( landscape[11+ -1 ][11+ 1 ] != 21 ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } }