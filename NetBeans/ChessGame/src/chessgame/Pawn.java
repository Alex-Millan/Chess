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
                        return true;
                    }
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
    public boolean isPathClear(Location nextLocation, Location obstacle){
        int locX = nextLocation.getLocationX();
        int locY = nextLocation.getLocationY();
        int obsX = obstacle.getLocationX();
        int obsY = obstacle.getLocationY();

        if(locX == obsX && locY == obsY || ((locY-1) == obsY && locX == obsX)) {
            return false;
        }

        //isFirstMove = false; // first move is successful at this point
        return true;
    }
}
