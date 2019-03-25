import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest {

	@Test
	public void getPlayerGamePieceTest() {
		BoardGame bg = new BoardGame();
		bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		Assert.assertEquals("Wrong gamepiece", GamePiece.BLUE_BOOT, bg.getPlayerGamePiece("Matt"));
	}
	
	@Test
	public void getPlayerWithGamePieceTest() {
		BoardGame bg = new BoardGame();
		bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		Assert.assertEquals("Wrong gamepiece", "Matt", bg.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		Assert.assertEquals("Wrong gamepiece", null, bg.getPlayerWithGamePiece(GamePiece.BLUE_RACER));
	}
	
	@Test
	public void addPlayerTest() {
		BoardGame bg = new BoardGame();
		Assert.assertEquals("Wrong player / info", true, bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM));
		Assert.assertEquals("Wrong player / info", false, bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM));
	}
	
	@Test
	public void movePlayerTest() {
		BoardGame bg = new BoardGame();
		bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		bg.movePlayer("Matt", Location.BILLIARD_ROOM);
		Assert.assertEquals("Wrong location", Location.BILLIARD_ROOM, bg.playerLocation.get("Matt"));
	}
	
	//return to figure out why this wont pass
	@Test
	public void moveTwoPlayersTest() {
		String[] players = {"Matt", "Ryan"};
        Location[] locations = {Location.DINING_ROOM, Location.STUDY};        
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Katie", GamePiece.RED_RACER, Location.BILLIARD_ROOM);

        String[] players2 = {"Katie", "Matt"};
        bg.movePlayer("Matt", Location.BILLIARD_ROOM);

        Assert.assertArrayEquals(new String[] {"Matt", "Ryan"}, bg.moveTwoPlayers(players, locations));
        Assert.assertArrayEquals(new String[] {"Katie", "Matt"}, bg.moveTwoPlayers(players2, locations));
	}
	
	@Test
	public void getPlayerLocationTest() {
		BoardGame bg = new BoardGame();
		
		bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		bg.movePlayer("Matt", Location.BILLIARD_ROOM);
		Assert.assertEquals(bg.playerLocation.get("Matt"), bg.getPlayerLocation("Matt"));
		
	}
	
	@Test
	public void getPlayersAtLocationTest() {
		String[] players = {"Matt", "Ryan"};
		Location[] locations = {Location.BALLROOM, Location.BALLROOM};
		BoardGame bg = new BoardGame();
		
		bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		bg.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
		bg.addPlayer("Katie", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		
		bg.moveTwoPlayers(players, locations);
		Assert.assertEquals("Wrong Players", "Matt", bg.getPlayersAtLocation(Location.BALLROOM).get(0));
		Assert.assertEquals("Wrong Players", "Ryan", bg.getPlayersAtLocation(Location.BALLROOM).get(1));

	}
	
	@Test
	public void getGamePiecesAtLocationTest() {
		String[] players = {"Matt", "Ryan"};
        Location[] locations = {Location.BALLROOM, Location.BALLROOM};
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        bg.moveTwoPlayers(players, locations);
        Assert.assertEquals("Wrong pieces", GamePiece.BLUE_BOOT, bg.getGamePiecesAtLocation(Location.BALLROOM).get(0));
        Assert.assertEquals("Wrong pieces", GamePiece.BLUE_RACER, bg.getGamePiecesAtLocation(Location.BALLROOM).get(1));
	}
	
	@Test
    public void getPlayersTest() 
    {
        BoardGame bg = new BoardGame();
        bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Wrong location", 3, bg.getPlayers().size());
        Assert.assertEquals("Wrong location", "Matt", bg.getPlayers().stream().findFirst().get());
    }
	
	@Test
	public void getPlayerLocationsTest() {
		BoardGame bg = new BoardGame();
        
        bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Wrong location", 3, bg.getPlayerLocations().size());
        Assert.assertEquals("Wrong location", true, bg.getPlayerLocations().contains(Location.CONSERVATORY));
	}
	
	@Test
	public void getPlayerPiecesTest() {
		BoardGame bg = new BoardGame();
		
		bg.addPlayer("Matt", GamePiece.BLUE_BOOT, Location.BALLROOM);
		bg.addPlayer("Ryan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
		bg.addPlayer("Katie", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
		
		Assert.assertEquals("Wrong Location", 3, bg.getPlayerPieces().size());
		Assert.assertEquals("Wrong Location", true, bg.getPlayerPieces().contains(GamePiece.BLUE_RACER));
	}
}
