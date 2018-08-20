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
public class Location {
    private int locationX, locationY;
    
    public Location(){
        locationX = -1;
        locationY = -1;
    }
    
    public Location(int x, int y){
        locationX = x;
        locationY = y;
    }
    
    
    public void setLocation(Location updateLocation){
        locationX = updateLocation.locationX;
        locationY = updateLocation.locationY;
    }
    
    public int getLocationX(){
        return this.locationX;
    }
    public int getLocationY(){
        return this.locationY;
    }
    
    public boolean isLocationEqual(Location b) {
        if(this.locationX == b.locationX) {
            if(this.locationY == b.locationY) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
