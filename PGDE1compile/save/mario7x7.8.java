//geracao 99 level: 2 fit: 2905.57
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 if( enemies[11+ -1 ][11+ 1 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_RIGHT ] = true ;
 } if( landscape[11+ -1 ][11+ 3 ] != 16 ){ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( enemies[11+ -1 ][11+ 1 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ if( enemies[11+ -1 ][11+ -1 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 } } if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_BULLET_BILL ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 } } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } }