//geracao 99 level: 1 fit: 2735.31
 if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_RIGHT ] = true ;
 action[ Mario.KEY_SPEED ] = false ;
 } } if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_JUMP ] = true ;
 } }else{ if( enemies[11+ -2 ][11+ -2 ] != Sprite.KIND_GREEN_KOOPA ){ action[ Mario.KEY_DOWN ] = true ;
 } } if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( enemies[11+ -1 ][11+ 2 ] != Sprite.KIND_GOOMBA_WINGED ){ action[ Mario.KEY_RIGHT ] = false ;
 }else{ action[ Mario.KEY_SPEED ] = false ;
 } } } }else{ if( landscape[11+ -2 ][11+ -2 ] != 16 ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 if( observation.isMarioOnGround() ){ action[ Mario.KEY_LEFT ] = false ;
 } }else{ action[ Mario.KEY_SPEED ] = true ;
 action[ Mario.KEY_JUMP ] = false ;
 if( enemies[11+ 1 ][11+ 1 ] != Sprite.KIND_SPIKY_WINGED ){ action[ Mario.KEY_JUMP ] = true ;
 } } } if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = true ;
 action[ Mario.KEY_RIGHT ] = true ;
 if( observation.mayMarioJump() ){ action[ Mario.KEY_SPEED ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_SPEED ] = true ;
 } } if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 action[ Mario.KEY_LEFT ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = false ;
 } } } } if( enemies[11+ 0 ][11+ -1 ] != Sprite.KIND_GOOMBA ){ if( observation.mayMarioJump() ){ if( observation.mayMarioJump() ){ action[ Mario.KEY_DOWN ] = false ;
 }else{ if( landscape[11+ 1 ][11+ -1 ] != -11 ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = true ;
 action[ Mario.KEY_DOWN ] = false ;
 } }else{ action[ Mario.KEY_JUMP ] = false ;
 } } } }else{ if( observation.mayMarioJump() ){ if( observation.isMarioOnGround() ){ action[ Mario.KEY_JUMP ] = false ;
 } }else{ if( observation.isMarioOnGround() ){ action[ Mario.KEY_DOWN ] = true ;
 } } }