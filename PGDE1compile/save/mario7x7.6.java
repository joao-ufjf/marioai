//geracao 99 level: 2 fit: 1886.82
 if( observation.isMarioOnGround() ){ if( landscape[11+ -3 ][11+ 2 ] != 20 ){ action[ Mario.KEY_JUMP ] = false ;
 if( enemies[11+ -1 ][11+ -2 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } if( landscape[11+ 0 ][11+ -3 ] != 20 ){ action[ Mario.KEY_DOWN ] = false ;
 } }else{ if( enemies[11+ 1 ][11+ 2 ] != Sprite.KIND_RED_KOOPA_WINGED ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( observation.mayMarioJump() ){ if( enemies[11+ -3 ][11+ 1 ] != Sprite.KIND_GREEN_KOOPA ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 } } } } } }