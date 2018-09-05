/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class ChessPiece {
    int playerNumber = -1;
    Location  pieceLocation;
    ImageIcon pieceIcon;
    protected boolean isFirstMove = true;
    private boolean isSetup = true;
    //boolean isHuman = true;
    
    public ChessPiece() {
        
    }
    /*
    * isPlayerHuman is  true when it is a human, false if AI.
    */
//    public ChessPiece(boolean isPlayerHuman) {
//        isHuman = isPlayerHuman;
//        pieceLocation = new Location();
//        
//    }
    
    public ChessPiece(int player, URL imgURL) {
        playerNumber = player;
        pieceIcon = new ImageIcon(imgURL);
        
    }
    
     public ChessPiece(int player, String URL, Location location) {
        playerNumber = player;
        pieceIcon = new ImageIcon(URL);
        pieceLocation = new Location(location.getLocationX(), location.getLocationY());
    }
     
    public void setPlayer(int player) {
        playerNumber = player;
    }
    public void setLocation(Location newLocation) {
        pieceLocation = newLocation;
        if(isSetup) {
            isSetup = false;
        }else {
            isFirstMove = false;// next location will be the first move.
        }
    }
    
    public void move(Location nextLocation){
        if(isValidMove(nextLocation)) {
            this.setLocation(nextLocation);
        } 
    }
    
    public boolean isValidMove(Location nextLocation){
        return true;
    }

    public boolean isPathClear(Location nextLocation, Location obstacle){

        return true;
    }
    
    public int maxValue(int a, int b) {
        if(a > b){
            return a;
        } else {
            return b;
        }
    }
    
    
    public int minValue(int a, int b) {
        if(a > b){
            return b;
        } else {
            return a;
        }
    }
    
    public boolean specialMoveCastling(Location next, ChessPiece[] myPiece) {
        return false;
    }
    
    
    
    public void setImage(URL imgURL){
        pieceIcon = new ImageIcon(imgURL);
    }
    
    public void capturePiece(){
        //Remove enemy piece from the game
        
    }
    
    public void removePiece(){
        //Removing the current Object chess piece
    }
    
    public Location getPieceLocation(){
        return pieceLocation;
    }
    
    protected boolean isRook() {
        return false;
    }
    
}
