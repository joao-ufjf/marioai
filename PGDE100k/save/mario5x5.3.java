//geracao 99 level: 2 fit: 2559.94
 if( enemies[11+ 2 ][11+ 2 ] != Sprite.KIND_SPIKY_WINGED ){ if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_RED_KOOPA_WINGED ){ action[ Mario.KEY_RIGHT ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } action[ Mario.KEY_RIGHT ] = false ;
 } } action[ Mario.KEY_DOWN ] = false ;
 if( landscape[11+ -1 ][11+ -1 ] != 0 ){ action[ Mario.KEY_SPEED ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ if( landscape[11+ -1 ][11+ -2 ] != -10 ){ action[ Mario.KEY_RIGHT ] = true ;
 } if( landscape[11+ -1 ][11+ 0 ] != 21 ){ action[ Mario.KEY_SPEED ] = true ;
 } } if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_DOWN ] = true ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 } action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 } if( landscape[11+ -1 ][11+ 0 ] != 20 ){ if( landscape[11+ -2 ][11+ -2 ] != -11 ){ if( observation.mayMarioJump() ){ if( landscape[11+ 0 ][11+ 0 ] != 20 ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( enemies[11+ -2 ][11+ 2 ] != Sprite.KIND_GOOMBA_WINGED ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 } } } if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } }else{ action[ Mario.KEY_JUMP ] = false ;
 if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_RED_KOOPA ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 } } }