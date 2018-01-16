//geracao 99 level: 0 fit: 300.134
 if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ if( landscape[11+ 1 ][11+ 0 ] != 21 ){ action[ Mario.KEY_DOWN ] = false ;
 } action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_DOWN ] = false ;
 } if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_RED_KOOPA_WINGED ){ if( observation.isMarioOnGround() ){ if( enemies[11+ 1 ][11+ -1 ] != Sprite.KIND_GOOMBA ){ action[ Mario.KEY_SPEED ] = false ;
 } if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } }else{ if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_JUMP ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } } if( landscape[11+ 0 ][11+ 1 ] != 21 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 } } } if( observation.isMarioOnGround() ){ if( landscape[11+ 1 ][11+ 1 ] != -10 ){ if( landscape[11+ 1 ][11+ 1 ] != 16 ){ if( landscape[11+ 1 ][11+ 0 ] != 21 ){ action[ Mario.KEY_LEFT ] = true ;
 } } }else{ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_BULLET_BILL ){ if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } } }