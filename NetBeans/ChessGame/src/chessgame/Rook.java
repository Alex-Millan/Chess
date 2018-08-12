/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class Rook extends ChessPiece{
    /*
    * Determines whether a rook move was valid or not. 
    */
    public boolean isValidMove(Location nextLocation){
        //Valid Horizontal move
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
        //invalid move
        return false;
    }
    
    public void move(Location nextLocation) {
        if(isValidMove(nextLocation)) {
            this.setLocation(nextLocation);
        }
    }
   
}
