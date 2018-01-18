//geracao 99 level: 0 fit: 1004.13
 if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 if( landscape[11+ -2 ][11+ 1 ] != 21 ){ if( landscape[11+ 2 ][11+ -2 ] != -10 ){ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_GOOMBA ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 } }else{ if( landscape[11+ 0 ][11+ 0 ] != -11 ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } } } }else{ action[ Mario.KEY_SPEED ] = true ;
 } } }else{ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 if( enemies[11+ -1 ][11+ 2 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_SPEED ] = false ;
 }