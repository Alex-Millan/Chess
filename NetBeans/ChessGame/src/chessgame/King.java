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
public class King extends ChessPiece {

    @Override
    public boolean isValidMove(Location nextLocation) {
        int moveX = nextLocation.getLocationX() - pieceLocation.getLocationX();
        moveX = Math.abs(moveX);
        int moveY = nextLocation.getLocationY() - pieceLocation.getLocationY();
        moveY = Math.abs(moveY);

        if ((moveX == 1 || moveX == 0) && (moveY == 0 || moveY == 1)) {
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean isKing() {
        return true;
    }
    
    @Override
    public boolean specialMoveCastling(Location next, ChessPiece[] myPiece) {
        //Location specialLocation

        Location[] specialPoints = new Location[4];
        specialPoints[0] = new Location(2, 0);
        specialPoints[1] = new Location(6, 0);
        specialPoints[2] = new Location(2, 7);
        specialPoints[3] = new Location(6, 7);

        if (!this.isFirstMove) {
            return false; // cannot castle if it isn't the kings first move
        }
        boolean isSpecialPoint = false;
        for (int i = 0; i < specialPoints.length; i++) {
            if(specialPoints[i].isLocationEqual(next)) {
                isSpecialPoint = true;
            }
        }
        
        if(!isSpecialPoint) {
            return false;
        }
        
        
        for (int i = 0; i < myPiece.length; i++) {
            if (myPiece[i].isRook()) {
                if (myPiece[i].isFirstMove) {
                    if (specialPoints[0].isLocationEqual(next)) {
                        if (myPiece[i].getPieceLocation().getLocationX() == 0
                                && myPiece[i].getPieceLocation().getLocationY() == 0) {
                            return true;
                        }
                    } else if (specialPoints[1].isLocationEqual(next)) {
                        if (myPiece[i].getPieceLocation().getLocationX() == 7
                                && myPiece[i].getPieceLocation().getLocationY() == 0) {
                            return true;
                        }
                    } else if (specialPoints[2].isLocationEqual(next)) {
                        if (myPiece[i].getPieceLocation().getLocationX() == 0
                                && myPiece[i].getPieceLocation().getLocationY() == 7) {
                            return true;
                        }
                    } else if (specialPoints[3].isLocationEqual(next)) {
                        if (myPiece[i].getPieceLocation().getLocationX() == 0
                                && myPiece[i].getPieceLocation().getLocationY() == 7) {
                            return true;
                        }
                    }

                }
            }
        }

        return true;
    }

}
