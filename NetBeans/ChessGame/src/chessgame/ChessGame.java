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
public class ChessGame {

    
    enum chessState {
        PICKUP_PIECE,
        PLACE_PIECE;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameBoard myGameBoard = new GameBoard();

        ChessPiece[] p1ChessPieces = new ChessPiece[16];
        String[] p1ImageURL = new String[8];
        
        p1ImageURL[0] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\rook_1.png";
        p1ImageURL[1] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\knight_1.png";
        p1ImageURL[2] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\bishop_1.png";
        p1ImageURL[3] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\queen_1.png";
        p1ImageURL[4] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\king_1.png";
        p1ImageURL[5] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\bishop_1.png";
        p1ImageURL[6] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\knight_1.png";
        p1ImageURL[7] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\rook_1.png";
        
        
        String p1PawnURL = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\pawn_1.png";

        p1ChessPieces[0] = new Rook();
        p1ChessPieces[1] = new Knight();
        p1ChessPieces[2] = new Bishop();
        p1ChessPieces[3] = new Queen();
        p1ChessPieces[4] = new King();
        p1ChessPieces[5] = new Bishop();
        p1ChessPieces[6] = new Knight();
        p1ChessPieces[7] = new Rook();
        for (int i = 0; i < 8; i++) {
            p1ChessPieces[i+8] = new Pawn(true); //This piece does start at the top
        }
        
        for (int i = 0; i < 8; i++) {
            p1ChessPieces[i].setPlayer(1);
            p1ChessPieces[i].setImage(p1ImageURL[i]);
            p1ChessPieces[i].setLocation(new Location(i,0));
            
            //Initalizing the pawns in next row
            p1ChessPieces[i+8].setPlayer(1);
            p1ChessPieces[i+8].setImage(p1PawnURL);
            p1ChessPieces[i+8].setLocation(new Location(i,1));
        }

int grabIndex = -1;
        chessState gameState = chessState.PICKUP_PIECE;
        Location currLocation = new Location();
        
        boolean transition = false;
        chessState newState = chessState.PICKUP_PIECE;
        for (int i = 0; i < p1ChessPieces.length; i++) {
            myGameBoard.setImage(p1ChessPieces[i]);
        }
        while (true) {
            
            switch(gameState){
                case PICKUP_PIECE:
                    if(myGameBoard.isButtonPressed()) {
                        int temp = searchLocation(p1ChessPieces, myGameBoard.getLocation());
                        if(temp != -1) {
                            grabIndex = temp;
                            transition = true;
                            newState = chessState.PLACE_PIECE;
                        }
                    }
                    break;
                case PLACE_PIECE:
                    if(myGameBoard.isButtonPressed()) {
                        //TODO: make sure the move was valid before placing piece
                        if(currLocation != myGameBoard.getLocation()) {
                            boolean clearPath = false;
                            if(p1ChessPieces[grabIndex].isValidMove(myGameBoard.getLocation()) || p1ChessPieces[grabIndex].specialMoveCastling(myGameBoard.getLocation(), p1ChessPieces)) {
                                
                                currLocation = myGameBoard.getLocation(); // out of board
                                int counter = 0;
                                for (int i = 0; i < p1ChessPieces.length; i++) {
                                    if(i != grabIndex) {
                                        if(p1ChessPieces[grabIndex].isPathClear(currLocation, p1ChessPieces[i].getPieceLocation())){
                                            counter++;
                                        }
                                    }
                                }
                                if(counter == (p1ChessPieces.length - 1)) {
                                    clearPath = true;
                                }
                                if(clearPath) {
                                    //This only happens when a king is selected and moves to location 6,0 or 2,0 on the first move
                                    if(p1ChessPieces[grabIndex].specialMoveCastling(currLocation, p1ChessPieces)) {
                                       if(castlePathClear(currLocation, p1ChessPieces)) {
                                        //check if the path is clear 
                                            if(myGameBoard.getLocation().getLocationX() == 6) {
                                                for (int i = 0; i < p1ChessPieces.length; i++) {
                                                    if(p1ChessPieces[i].getPieceLocation().getLocationX() == 7 &&
                                                            p1ChessPieces[i].getPieceLocation().getLocationY() == 0) {
                                                        Location temp = new Location(5, 0);
                                                        myGameBoard.removeImage(p1ChessPieces[i].getPieceLocation());
                                                        p1ChessPieces[i].setLocation(temp);
                                                        myGameBoard.setImage(p1ChessPieces[i]);
                                                    }
                                                }
                                            } else if(myGameBoard.getLocation().getLocationX() == 2) {
                                                for (int i = 0; i < p1ChessPieces.length; i++) {
                                                    if(p1ChessPieces[i].getPieceLocation().getLocationX() == 0 &&
                                                            p1ChessPieces[i].getPieceLocation().getLocationY() == 0) {
                                                        Location temp = new Location(3, 0);
                                                        myGameBoard.removeImage(p1ChessPieces[i].getPieceLocation());
                                                        p1ChessPieces[i].setLocation(temp);
                                                        myGameBoard.setImage(p1ChessPieces[i]);
                                                    }
                                                }
                                            }
                                            myGameBoard.removeImage(p1ChessPieces[grabIndex].getPieceLocation());
                                            p1ChessPieces[grabIndex].setLocation(currLocation);
                                            myGameBoard.setImage(p1ChessPieces[grabIndex]);
                                            transition = true;
                                            newState = chessState.PICKUP_PIECE;
                                        }   
                                    } else {
                                        myGameBoard.removeImage(p1ChessPieces[grabIndex].getPieceLocation());
                                        p1ChessPieces[grabIndex].setLocation(currLocation);
                                        myGameBoard.setImage(p1ChessPieces[grabIndex]);
                                        transition = true;
                                        newState = chessState.PICKUP_PIECE;
                                        
                                    }
                                } 
                                   
                            }
                        } 
                               int temp = searchLocation(p1ChessPieces, myGameBoard.getLocation());
                                if(temp != -1) {
                                    grabIndex = temp;
                                    transition = true;
                                    newState = chessState.PLACE_PIECE;
                                }
                    }
                    break;
                default:
                    System.err.println("Out of state! Chessgame.java main");
            }
            
            if(transition == true) {
                transition = false;
                gameState = newState;
            }
            
        }
    }
    
    
    public static boolean castlePathClear(Location castleMove, ChessPiece[] myChess) {
        boolean isPathClear = true;
        if(castleMove.getLocationX() < 4) {
            for (int i = 0; i < myChess.length; i++) {
                Location pieceLocation = myChess[i].getPieceLocation();
                if(pieceLocation.getLocationY() ==  castleMove.getLocationY()) {
                    if(0 < pieceLocation.getLocationX() && (castleMove.getLocationX() + 1) >= pieceLocation.getLocationX()){
                        isPathClear = false;
                    } 
                }
            }   
        } else {
            for (int i = 0; i < myChess.length; i++) {
                Location pieceLocation = myChess[i].getPieceLocation();
                if(pieceLocation.getLocationY() ==  castleMove.getLocationY()) {
                    if(7 > pieceLocation.getLocationX() && (castleMove.getLocationX() - 1) <= pieceLocation.getLocationX()){
                        isPathClear = false;
                    } 
                }
            }               
        }
        return isPathClear;
    }
    //returns 
    public static int searchLocation(ChessPiece[] myPiece, Location grabLocation) {
        int matchIndex = -1;
        for (int j = 0; j < myPiece.length; j++) { 
            if(grabLocation.isLocationEqual(myPiece[j].getPieceLocation())){
                matchIndex = j;
                break;
            }
        }
        return matchIndex;
    }
    
}
