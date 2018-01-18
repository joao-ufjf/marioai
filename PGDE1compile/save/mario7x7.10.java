//geracao 99 level: 1 fit: 2962.38
 if( observation.isMarioOnGround() ){ if( enemies[11+ -2 ][11+ -2 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ if( enemies[11+ 3 ][11+ -2 ] != Sprite.KIND_SPIKY_WINGED ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 } } if( landscape[11+ 1 ][11+ 0 ] != 16 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_RIGHT ] = false ;
 } } if( observation.mayMarioJump() ){ if( landscape[11+ -3 ][11+ -1 ] != 20 ){ if( enemies[11+ 3 ][11+ -2 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ action[ Mario.KEY_JUMP ] = false ;
 } } }else{ if( landscape[11+ 2 ][11+ 1 ] != 16 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_LEFT ] = true ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 if( landscape[11+ 3 ][11+ -1 ] != -10 ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ if( landscape[11+ -2 ][11+ 1 ] != 0 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ if( observation.isMarioOnGround() ){ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 }else{ if( landscape[11+ 0 ][11+ -1 ] != 20 ){ if( landscape[11+ 2 ][11+ 2 ] != -10 ){ action[ Mario.KEY_RIGHT ] = true ;
 } } } }else{ action[ Mario.KEY_SPEED ] = true ;
 } } } }