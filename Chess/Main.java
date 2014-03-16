package Chess;

public class Main {
	public static void main(String[] args){
		ChessWorld<ChessPiece> world = ChessWorld.createChessWorld();
		world.show();
	}
}
