//geracao 99 level: 3 fit: 3179
 if( observation.mayMarioJump() ){ if( enemies[11+ -3 ][11+ -3 ] != Sprite.KIND_RED_KOOPA_WINGED ){ if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 } } } if( enemies[11+ -1 ][11+ -1 ] != Sprite.KIND_GOOMBA_WINGED ){ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_SPEED ] = false ;
 } } if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 if( landscape[11+ 2 ][11+ 1 ] != 16 ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 } action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 if( observation.mayMarioJump() ){ if( landscape[11+ -1 ][11+ -3 ] != -11 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } } } }else{ if( enemies[11+ -3 ][11+ 2 ] != Sprite.KIND_GOOMBA ){ if( observation.isMarioOnGround() ){ if( landscape[11+ 3 ][11+ -2 ] != 0 ){ action[ Mario.KEY_RIGHT ] = false ;
 } action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( enemies[11+ -3 ][11+ 3 ] != Sprite.KIND_SPIKY_WINGED ){ if( enemies[11+ -1 ][11+ 3 ] != Sprite.KIND_GREEN_KOOPA ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( enemies[11+ -3 ][11+ 0 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_JUMP ] = false ;
 } } if( landscape[11+ -2 ][11+ -2 ] != 20 ){ if( landscape[11+ 2 ][11+ -1 ] != 0 ){ action[ Mario.KEY_SPEED ] = false ;
 } } } } if( observation.mayMarioJump() ){ if( landscape[11+ 0 ][11+ 3 ] != -11 ){ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 } }