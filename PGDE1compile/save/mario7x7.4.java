//geracao 99 level: 2 fit: 2970.02
 if( landscape[11+ -1 ][11+ -3 ] != -11 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( landscape[11+ -3 ][11+ 0 ] != 16 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_LEFT ] = true ;
 if( enemies[11+ 3 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_DOWN ] = true ;
 } } } } }else{ action[ Mario.KEY_DOWN ] = false ;
 } if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_JUMP ] = true ;
 if( observation.isMarioOnGround() ){ if( enemies[11+ -2 ][11+ 3 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = true ;
 } }else{ action[ Mario.KEY_SPEED ] = false ;
 } } action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } }