/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GUI of the chess game.
 * Creates an 8 x 8 checker board.
 * Handles User/AI inputs.
 * Updates board.
 * @author Alex
 */
public class GameBoard{
    private final byte board_dimension = 8;
    private JButton[][] board_square = new JButton[board_dimension][board_dimension];
    private JFrame frame = new JFrame("ChessBoard");
	public GameBoard() {

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
		grid_panel.setLayout(new BoxLayout(grid_panel, BoxLayout.X_AXIS));

		JPanel[] board_panel = new JPanel[board_dimension];


		for (int i = 0; i < board_square.length; i++) {
			board_panel[i] = new JPanel();
			board_panel[i].setLayout(new BoxLayout(board_panel[i],BoxLayout.Y_AXIS));
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
        
        public void setImage(ChessPiece piece) {
            board_square[piece.pieceLocation.getLocationX()][piece.pieceLocation.getLocationY()].setIcon(piece.pieceIcon); 
        }
        public void removeImage(Location myLocation){
            board_square[myLocation.getLocationX()][myLocation.getLocationY()].setIcon(null);
        }
        
        public void updateBoard(){
            
        }
        
}

