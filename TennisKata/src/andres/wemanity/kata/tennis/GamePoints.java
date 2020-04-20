package andres.wemanity.kata.tennis;

/**
 * @author andre
 * Name of Points in Tennis
 */
public enum GamePoints {
	ZERO(0, "Love"),
	ONE(1, "Fifteen"),
	TWO(2, "Thirty"),
	THREE(3, "Fourty"),
	FOUR(4, "Advantage"),
	DEUCE(5, "Deuce");
	
	private int point;
	private String name;
	
	private GamePoints(int point, String name) {
		this.point = point;
		this.name = name;
	}
	
	/** Return the tennis name of the point
	 * @param point Number of the point
	 * @return Name of the point
	 */
	public static String getName(int point) {
		String name = "";
		for (GamePoints gp : GamePoints.values()) {
			if(gp.point == point) {
				name = gp.name;
				break;
			}
		}
		return name;
	}
}