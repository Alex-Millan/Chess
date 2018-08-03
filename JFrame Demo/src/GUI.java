import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI{

	public GUI() {
		JFrame frame = new JFrame("ChessBoard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set a Matrix of button 8 x 8
		//Change the color of the chessboard to WHITE and BLACk
		
		final int size = 100; //100 pixcels for a square
		Dimension square_size = new Dimension(size, size);	
		//settings of the Jbuttons
		final int board_dimension = 8;
		final Color oddColor = Color.BLACK;
		final Color evenColor = Color.WHITE; 
		
		
		JPanel grid_panel = new JPanel();
		grid_panel.setBackground(new Color(0,100,0));
		grid_panel.setLayout(new BoxLayout(grid_panel, BoxLayout.Y_AXIS));

		JPanel[] board_panel = new JPanel[board_dimension];

		JButton[][] board_square = new JButton[board_dimension][board_dimension];
		for (int i = 0; i < board_square.length; i++) {
			board_panel[i] = new JPanel();
			board_panel[i].setLayout(new BoxLayout(board_panel[i],BoxLayout.X_AXIS));
			board_panel[i].setBackground(Color.CYAN);
			board_panel[i].setSize(size, board_dimension*size);
			
			for (int j = 0; j < board_square[0].length; j++) {
				board_square[i][j] = new JButton(String.valueOf((i*board_dimension)+j));
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
}
