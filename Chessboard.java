public class Chessboard{
	private String[][] positions; //maybe using an array of Strings would be easier?
	private ChessPiece[][] pieces;

	public Chessboard(){
		this.positions = new String[8][8]; //a chessboard has 8 rows and columns
		this.pieces = new ChessPiece[8][8];
		
		for( int r = 0; r < 8; r++ ){
			for( int c = 0; c < 8; c++){
				this.positions[r][c] = "["+r+","+c+"] ";
				this.pieces[r][c] = new ChessPiece();
			}
		}

		System.out.println(pieces[0][0]);
		
		ChessPawn piece = new ChessPawn();
		piece.move();
		piece.die();
		System.out.println(piece);
	}

	//public getPiece()
	//public updateBoard()

	public String toString(){
		String retVal = "";
		for( int r = 0; r < 8; r++ ){
			for( int c = 0; c < 8; c++){
				retVal+=this.positions[r][c];
			}
			retVal+="\n";
		}
		return retVal;
	}
}
