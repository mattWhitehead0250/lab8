import org.junit.Assert;
import org.junit.Test;

public class ColorShapeGamePieceTest {

	@Test
	public void getRTest() {
		Assert.assertEquals(255, Color.RED.getR());
	}
	
	@Test
	public void getGTest() {
		Assert.assertEquals(0, Color.RED.getG());
	}
	
	@Test
	public void getBTest() {
		Assert.assertEquals(0, Color.RED.getB());
	}
	
	@Test
	public void shapeToStringTest() {
		Assert.assertEquals("racecar", Shape.RACECAR.toString());
	}
	
	@Test
	public void GamePieceGetColorTest() {
		Assert.assertEquals(Color.RED, GamePiece.RED_RACER.getColor());
	}
	
	@Test public void GamePieceGetShapeTest() {
		Assert.assertEquals(Shape.BOOT, GamePiece.BLUE_BOOT.getShape());
	}
	
	@Test public void GamePieceToStringTest() {
		Assert.assertEquals("RED_RACER: a RED racecar with priority 0", GamePiece.RED_RACER.toString());
	}
	
	@Test 
	public void movesFirstTest() {
		Assert.assertEquals(GamePiece.BLUE_RACER, GamePiece.movesFirst(GamePiece.BLUE_RACER, GamePiece.BLUE_BOOT));
	}
}
