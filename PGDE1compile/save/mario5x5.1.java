//geracao 99 level: 2 fit: 3829.67
 if( landscape[11+ 2 ][11+ -1 ] != 21 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ action[ Mario.KEY_RIGHT ] = true ;
 if( enemies[11+ 1 ][11+ -2 ] != Sprite.KIND_SPIKY_WINGED ){ if( enemies[11+ 1 ][11+ 1 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ if( enemies[11+ 2 ][11+ 0 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_JUMP ] = false ;
 } } } }