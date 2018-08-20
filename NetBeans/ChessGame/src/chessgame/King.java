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
public class King extends ChessPiece{
    @Override 
    public boolean isValidMove(Location nextLocation) {
        int moveX = nextLocation.getLocationX() - pieceLocation.getLocationX();
        moveX = Math.abs(moveX);
        int moveY = nextLocation.getLocationY() - pieceLocation.getLocationY();
        moveY = Math.abs(moveY);
        
        
        if((moveX == 1 || moveX == 0) && (moveY == 0 || moveY == 1)) {
            return true;
        }
        return false; 
    }
    
}
