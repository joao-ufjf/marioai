//geracao 99 level: 3 fit: 2676.45
 if( enemies[11+ -1 ][11+ 0 ] != Sprite.KIND_GOOMBA_WINGED ){ if( observation.isMarioOnGround() ){ if( landscape[11+ -1 ][11+ 1 ] != 20 ){ if( landscape[11+ 1 ][11+ 0 ] != 21 ){ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 } } }else{ if( landscape[11+ -1 ][11+ 1 ] != 21 ){ if( landscape[11+ 1 ][11+ 0 ] != 20 ){ if( landscape[11+ 0 ][11+ 0 ] != 20 ){ action[ Mario.KEY_DOWN ] = true ;
 } } } } if( landscape[11+ 0 ][11+ 1 ] != 21 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ 1 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } } }else{ if( observation.mayMarioJump() ){ if( enemies[11+ 1 ][11+ 0 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_LEFT ] = false ;
 } action[ Mario.KEY_LEFT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 }else{ if( enemies[11+ -1 ][11+ 0 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_DOWN ] = false ;
 } action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 } } action[ Mario.KEY_SPEED ] = true ;
 if( landscape[11+ 1 ][11+ 1 ] != -11 ){ if( observation.mayMarioJump() ){ if( enemies[11+ -1 ][11+ 0 ] != Sprite.KIND_RED_KOOPA ){ if( landscape[11+ -1 ][11+ 1 ] != 21 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 } } } } }