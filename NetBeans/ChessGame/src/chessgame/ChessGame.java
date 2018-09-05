/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.net.URL;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Chess Piece Setup START
        int playerOne = 1;
        int playerTwo = 2;

        ChessPiece[] player2ChessPieces = new ChessPiece[NUM_OF_CHESS_PIECES];
        ChessPiece[] player1ChessPieces = new ChessPiece[NUM_OF_CHESS_PIECES];
        GameBoard myGameBoard = new GameBoard();

        setupPiece(player1ChessPieces, playerOne);
        setupImage(player1ChessPieces, myGameBoard, playerOne);
        setupPiece(player2ChessPieces, playerTwo);
        setupImage(player2ChessPieces, myGameBoard, playerTwo);
        //Chess Piece Setup END
        chessState gameState = chessState.PLAYER_ONE_TURN;

        boolean transition = false;
        chessState newState = chessState.PLAYER_ONE_TURN;

        while (true) {
            switch (gameState) {
                case PLAYER_ONE_TURN:
                    movePiece(player1ChessPieces, player2ChessPieces, myGameBoard);
//                    if(gameWon()){
//                        newState = chessState.WINNER;
//                        transition = true;
//                    } else {
                    newState = chessState.PLAYER_TWO_TURN;
                    transition = true;
//                    }
                    break;
                case PLAYER_TWO_TURN:
                    movePiece(player2ChessPieces, player1ChessPieces, myGameBoard);
//                    if(gameWon()){
//                        newState = chessState.WINNER;
//                        transition = true;
//                    } else {
                    newState = chessState.PLAYER_ONE_TURN;
                    transition = true;
//                    }
                    break;
                case WINNER:
                    System.out.println("Congrat on winning! Onto the next project!");
                    break;
                default:
                    System.out.println("Out of state in ChessGame.java ");
            }

            if (transition == true) {
                transition = false;
                gameState = newState;
            }

        }   //while true
    }

    public static void setupImage(ChessPiece[] playerPieces, GameBoard gameBoard, int playerNumber) {
        URL[] ImageURL = new URL[9];
        int pawnIndex = 8;

        
        if (playerNumber == 1) {
            ImageURL[0] =  ChessGame.class.getResource("/image/rook_1.png");
            ImageURL[1] =  ChessGame.class.getResource("/image/knight_1.png");
            ImageURL[2] =  ChessGame.class.getResource("/image/bishop_1.png");
            ImageURL[3] =  ChessGame.class.getResource("/image/queen_1.png");
            ImageURL[4] =  ChessGame.class.getResource("/image/king_1.png");
            ImageURL[5] =  ChessGame.class.getResource("/image/bishop_1.png");
            ImageURL[6] =  ChessGame.class.getResource("/image/knight_1.png");
            ImageURL[7] = ChessGame.class.getResource("/image/rook_1.png");
            ImageURL[pawnIndex] =  ChessGame.class.getResource("/image/pawn_1.png");
        } else {
            ImageURL[0] =  ChessGame.class.getResource("/image/rook_2.png");
            ImageURL[1] =  ChessGame.class.getResource("/image/knight_2.png");
            ImageURL[2] =  ChessGame.class.getResource("/image/bishop_2.png");
            ImageURL[3] =  ChessGame.class.getResource("/image/queen_2.png");
            ImageURL[4] =  ChessGame.class.getResource("/image/king_2.png");
            ImageURL[5] =  ChessGame.class.getResource("/image/bishop_2.png");
            ImageURL[6] =  ChessGame.class.getResource("/image/knight_2.png");
            ImageURL[7] = ChessGame.class.getResource("/image/rook_2.png");
            ImageURL[pawnIndex] =  ChessGame.class.getResource("/image/pawn_2.png");
        }

//        p1ImageURL[0] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/rook_1.png";
//        p1ImageURL[1] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/knight_1.png";
//        p1ImageURL[2] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/bishop_1.png";
//        p1ImageURL[3] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/queen_1.png";
//        p1ImageURL[4] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/king_1.png";
//        p1ImageURL[5] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/bishop_1.png";
//        p1ImageURL[6] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/knight_1.png";
//        p1ImageURL[7] = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/rook_1.png";
//        String p1PawnURL = "/Users/alex/Desktop/GitControl/Chess/NetBeans/ChessGame/src/image/pawn_1.png";
        for (int i = 0; i < 8; i++) {
            playerPieces[i].setImage(ImageURL[i]);
            playerPieces[i + 8].setImage(ImageURL[pawnIndex]);
        }

        for (int i = 0; i < playerPieces.length; i++) {
            gameBoard.setImage(playerPieces[i]);
        }

    }

    public static void setupPiece(ChessPiece[] playerPieces, int playerNumber) {
        playerPieces[0] = new Rook();
        playerPieces[1] = new Knight();
        playerPieces[2] = new Bishop();
        playerPieces[3] = new Queen();
        playerPieces[4] = new King();
        playerPieces[5] = new Bishop();
        playerPieces[6] = new Knight();
        playerPieces[7] = new Rook();
        if (playerNumber == 1) {
            for (int i = 0; i < 8; i++) {
                playerPieces[i + 8] = new Pawn(true); //This piece does start at the top
            }

            for (int i = 0; i < 8; i++) {
                playerPieces[i].setPlayer(1);
                // p1ChessPieces[i].setImage(p1ImageURL[i]);
                playerPieces[i].setLocation(new Location(i, 0));

                //Initalizing the pawns in next row
                playerPieces[i + 8].setPlayer(1);
                // p1ChessPieces[i+8].setImage(p1PawnURL);
                playerPieces[i + 8].setLocation(new Location(i, 1));
            }
        } else {

            for (int i = 0; i < 8; i++) {
                playerPieces[i + 8] = new Pawn(false); //This piece does start at the top
            }

            for (int i = 0; i < 8; i++) {
                playerPieces[i].setPlayer(1);
                // p1ChessPieces[i].setImage(p1ImageURL[i]);
                playerPieces[i].setLocation(new Location(i, 7));

                //Initalizing the pawns in next row
                playerPieces[i + 8].setPlayer(1);
                // p1ChessPieces[i+8].setImage(p1PawnURL);
                playerPieces[i + 8].setLocation(new Location(i, 6));
            }
        }
    }

    public static boolean castlePathClear(Location castleMove, ChessPiece[] myChess) {
        boolean isPathClear = true;
        if (castleMove.getLocationX() < 4) {
            for (int i = 0; i < myChess.length; i++) {
                Location pieceLocation = myChess[i].getPieceLocation();
                if (pieceLocation.getLocationY() == castleMove.getLocationY()) {
                    if (0 < pieceLocation.getLocationX() && (castleMove.getLocationX() + 1) >= pieceLocation.getLocationX()) {
                        isPathClear = false;
                    }
                }
            }
        } else {
            for (int i = 0; i < myChess.length; i++) {
                Location pieceLocation = myChess[i].getPieceLocation();
                if (pieceLocation.getLocationY() == castleMove.getLocationY()) {
                    if (7 > pieceLocation.getLocationX() && (castleMove.getLocationX() - 1) <= pieceLocation.getLocationX()) {
                        isPathClear = false;
                    }
                }
            }
        }
        return isPathClear;
    }

    public static void movePiece(ChessPiece[] AllyPiece, ChessPiece[] EnemyPiece, GameBoard gameBoard) {
        System.out.println("in ChessGame.java, movePiece function: ");

        boolean isPieceMoved = false;
        int grabIndex = -1;
        

        while (!isPieceMoved) {
            if (gameBoard.isButtonPressed()) {
                if (grabIndex == -1) {
                    grabIndex = searchLocation(AllyPiece, gameBoard.getLocation());
                    continue;
                }
                Location currLocation = AllyPiece[grabIndex].getPieceLocation();
                Location nextLocation = gameBoard.getLocation();
                
                if (!currLocation.isLocationEqual(nextLocation)) {

                    boolean clearPath = false;
                    boolean castling = AllyPiece[grabIndex].specialMoveCastling(nextLocation, AllyPiece);
                    if (AllyPiece[grabIndex].isValidMove(nextLocation) || castling) {
                        int counter = 0;
                        for (int i = 0; i < AllyPiece.length; i++) {
                            if (i != grabIndex) {
                                if (AllyPiece[grabIndex].isPathClear(nextLocation, AllyPiece[i].getPieceLocation())) {
                                    if(!nextLocation.isLocationEqual(AllyPiece[i].getPieceLocation())) {
                                        counter++;                                    
                                    }
                                }
                            } if(AllyPiece[grabIndex].isPathClear(nextLocation, EnemyPiece[i].getPieceLocation())) {
                                counter++;
                            }
                        }

                        if (counter == (AllyPiece.length - 1 + EnemyPiece.length)) {
                            clearPath = true;
                        }

                        if (clearPath) {
                            //This only happens when a king is selected and moves to location 6,0 or 2,0 on the first move
                            if (castling) {
                                if (castlePathClear(nextLocation, AllyPiece)) {
                                    //check if the path is clear 
                                    moveCastle(gameBoard, AllyPiece);
                                } else {
                                    continue; // path isn't clear, invalid move, try agian
                                }
                            }
                            
                            capturePiece(nextLocation, EnemyPiece, gameBoard);
                            gameBoard.removeImage(AllyPiece[grabIndex].getPieceLocation());
                            AllyPiece[grabIndex].setLocation(nextLocation);
                            gameBoard.setImage(AllyPiece[grabIndex]);
                            currLocation = nextLocation;
                            isPieceMoved = true;
                            continue;
                        }
                    }
                }

                int grabNewPiece = searchLocation(AllyPiece, nextLocation);
                if (grabNewPiece != -1) {
                    grabIndex = grabNewPiece;
                }
            }
        }
        //After move was made see if a piece was captured

        System.out.println("Exited movePiece() function");
    }

    public static void moveCastle(GameBoard gameBoard, ChessPiece[] AllyPiece) {
        if (gameBoard.getLocation().getLocationX() == 6) {
            for (int i = 0; i < AllyPiece.length; i++) {
                if (AllyPiece[i].getPieceLocation().getLocationX() == 7
                        && AllyPiece[i].getPieceLocation().getLocationY() == 0) {
                    Location temp = new Location(5, 0);
                    gameBoard.removeImage(AllyPiece[i].getPieceLocation());
                    AllyPiece[i].setLocation(temp);
                    gameBoard.setImage(AllyPiece[i]);
                }
            }
        } else if (gameBoard.getLocation().getLocationX() == 2) {
            for (int i = 0; i < AllyPiece.length; i++) {
                if (AllyPiece[i].getPieceLocation().getLocationX() == 0
                        && AllyPiece[i].getPieceLocation().getLocationY() == 0) {
                    Location temp = new Location(3, 0);
                    gameBoard.removeImage(AllyPiece[i].getPieceLocation());
                    AllyPiece[i].setLocation(temp);
                    gameBoard.setImage(AllyPiece[i]);
                }
            }
        }
    }
    public static void capturePiece(Location captureLocation, ChessPiece[] attackedPiece, GameBoard gameBoard) {
        Location deadPiece = new Location(-1, -1);
        for (int i = 0; i < attackedPiece.length; i++) {
            if(captureLocation.isLocationEqual(attackedPiece[i].getPieceLocation())) {
                gameBoard.removeImage(attackedPiece[i].getPieceLocation());
                attackedPiece[i].setLocation(deadPiece);
            }

        }
    }
    //returns 
    public static int searchLocation(ChessPiece[] myPiece, Location grabLocation) {
        int matchIndex = -1;
        for (int j = 0; j < myPiece.length; j++) {
            if (grabLocation.isLocationEqual(myPiece[j].getPieceLocation())) {
                matchIndex = j;
                break;
            }
        }
        return matchIndex;
    }

}
