

public enum GamePiece {
	
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2),GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), 
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), 
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance appearance;
	private int priority;
	
	private GamePiece(GamePieceAppearance appearance, int priority) {
		this.appearance = appearance;
		this.priority = priority;
	}
	
	 public static GamePiece movesFirst(GamePiece a, GamePiece b) {
		 if(a.priority > b.priority) {
			 return b;
		 }
		 return a;
	 }
	 
	 public Color getColor() {
		 return appearance.getColor();
	 }
	 
	 public Shape getShape() {
		 return appearance.getShape();
	 }
	 
	 public String toString() {
		 return String.format("%s: a %s %s with priority %d", this.name(), this.appearance.getColor(), this.appearance.getShape(), this.priority;);
	 }
}
