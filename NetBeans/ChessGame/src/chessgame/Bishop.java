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
public class Bishop extends ChessPiece{
    
     @Override
    public boolean isValidMove(Location nextLocation){
        //Valid Horizontal move
       //get the x difference and match the difference in Y to get a slope of 1 or -1
       int slopeX = nextLocation.getLocationX() - pieceLocation.getLocationX();
       int slopeY = nextLocation.getLocationY() - pieceLocation.getLocationY();
       
       if(slopeX == slopeY || slopeX == (-1*slopeY)) {
           return true;
       }
       return false;
    }
}
