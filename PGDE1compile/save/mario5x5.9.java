//geracao 99 level: 1 fit: 3403
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } } if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_RED_KOOPA ){ if( observation.mayMarioJump() ){ if( landscape[11+ 0 ][11+ -1 ] != -11 ){ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ if( observation.mayMarioJump() ){ if( enemies[11+ -2 ][11+ -1 ] != Sprite.KIND_SPIKY_WINGED ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 } } if( enemies[11+ 1 ][11+ 2 ] != Sprite.KIND_SPIKY_WINGED ){ if( landscape[11+ 2 ][11+ -2 ] != -10 ){ action[ Mario.KEY_LEFT ] = false ;
 } } if( landscape[11+ 1 ][11+ 1 ] != -10 ){ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_RIGHT ] = true ;
 if( landscape[11+ 1 ][11+ -1 ] != 21 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_RIGHT ] = true ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } } if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ 1 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_RIGHT ] = true ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 } action[ Mario.KEY_JUMP ] = true ;
 } }else{ if( landscape[11+ 0 ][11+ -1 ] != 0 ){ if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ -2 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_RIGHT ] = true ;
 } } } } }