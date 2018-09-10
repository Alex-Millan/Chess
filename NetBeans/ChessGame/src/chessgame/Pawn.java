/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

/**
 *
 * @author Alex
 */
public class Pawn extends ChessPiece {
    
    private boolean isTopPlayer = false;
    public Pawn(boolean playerPostion) {
        isTopPlayer = playerPostion;
    }
    @Override
    public boolean isValidMove(Location nextLocation) {
        if(nextLocation.getLocationX() == pieceLocation.getLocationX()) {
            if(isTopPlayer) {
                if(nextLocation.getLocationY() - pieceLocation.getLocationY() == 1) {
                    return true;
                }
                if(isFirstMove) {
                    if(nextLocation.getLocationY() - pieceLocation.getLocationY() == 2) {
                        enpassantValid = true;
                        return true;
                    }
                }
            } else {
                if(nextLocation.getLocationY() - pieceLocation.getLocationY() == -1) {
                    return true;
                }
                if(isFirstMove) {
                    if(nextLocation.getLocationY() - pieceLocation.getLocationY() == -2) {
                        enpassantValid = true;
                        return true;
                    }
                }
            }
        } else if((nextLocation.getLocationX() + 1) == pieceLocation.getLocationX() || 
                    (nextLocation.getLocationX() - 1) == pieceLocation.getLocationX()) {
            if(isTopPlayer) {
                if(nextLocation.getLocationY() - pieceLocation.getLocationY() == 1) {
                    return true;
                }
            } else {
                 if(nextLocation.getLocationY() - pieceLocation.getLocationY() == -1) {
                    return true;
                }               
            }
        }
        return false;
    }
    @Override
    public boolean isSpecialPawnAttack(Location nextLocation, Location obstacle) {
        int locX = nextLocation.getLocationX();
        int locY = nextLocation.getLocationY();
        int obsX = obstacle.getLocationX();
        int obsY = obstacle.getLocationY();
        if((locX == pieceLocation.getLocationX() + 1) ||
                (locX == pieceLocation.getLocationX() - 1) ) {

            if(isTopPlayer) {
                if(locY == (pieceLocation.getLocationY() + 1)) {
                    if(locX == obsX && locY == obsY) {
                        return true;
                    }
                }
            } else {
                if(locY == (pieceLocation.getLocationY() -  1) && locY != -1 ) {
                    if(locX == obsX && locY == obsY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean isEnpassantMove(Location nextLocation, ChessPiece enemyPiece) {
       if(isTopPlayer) {
           if(pieceLocation.getLocationY() == 4) {
               if(enemyPiece.enpassantValid == true) {
                   Location temp = new Location(enemyPiece.getPieceLocation().getLocationX(), enemyPiece.getPieceLocation().getLocationY()+1);
                   if(isSpecialPawnAttack(nextLocation, temp)) {
                       return true;
                    }
                }
           } 
       } else{
            if(pieceLocation.getLocationY() == 3) {
                if(enemyPiece.enpassantValid == true) {
                   Location temp = new Location(enemyPiece.getPieceLocation().getLocationX(), enemyPiece.getPieceLocation().getLocationY()-1);
                   if(isSpecialPawnAttack(nextLocation, temp)) {
                       return true;
                    }
                }                
            } 
        }     
       
       return false;
    }
    
    @Override
    public boolean isPathClear(Location nextLocation, Location obstacle){
        int locX = nextLocation.getLocationX();
        int locY = nextLocation.getLocationY();
        int obsX = obstacle.getLocationX();
        int obsY = obstacle.getLocationY();
        if(locX != pieceLocation.getLocationX()) {
            return false;
        }
            if(isTopPlayer) {            
                if(locX == obsX && locY == obsY) {
                        return false;
                    }
            } else {
                if(locX == obsX && locY == obsY) {
                    return false;
                }
            }
        return true;
    }
}
