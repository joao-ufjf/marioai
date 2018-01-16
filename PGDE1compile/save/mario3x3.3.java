//geracao 99 level: 0 fit: 636.134
 if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 if( landscape[11+ 0 ][11+ 1 ] != -10 ){ if( landscape[11+ 0 ][11+ -1 ] != -11 ){ action[ Mario.KEY_LEFT ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 if( enemies[11+ -1 ][11+ 1 ] != Sprite.KIND_SPIKY ){ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } }else{ action[ Mario.KEY_JUMP ] = true ;
 } }else{ action[ Mario.KEY_JUMP ] = true ;
 } }