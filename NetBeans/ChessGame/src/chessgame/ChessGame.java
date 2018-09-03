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
    
    static final int NUM_OF_CHESS_PIECES = 16;
    
    enum chessState {
        PLAYER_ONE_TURN,
        PLAYER_TWO_TURN,
        WINNER;
    }
    
    //Chess Piece Setup START

    static GameBoard myGameBoard = new GameBoard();
    static ChessPiece[] p1ChessPieces = new ChessPiece[NUM_OF_CHESS_PIECES];
    static int grabIndex = -1;
    static Location currLocation = new Location(-1,-1);
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Chess Piece Setup START
        setupPiece();
        setupImage();
        //Chess Piece Setup END
        chessState gameState = chessState.PLAYER_ONE_TURN;
        
        
        boolean transition = false;
        chessState newState = chessState.PLAYER_ONE_TURN;
 
        while (true) {
            switch(gameState) {
                case PLAYER_ONE_TURN:
                    movePiece();
//                    if(gameWon()){
//                        newState = chessState.WINNER;
//                        transition = true;
//                    } else {
//                        newState = chessState.PLAYER_TWO_TURN;
//                        transition = true;
//                    }
                    break;
                case PLAYER_TWO_TURN:
                    movePiece();
//                    if(gameWon()){
//                        newState = chessState.WINNER;
//                        transition = true;
//                    } else {
//                        newState = chessState.PLAYER_ONE_TURN;
//                        transition = true;
//                    }
                    break;
                case WINNER:
                    System.out.println("Congrat on winning! Onto the next project!"); 
                    break;
                default:
                    System.out.println("Out of state in ChessGame.java ");
            }
            
            if(transition == true) {
                transition = false;
                gameState = newState;
            }
            
        }   //while true
    }
    
    public static void setupImage() {
        String[] p1ImageURL = new String[8];

        String p1PawnURL = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/pawn_1.png";

        
//        p1ImageURL[0] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\rook_1.png";
//        p1ImageURL[1] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\knight_1.png";
//        p1ImageURL[2] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\bishop_1.png";
//        p1ImageURL[3] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\queen_1.png";
//        p1ImageURL[4] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\king_1.png";
//        p1ImageURL[5] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\bishop_1.png";
//        p1ImageURL[6] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\knight_1.png";
//        p1ImageURL[7] = "C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\rook_1.png";


        p1ImageURL[0] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/rook_1.png";
        p1ImageURL[1] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/knight_1.png";
        p1ImageURL[2] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/bishop_1.png";
        p1ImageURL[3] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/queen_1.png";
        p1ImageURL[4] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/king_1.png";
        p1ImageURL[5] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/bishop_1.png";
        p1ImageURL[6] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/knight_1.png";
        p1ImageURL[7] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/rook_1.png";
        
        for (int i = 0; i < 8; i++) {
            p1ChessPieces[i].setImage(p1ImageURL[i]);
            //Initalizing the pawns in next row
            p1ChessPieces[i+8].setImage(p1PawnURL);
        }
        
        
        for (int i = 0; i < p1ChessPieces.length; i++) {
            myGameBoard.setImage(p1ChessPieces[i]);
        }
       
    }
    
    
    public static void setupPiece() {
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
           // p1ChessPieces[i].setImage(p1ImageURL[i]);
            p1ChessPieces[i].setLocation(new Location(i,0));
            
            //Initalizing the pawns in next row
            p1ChessPieces[i+8].setPlayer(1);
           // p1ChessPieces[i+8].setImage(p1PawnURL);
            p1ChessPieces[i+8].setLocation(new Location(i,1));
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
    
    public static void movePiece(){
         System.out.println("in ChessGame.java, movePiece function: ");
                    
        boolean isPieceMoved = false;
        while(!isPieceMoved) {
            if(myGameBoard.isButtonPressed()) {
                if(grabIndex == -1) {
                    grabIndex = searchLocation(p1ChessPieces, myGameBoard.getLocation());
                    continue;
                }
          //make sure the locations are different
          if(!currLocation.isLocationEqual(myGameBoard.getLocation())) {
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
                          }   
                      } else {
                          myGameBoard.removeImage(p1ChessPieces[grabIndex].getPieceLocation());
                          p1ChessPieces[grabIndex].setLocation(currLocation);
                          myGameBoard.setImage(p1ChessPieces[grabIndex]);

                      }
                      isPieceMoved = true;
                  } 

              }
          } 
                 int temp = searchLocation(p1ChessPieces, myGameBoard.getLocation());
                  if(temp != -1) {
                      grabIndex = temp;
                  }
        }  
        }
        System.out.println("Exited movePiece() function");
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
