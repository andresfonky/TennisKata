package andres.wemanity.kata.tennis;

/**
 * @author andre
 * Tennis Game logic
 */
public class TennisGame {
	
	private int playerOnePoints;
	private String playerOneName;
	private int playerTwoPoints;
	private String playerTwoName;
	
	public TennisGame() {
		this.playerOnePoints = 0;
		this.playerOneName = "";
		this.playerTwoPoints = 0;
		this.playerTwoName = "";
	}

	public int getPlayerOnePoints() {
		return playerOnePoints;
	}
	
	public int getPlayerTwoPoints() {
		return playerTwoPoints;
	}
	
	public String getPlayerOneName() {
		return playerOneName;
	}

	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}
	
	/** Add one point to the player who won it
	 * @param i Player who won the point
	 * @return true if there is a winner
	 */
	public boolean AddPoint(int i) {
		if(i==1) {
			playerOnePoints++;
		} else if(i==2) {
			playerTwoPoints++;
		}
		return this.checkFinishGame();
	}
	
	/** Check the finish conditions
	 * @return true if there is a winner
	 */
	private boolean checkFinishGame() {
		//Wins before Deuce
		if(playerOnePoints == 4 && playerOnePoints-playerTwoPoints > 1) {
			this.printWinner(playerOneName);
			return true;
		} else if(playerTwoPoints == 4 && playerTwoPoints-playerOnePoints > 1) {
			this.printWinner(playerTwoName);
			return true;
		} /*Wins after advantage*/ else if(playerOnePoints == 5 && playerTwoPoints == 3) {
			this.printWinner(playerOneName);
			return true;
		} else if(playerTwoPoints == 5 && playerOnePoints == 3) {
			this.printWinner(playerTwoName);
			return true;
		} /*Deuce after advantage*/ else if(playerOnePoints == 4 && playerTwoPoints == 4) {
			playerOnePoints--;
			playerTwoPoints--;
		}
		return false;
	}
	
	/**
	 * Prints the current result of the game
	 */
	public void printResult() {
		System.out.print("Score: " );
		if(playerOnePoints == 3 && playerOnePoints == playerTwoPoints) {
			System.out.println(GamePoints.DEUCE.name());
		} else if(playerOnePoints == 4) {
			System.out.println(GamePoints.getName(playerOnePoints) + " " + playerOneName);
		}  else if(playerTwoPoints == 4) {
			System.out.println(GamePoints.getName(playerTwoPoints) + " " + playerTwoName);
		} else {
			System.out.println(GamePoints.getName(playerOnePoints) + " - " + GamePoints.getName(playerTwoPoints));
		}
	}
	
	/** Prints the game winner
	 * @param s Name of the player
	 */
	private void printWinner(String s) {
		System.out.println(s + " wins");
	}
}
