import javax.swing.JFrame;
import javax.swing.JLabel;
public class chess_start{
	private static String game_title = "Chess";

	public static void main( String[] args ){
		JFrame frame = new JFrame(game_title);
		frame.add(new JLabel("Hello there"));
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	frame.setSize( 1000, 700 );
	  	frame.setLocationRelativeTo(null);
	  	frame.setResizable(true);
	  	frame.setVisible(true);
	  	System.out.println(frame.getSize());
  } // end method main
}
