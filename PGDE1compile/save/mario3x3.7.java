//geracao 99 level: 2 fit: 1221.73
 if( landscape[11+ 1 ][11+ -1 ] != 0 ){ if( landscape[11+ 1 ][11+ 1 ] != -10 ){ if( landscape[11+ -1 ][11+ -1 ] != -11 ){ if( observation.isMarioOnGround() ){ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_JUMP ] = false ;
 } if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_SPIKY ){ action[ Mario.KEY_SPEED ] = true ;
 } }else{ if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_SPEED ] = false ;
 } action[ Mario.KEY_LEFT ] = true ;
 } } } }else{ action[ Mario.KEY_SPEED ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_GOOMBA ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 } } action[ Mario.KEY_DOWN ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 }else{ if( landscape[11+ -1 ][11+ -1 ] != 20 ){ if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_RED_KOOPA_WINGED ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 } if( landscape[11+ 0 ][11+ 0 ] != 0 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } } } }