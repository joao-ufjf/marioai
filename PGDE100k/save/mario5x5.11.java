//geracao 12 level: 2 fit: 1126.53
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = false ;
 } } if( enemies[11+ -1 ][11+ -2 ] != Sprite.KIND_BULLET_BILL ){ if( enemies[11+ 1 ][11+ -2 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 } }else{ if( landscape[11+ -1 ][11+ -2 ] != -10 ){ action[ Mario.KEY_SPEED ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } }else{ if( landscape[11+ 1 ][11+ 0 ] != 16 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } if( landscape[11+ -1 ][11+ 1 ] != -11 ){ action[ Mario.KEY_RIGHT ] = true ;
 } } }