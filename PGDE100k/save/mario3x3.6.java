//geracao 99 level: 0 fit: 3706.56
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 } }else{ action[ Mario.KEY_RIGHT ] = false ;
 } if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_BULLET_BILL ){ action[ Mario.KEY_DOWN ] = false ;
 } if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 } }else{ if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_SPEED ] = false ;
 action[ Mario.KEY_SPEED ] = false ;
 }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_SPEED ] = true ;
 } } } action[ Mario.KEY_RIGHT ] = false ;
 }else{ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_RED_KOOPA ){ action[ Mario.KEY_JUMP ] = true ;
 if( landscape[11+ 0 ][11+ 1 ] != 16 ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } if( landscape[11+ 1 ][11+ 1 ] != 20 ){ action[ Mario.KEY_JUMP ] = false ;
 } } } } if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( enemies[11+ 0 ][11+ 1 ] != Sprite.KIND_RED_KOOPA ){ if( enemies[11+ -1 ][11+ -1 ] != Sprite.KIND_SPIKY ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = true ;
 } }else{ action[ Mario.KEY_JUMP ] = true ;
 } } if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 }else{ action[ Mario.KEY_JUMP ] = true ;
 } } } }else{ action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( enemies[11+ 0 ][11+ 0 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_JUMP ] = true ;
 if( observation.mayMarioJump() ){ if( landscape[11+ 1 ][11+ 1 ] != 20 ){ action[ Mario.KEY_LEFT ] = true ;
 }else{ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = false ;
 } } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_RIGHT ] = true ;
 }else{ action[ Mario.KEY_LEFT ] = false ;
 } if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = false ;
 }else{ action[ Mario.KEY_RIGHT ] = true ;
 } } }else{ action[ Mario.KEY_SPEED ] = true ;
 } }