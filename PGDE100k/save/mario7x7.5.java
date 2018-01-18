//geracao 99 level: 0 fit: 683
 if( landscape[11+ 0 ][11+ 2 ] != 16 ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( enemies[11+ 3 ][11+ 3 ] != Sprite.KIND_RED_KOOPA_WINGED ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( landscape[11+ 3 ][11+ -1 ] != 0 ){ action[ Mario.KEY_RIGHT ] = false ;
 } if( enemies[11+ 1 ][11+ -1 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } if( landscape[11+ 0 ][11+ -1 ] != -11 ){ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_SPIKY ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } if( landscape[11+ 3 ][11+ 2 ] != 16 ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } if( observation.mayMarioJump() ){ if( landscape[11+ 3 ][11+ -3 ] != 0 ){ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( landscape[11+ -3 ][11+ -2 ] != -11 ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } } } }