//geracao 99 level: 2 fit: 1771
 if( landscape[11+ 0 ][11+ 0 ] != 20 ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 } action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( enemies[11+ 1 ][11+ -1 ] != Sprite.KIND_GOOMBA_WINGED ){ if( landscape[11+ -1 ][11+ -1 ] != 21 ){ action[ Mario.KEY_DOWN ] = true ;
 } } } } action[ Mario.KEY_DOWN ] = false ;
 if( landscape[11+ -1 ][11+ -1 ] != -10 ){ action[ Mario.KEY_LEFT ] = false ;
 } if( landscape[11+ 1 ][11+ 0 ] != 20 ){ if( landscape[11+ 0 ][11+ 1 ] != 21 ){ action[ Mario.KEY_RIGHT ] = true ;
 } } if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_RIGHT ] = false ;
 if( observation.mayMarioJump() ){ if( landscape[11+ 0 ][11+ -1 ] != -11 ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( landscape[11+ -1 ][11+ -1 ] != 21 ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 } } }else{ action[ Mario.KEY_DOWN ] = false ;
 } } }