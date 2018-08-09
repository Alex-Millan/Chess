import javax.swing.JFrame;
import javax.swing.JLabel;
public class StartChess{
	private static String game_title = "Chess";

	public static void main( String[] args ){
		/* //The following code will be used when we make an actual gui
		JFrame frame = new JFrame(game_title);
		frame.add(new JLabel("Hello there"));
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	frame.setSize( 1000, 700 );
	  	frame.setLocationRelativeTo(null);
	  	frame.setResizable(true);
	  	frame.setVisible(true);
	  	System.out.println(frame.getSize());
	  	*/
	  	Chessboard board = new Chessboard();
	  	System.out.println( board);
	  	//System.out.println( "Done");
  } // end method main
}
