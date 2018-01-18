//geracao 99 level: 1 fit: 3749.46
 action[ Mario.KEY_DOWN ] = true ;
 if( landscape[11+ 1 ][11+ 2 ] != 21 ){ if( landscape[11+ -3 ][11+ 3 ] != -11 ){ action[ Mario.KEY_DOWN ] = false ;
 if( landscape[11+ 3 ][11+ -2 ] != 21 ){ action[ Mario.KEY_SPEED ] = false ;
 } } }else{ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } } if( observation.mayMarioJump() ){ if( enemies[11+ -3 ][11+ 3 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_JUMP ] = true ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 } } }else{ if( landscape[11+ 0 ][11+ -1 ] != 0 ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_LEFT ] = true ;
 if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 } } action[ Mario.KEY_LEFT ] = false ;
