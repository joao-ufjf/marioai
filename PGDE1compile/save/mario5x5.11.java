//geracao 73 level: 2 fit: 1131.98
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 }else{ if( landscape[11+ 2 ][11+ 1 ] != 0 ){ if( observation.isMarioOnGround() ){ if( landscape[11+ -1 ][11+ 1 ] != -10 ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ if( landscape[11+ 0 ][11+ -2 ] != 20 ){ action[ Mario.KEY_SPEED ] = false ;
 } } } if( landscape[11+ -2 ][11+ 1 ] != 20 ){ if( observation.mayMarioJump() ){ if( enemies[11+ 2 ][11+ 1 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_JUMP ] = false ;
 } } }else{ action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( landscape[11+ -1 ][11+ 2 ] != 21 ){ if( enemies[11+ 1 ][11+ 1 ] != Sprite.KIND_GOOMBA_WINGED ){ if( enemies[11+ -1 ][11+ 1 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_DOWN ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } }else{ action[ Mario.KEY_JUMP ] = false ;
 } action[ Mario.KEY_JUMP ] = true ;
 } } if( landscape[11+ 0 ][11+ 2 ] != 21 ){ if( enemies[11+ 1 ][11+ -1 ] != Sprite.KIND_GOOMBA ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 if( enemies[11+ -1 ][11+ -1 ] != Sprite.KIND_GREEN_KOOPA_WINGED ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } } } }