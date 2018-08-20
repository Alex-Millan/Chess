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
public class Queen extends ChessPiece{
    
    
    @Override
    public boolean isValidMove(Location nextLocation){
        //Valid Horizontal move
       //get the x difference and match the difference in Y to get a slope of 1 or -1
       int slopeX = nextLocation.getLocationX() - pieceLocation.getLocationX();
       int slopeY = nextLocation.getLocationY() - pieceLocation.getLocationY();
       
       if(slopeX == slopeY || slopeX == (-1*slopeY)) {
           return true;
       }
       //Rook type move
       if(nextLocation.getLocationX() == pieceLocation.getLocationX()) {
            //Make sure you aren't moving a piece in the same spot
            if(nextLocation.getLocationY() == pieceLocation.getLocationY()) {
                return false; // moving to same place is not allowed
            } else {
                //TODO: check if another chess piece is blocking a path
                return true;
            }
        } else if(nextLocation.getLocationY() == pieceLocation.getLocationY()) {
            if(nextLocation.getLocationX() == pieceLocation.getLocationX()) {
                return false;
            } else {
                //TODO check if another chess piece is blocking a path
                return true;
            }
        }
       
       
       return false;
    }
}
