import org.junit.Assert;
import org.junit.Test;

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
	
	@Test
	public void movePlayerTest() {
		BoardGame game1 = new BoardGame();
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game1.movePlayer("Matt", Location.BILLIARD_ROOM);
		Assert.assertEquals("Wrong location", Location.BILLIARD_ROOM, game1.playerLocation.get("Matt"));
	}
	
	//return to figure out why this wont pass
	@Test
	public void moveTwoPlayersTest() {
		String[] players = {"Matt", "Ryan"};
        Location[] locations = {Location.DINING_ROOM, Location.STUDY};        
        BoardGame game1 = new BoardGame();
        
        game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        game1.addPlayer("Katie", GamePiece.RED_RACER, Location.BILLIARD_ROOM);

        String[] players2 = {"Katie", "Matt"};
        game1.movePlayer("Matt", Location.BILLIARD_ROOM);

        Assert.assertArrayEquals(new String[] {"Matt", "Ryan"}, game1.moveTwoPlayers(players, locations));
        Assert.assertArrayEquals(new String[] {"Katie", "Matt"}, game1.moveTwoPlayers(players2, locations));
	}
	
	@Test
	public void getPlayerLocationTest() {
		BoardGame game1 = new BoardGame();
		
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game1.movePlayer("Matt", Location.BILLIARD_ROOM);
		Assert.assertEquals(game1.playerLocation.get("Matt"), game1.getPlayerLocation("Matt"));
		
	}
	
	@Test
	public void getPlayersAtLocationTest() {
		String[] players = {"Matt", "Ryan"};
		Location[] locations = {Location.BALLROOM, Location.BALLROOM};
		BoardGame game1 = new BoardGame();
		
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
		game1.addPlayer("Katie", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		
		game1.moveTwoPlayers(players, locations);
		Assert.assertEquals("Wrong Players", "Matt", game1.getPlayersAtLocation(Location.BALLROOM).get(0));
		Assert.assertEquals("Wrong Players", "Ryan", game1.getPlayersAtLocation(Location.BALLROOM).get(1));

	}
	
	@Test
	public void getGamePiecesAtLocationTest() {
		String[] players = {"Matt", "Ryan"};
        Location[] locations = {Location.BALLROOM, Location.BALLROOM};
        BoardGame game1 = new BoardGame();
        
        game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        game1.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        game1.moveTwoPlayers(players, locations);
        Assert.assertEquals("Wrong pieces", GamePiece.BLUE_BOOT, game1.getGamePiecesAtLocation(Location.BALLROOM).get(0));
        Assert.assertEquals("Wrong pieces", GamePiece.BLUE_RACER, game1.getGamePiecesAtLocation(Location.BALLROOM).get(1));
	}
	
	@Test
    public void getPlayersTest() 
    {
        BoardGame game1 = new BoardGame();
        game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        game1.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Wrong location", 3, game1.getPlayers().size());
        Assert.assertEquals("Wrong location", "Matt", game1.getPlayers().stream().findFirst().get());
    }
	
	@Test
	public void getPlayerLocationsTest() {
		BoardGame game1 = new BoardGame();
        
        game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        game1.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Wrong location", 3, game1.getPlayerLocations().size());
        Assert.assertEquals("Wrong location", true, game1.getPlayerLocations().contains(Location.CONSERVATORY));
	}
	
	@Test
	public void getPlayerPiecesTest() {
		BoardGame game1 = new BoardGame();
		
		game1.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game1.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
		game1.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		
		Assert.assertEquals("Wrong Location", 3, game1.getPlayerPieces().size());
		Assert.assertEquals("Wrong Location", true, game1.getPlayerPieces().contains(GamePiece.BLUE_RACER));
	}
}
