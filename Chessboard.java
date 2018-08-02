public class Chessboard{
	private int[][] positions; //maybe using an array of Strings would be easier?

	public Chessboard(){
		this.positions = new int[8][8]; //a chessboard has 8 rows and columns
	}

	public String toString(){
		return "Here is where the board gets printed";
	}
}
