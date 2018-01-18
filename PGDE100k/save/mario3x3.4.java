//geracao 99 level: 1 fit: 3195
 if( landscape[11+ 0 ][11+ 1 ] != 20 ){ if( enemies[11+ -1 ][11+ 1 ] != Sprite.KIND_GREEN_KOOPA ){ if( enemies[11+ -1 ][11+ 0 ] != Sprite.KIND_SPIKY_WINGED ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_RED_KOOPA_WINGED ){ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 } } } if( observation.isMarioOnGround() ){ if( landscape[11+ -1 ][11+ -1 ] != 20 ){ if( landscape[11+ 0 ][11+ -1 ] != 0 ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_LEFT ] = false ;
 } }else{ action[ Mario.KEY_SPEED ] = false ;
 } if( observation.isMarioOnGround() ){ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } } if( landscape[11+ 0 ][11+ 1 ] != -10 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } } } if( observation.mayMarioJump() ){ if( landscape[11+ -1 ][11+ 1 ] != -11 ){ if( landscape[11+ 1 ][11+ 0 ] != -11 ){ if( landscape[11+ -1 ][11+ 0 ] != 16 ){ if( landscape[11+ 1 ][11+ 0 ] != 20 ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 } } }else{ if( landscape[11+ 1 ][11+ 1 ] != -11 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 } } } } }