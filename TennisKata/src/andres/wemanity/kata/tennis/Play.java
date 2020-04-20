package andres.wemanity.kata.tennis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {
	
	private Scanner in;
	private TennisGame game;

	public static void main(String[] args) {
		Play play = new Play();
		play.play();
	}
	
	public Play() {
		in = new Scanner(System.in);
		game = new TennisGame();
	}
	
	public TennisGame getGame() {
		return game;
	}
	
	private void play() {
		boolean winner = false;
		System.out.println("Welcome to Tennis Game");
		this.readConsolePlayers();
		while(!winner) {
			this.getGame().printResult();
			this.printNextPlay();
			int i = this.readConsolePoints();
			if(i != 0) {
				winner = this.getGame().AddPoint(i);
			}
		}
		in.close();
	}
	
	/**
	 * Read from console the name of the players
	 */
	private void readConsolePlayers() {
		System.out.print("Player One Name: ");
		String s = in.nextLine();
		this.game.setPlayerOneName(s);
		
		System.out.print("Player Two Name: ");
		String m = in.nextLine();
		this.game.setPlayerTwoName(m);
	}
	
	/** Read from console the winner of the next point
	 * @return
	 */
	private int readConsolePoints() {
		try {
			int i = in.nextInt();
			if(i==1 || i==2) {
				return i;
			} else {
				System.out.println("Incorrect number");
				return 0;
			}
		} catch (InputMismatchException e) {
			System.out.println("Not a number");
			in.next();
			return 0;
		}
	}
	
	/**
	 * Prints the menu
	 */
	private void printNextPlay() {
		System.out.println("///******************************///");
		System.out.println("Choose who wins next point: ");
		System.out.println("1-" + game.getPlayerOneName());
		System.out.println("2-" + game.getPlayerTwoName());
	}
}