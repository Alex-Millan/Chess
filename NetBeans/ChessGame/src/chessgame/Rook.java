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
public class Rook extends ChessPiece{
    /*
    * Determines whether a rook move was valid or not. 
    */
    @Override
    public boolean isValidMove(Location nextLocation){
        if(isVerticalMove(nextLocation)) {
            return true;
        } else if(isHorizontalMove(nextLocation)) {
           return true;
        }

        return false;
    }
    
    public boolean isVerticalMove(Location nextLocation){
        return nextLocation.getLocationX() == pieceLocation.getLocationX();

    }

    public boolean isHorizontalMove(Location nextLocation){
        return (nextLocation.getLocationY() == pieceLocation.getLocationY());

    }
    
    @Override
    public boolean isPathClear(Location nextLocation, Location obstacle){
        int maxLoc, minLoc, obsLoc;
        
        maxLoc = maxValue(nextLocation.getLocationX(), pieceLocation.getLocationX());
        minLoc = minValue(nextLocation.getLocationX(), pieceLocation.getLocationX());
        
        obsLoc = obstacle.getLocationX();
        if(maxLoc > obsLoc && minLoc < obsLoc) {
            if(nextLocation.getLocationY() == obstacle.getLocationY()) {
                return false; // obsloc is between the two path
            }
        }
        
        
        
        
        maxLoc = maxValue(nextLocation.getLocationY(), pieceLocation.getLocationY());
        minLoc = minValue(nextLocation.getLocationY(), pieceLocation.getLocationY());
        obsLoc = obstacle.getLocationY();
        
        if(maxLoc > obsLoc && minLoc < obsLoc) {
            if(nextLocation.getLocationX() == obstacle.getLocationX()) {
                return false; // obsloc is between the two path
            } 
        }
        
        //isFirstMove = false; // successful first move was made at this point
        return true; // past all obstacle test
    } 
    
    @Override
    protected boolean isRook() {
        return true;
    }
}

