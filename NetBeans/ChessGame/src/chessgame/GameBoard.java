/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard{
    private final byte board_dimension = 8;
    private JButton[][] board_square = new JButton[board_dimension][board_dimension];
    
    public enum ChessPiece{
        KING,
        QUEEN,
        KNIGHT,
        BISHOP,
        ROOK,
        PAWN;
    }
    
    public enum Player{
        ONE,
        TWO;
    }
    
    ChessPiece currentPiece;
	public GameBoard() {
		JFrame frame = new JFrame("ChessBoard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set a Matrix of button 8 x 8
		//Change the color of the chessboard to WHITE and BLACk
		
		final byte size = 100; //100 pixcels for a square
		Dimension square_size = new Dimension(size, size);	
		//settings of the Jbuttons

		final Color oddColor = new Color(70,130,180);
		final Color evenColor = Color.WHITE; 
		
		
		JPanel grid_panel = new JPanel();
		grid_panel.setBackground(new Color(0,100,0));
		grid_panel.setLayout(new BoxLayout(grid_panel, BoxLayout.Y_AXIS));

		JPanel[] board_panel = new JPanel[board_dimension];


		for (int i = 0; i < board_square.length; i++) {
			board_panel[i] = new JPanel();
			board_panel[i].setLayout(new BoxLayout(board_panel[i],BoxLayout.X_AXIS));
			board_panel[i].setBackground(Color.CYAN);
			board_panel[i].setSize(size, board_dimension*size);
			
			for (int j = 0; j < board_square[0].length; j++) {
				board_square[i][j] = new JButton();
				board_square[i][j].setMaximumSize(square_size);
				board_square[i][j].setPreferredSize(square_size);
				board_square[i][j].setMinimumSize(square_size);
				if((i+j)%2 == 1) {
					board_square[i][j].setBackground(oddColor);//make button white
				} else { 
					board_square[i][j].setBackground(evenColor);//make button black					
				}
				board_panel[i].add(board_square[i][j]);
			}
			grid_panel.add(board_panel[i]);
		}
		
		frame.setSize(1000, 1000);
		frame.add(grid_panel);
		frame.setVisible(true);
                
		

	}
        
        public void initialBoardSetup() {
            
            ChessPiece currentPiece = ChessPiece.PAWN;
            Player player = Player.ONE;
            for (int i = 0; i < board_dimension; i++) {
                setImage(currentPiece, player, i, 1);
            }
            currentPiece = ChessPiece.ROOK;
            setImage(currentPiece, player, 0, 0);
            setImage(currentPiece, player, 7, 0);
            
            currentPiece = ChessPiece.KNIGHT;
            setImage(currentPiece, player, 1, 0);
            setImage(currentPiece, player, 6, 0);
            
            currentPiece = ChessPiece.BISHOP;
            setImage(currentPiece, player, 2, 0);
            setImage(currentPiece, player, 5, 0);
            
            currentPiece = ChessPiece.QUEEN;
            setImage(currentPiece, player, 3, 0);
            
            currentPiece = ChessPiece.KING;
            setImage(currentPiece, player, 4, 0);
            
            player = Player.TWO;
            currentPiece = ChessPiece.PAWN;
            for (int i = 0; i < board_dimension; i++) {
                setImage(currentPiece, player, i, 6);
            }
            
            currentPiece = ChessPiece.ROOK;
            setImage(currentPiece, player, 0, 7);
            setImage(currentPiece, player, 7, 7);
            
            currentPiece = ChessPiece.KNIGHT;
            setImage(currentPiece, player, 1, 7);
            setImage(currentPiece, player, 6, 7);
            
            currentPiece = ChessPiece.BISHOP;
            setImage(currentPiece, player, 2, 7);
            setImage(currentPiece, player, 5, 7);
            
            currentPiece = ChessPiece.QUEEN;
            setImage(currentPiece, player, 3, 7);
            
            currentPiece = ChessPiece.KING;
            setImage(currentPiece, player, 4, 7);
            
            
        }
        public void setImage(ChessPiece chess_piece, Player player, int locationX, int locationY) {
            ImageIcon piece_image;
            switch(chess_piece){
                case KING:
                    if(player == Player.ONE){
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\king_1.png");
                    } else {
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\king_2.png");
                    }

                    break;
                case QUEEN:
                    if(player == Player.ONE){
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\queen_1.png");
                    } else {
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\queen_2.png");
                    }
                    break;
                case KNIGHT:
                    if(player == Player.ONE){
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\knight_1.png");
                    } else {
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\knight_2.png");
                    }
                    break;
                case BISHOP:
                    if(player == Player.ONE){
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\bishop_1.png");
                    } else {
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\bishop_2.png");
                    }
                    break;
                case ROOK:
                    if(player == Player.ONE){
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\rook_1.png");
                    } else {
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\rook_2.png");
                    } 
                    break;
                case PAWN:
                    if(player == Player.ONE){
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\pawn_1.png");
                    } else {
                        piece_image = new ImageIcon("C:\\Users\\Alex\\Documents\\NetBeansProjects\\ChessGame\\src\\image\\pawn_2.png");
                    }
                    break;
                default : 
                    System.err.println("Did you changed the enum??");
                    piece_image = null;
                    break;
            }
            board_square[locationY][locationX].setIcon(piece_image); 
        }
        
}

