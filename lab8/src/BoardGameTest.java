import org.junit.Test;

import junit.framework.Assert;

public class BoardGameTest {

	@Test
	public void getPlayerGamePieceTest() {
		BoardGame game1 = new BoardGame();
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		Assert.assertEquals("Wrong gamepiece", GamePiece.BLUE_BOOT, game1.getPlayerGamePiece("Matt"));
	}
	
	@Test
	public void getPlayerWithGamePieceTest() {
		BoardGame game1 = new BoardGame();
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		Assert.assertEquals("Wrong gamepiece", "Matt", game1.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		Assert.assertEquals("Wrong gamepiece", null, game1.getPlayerWithGamePiece(GamePiece.BLUE_RACER));
	}
	
	@Test
	public void addPlayerTest() {
		BoardGame game1 = new BoardGame();
		Assert.assertEquals("Wrong player / info", true, game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM));
		Assert.assertEquals("Wrong player / info", false, game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM));
	}
	
	
}
