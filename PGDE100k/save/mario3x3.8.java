//geracao 99 level: 0 fit: 1004.13
 action[ Mario.KEY_SPEED ] = false ;
 if( landscape[11+ 1 ][11+ 0 ] != 0 ){ if( landscape[11+ 1 ][11+ -1 ] != -10 ){ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } action[ Mario.KEY_LEFT ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( landscape[11+ 1 ][11+ 1 ] != 16 ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_LEFT ] = true ;
 } action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 } } }