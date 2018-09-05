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
       int run = nextLocation.getLocationX() - pieceLocation.getLocationX();
       int rise = nextLocation.getLocationY() - pieceLocation.getLocationY();
       
       if(run == rise || run == (-1*rise)) {
           return true;
       }
       return false;
    }
    
    
    @Override
    public boolean isPathClear(Location nextLocation, Location obstacle){
        int maxLoc, minLoc, obsLoc;
        
        maxLoc = maxValue(nextLocation.getLocationX(), pieceLocation.getLocationX());
        minLoc = minValue(nextLocation.getLocationX(), pieceLocation.getLocationX());
        
        obsLoc = obstacle.getLocationX();
        if(maxLoc > obsLoc && minLoc < obsLoc) {       
            maxLoc = maxValue(nextLocation.getLocationY(), pieceLocation.getLocationY());
            minLoc = minValue(nextLocation.getLocationY(), pieceLocation.getLocationY());
            obsLoc = obstacle.getLocationY();
            if(maxLoc > obsLoc && minLoc < obsLoc) {
                int run = obstacle.getLocationX() - pieceLocation.getLocationX();
                int rise = obstacle.getLocationY() - pieceLocation.getLocationY();
                if(run == rise || run == (-1*rise)) {
                    return false;
                }
            }
        }
        

        return true; // past all obstacle test
    }
   
}
