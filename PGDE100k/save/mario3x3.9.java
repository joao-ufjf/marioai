//geracao 99 level: 1 fit: 3998.15
 if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_RED_KOOPA ){ if( observation.isMarioOnGround() ){ if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_SPEED ] = true ;
 }else{ if( landscape[11+ -1 ][11+ 0 ] != 20 ){ action[ Mario.KEY_LEFT ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = true ;
 } } if( landscape[11+ 1 ][11+ -1 ] != -11 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } } } } }else{ if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_GOOMBA ){ if( landscape[11+ 0 ][11+ 1 ] != 16 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_RIGHT ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 action[ Mario.KEY_DOWN ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = false ;
 action[ Mario.KEY_JUMP ] = false ;
 } } } if( landscape[11+ 1 ][11+ 0 ] != 0 ){ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ action[ Mario.KEY_SPEED ] = true ;
 } if( landscape[11+ 1 ][11+ 1 ] != 21 ){ if( landscape[11+ -1 ][11+ 0 ] != -11 ){ action[ Mario.KEY_LEFT ] = false ;
 }else{ action[ Mario.KEY_DOWN ] = true ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } }else{ action[ Mario.KEY_RIGHT ] = false ;
 } }else{ if( enemies[11+ 1 ][11+ 1 ] != Sprite.KIND_BULLET_BILL ){ if( landscape[11+ 0 ][11+ -1 ] != -10 ){ action[ Mario.KEY_JUMP ] = true ;
 } }else{ if( landscape[11+ -1 ][11+ 0 ] != 20 ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } } }