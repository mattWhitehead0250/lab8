

public class Driver {

	public static void main(String[] args) {
		
		BoardGame game1 = new BoardGame();
		
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.DINING_ROOM);
		game1.movePlayer("Matt", Location.LIBRARY);
		
		System.out.println(game1.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		System.out.println(game1.getGamePiecesAtLocation(Location.DINING_ROOM));
		
		
	}

}
