//geracao 99 level: 2 fit: 3467
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( enemies[11+ 2 ][11+ 0 ] != Sprite.KIND_GOOMBA ){ action[ Mario.KEY_DOWN ] = false ;
 } } } }else{ if( landscape[11+ 0 ][11+ -2 ] != 16 ){ if( enemies[11+ 0 ][11+ 2 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_SPIKY ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ if( landscape[11+ -1 ][11+ -1 ] != -11 ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 } } } if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 } } } if( landscape[11+ 0 ][11+ -1 ] != -10 ){ if( observation.mayMarioJump() ){ if( landscape[11+ 2 ][11+ 0 ] != -10 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ if( observation.mayMarioJump() ){ if( landscape[11+ 1 ][11+ -2 ] != -10 ){ if( landscape[11+ 2 ][11+ 1 ] != 21 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } } } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 } if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 } }else{ if( landscape[11+ 0 ][11+ 0 ] != 0 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } } if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 } } } }