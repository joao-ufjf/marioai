//geracao 99 level: 0 fit: 1548.76
 if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } } } if( enemies[11+ 0 ][11+ -2 ] != Sprite.KIND_GOOMBA ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ -2 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_DOWN ] = true ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ if( landscape[11+ 1 ][11+ -1 ] != 0 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } } if( enemies[11+ 2 ][11+ 2 ] != Sprite.KIND_SPIKY_WINGED ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 } action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 } } }