//geracao 99 level: 2 fit: 3126.52
 if( landscape[11+ -2 ][11+ 1 ] != -11 ){ if( enemies[11+ -1 ][11+ 1 ] != Sprite.KIND_BULLET_BILL ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 } if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_RED_KOOPA_WINGED ){ action[ Mario.KEY_JUMP ] = false ;
 } } if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ if( enemies[11+ -1 ][11+ -1 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_DOWN ] = true ;
 } }else{ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 } } if( observation.mayMarioJump() ){ if( enemies[11+ 2 ][11+ -1 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_SPEED ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } if( observation.mayMarioJump() ){ if( landscape[11+ -1 ][11+ 2 ] != 16 ){ action[ Mario.KEY_LEFT ] = true ;
 } } if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 } if( landscape[11+ 0 ][11+ -1 ] != 20 ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 } } }