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
            p1ChessPieces[i+8] = new Pawn();
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
        
        int i = 0;
        while (true) {            
            myGameBoard.setImage(p1ChessPieces[i++]);
            if(i == p1ChessPieces.length) {
                i = 0;
                Location newLocation = new Location(3, 0);
                if(p1ChessPieces[0].isValidMove(newLocation)){
                    //myGameBoard.removeImage(p1ChessPieces[0].pieceLocation);
                    //p1ChessPieces[0].move(newLocation);
                }
            }
        }
        
        
        
    }
    
}
