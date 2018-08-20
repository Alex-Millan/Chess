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
public class Knight extends ChessPiece{
    @Override
    public boolean isValidMove(Location nextLocation){
        //Valid Horizontal move
       //get the x difference and match the difference in Y to get a slope of 1 or -1
       int a = nextLocation.getLocationX() - pieceLocation.getLocationX();
       int b = nextLocation.getLocationY() - pieceLocation.getLocationY();
       float dist = (float)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
       
       if(dist == (float)Math.sqrt(5)) {
           return true;
       }
       return false;
    }
}
