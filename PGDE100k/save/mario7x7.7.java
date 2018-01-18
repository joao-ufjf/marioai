//geracao 99 level: 1 fit: 1232.25
 if( enemies[11+ 2 ][11+ 3 ] != Sprite.KIND_SPIKY ){ if( landscape[11+ -3 ][11+ -2 ] != 16 ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } } if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( enemies[11+ 1 ][11+ 2 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_SPEED ] = false ;
 } } action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } } if( enemies[11+ -3 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ if( observation.mayMarioJump() ){ if( landscape[11+ -1 ][11+ 3 ] != 0 ){ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( enemies[11+ 1 ][11+ -1 ] != Sprite.KIND_RED_KOOPA ){ if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 } }else{ if( landscape[11+ 1 ][11+ -3 ] != 0 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ if( landscape[11+ -1 ][11+ -1 ] != -10 ){ action[ Mario.KEY_SPEED ] = false ;
 } } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 } } } } }