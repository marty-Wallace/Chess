package player;
import java.util.Scanner;

/**
 * Class to hold information for a player and used to request action of the player
 * @author Martin Wallace
 * <p> Martin.V.Wallace@ieee.org
 */
public class Player {

	private boolean isWhite;
	private String playerName;
	
	/**
	 * Constructor for player
	 * @param isWhite
	 * If true, sets Player object to be "player1" else sets Player to be "player2"
	 */
	public Player(boolean isWhite){
		this.isWhite = isWhite;
		if(isWhite){
			this.playerName = "player1";
		}else{
			this.playerName = "player2";
		}
	}
	
	/**
	 * Requests a move from the player and passes it back 
	 * @return
	 * {@code String} representation of the players move selection
	 */
	public String requestMove() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your move in the form piece(lowercase) startingRow(0-7) startingCol(0-7) endingRow(0-7) endingCol(0-7)");
		System.out.println("Only enter valid moves: ");
		return scan.nextLine();
	}

	/**
	 * Gets the players name as a String, either "player1", "player2"
	 * @return
	 * {@code String} representation of players name
	 */
	public String getPlayerName(){
		return this.playerName;
	}
	
	/**
	 * Returns if player is white or black player
	 * @return
	 * {@code boolean} representation of player. True if white. False if black.
	 */
	public boolean isWhite(){
		return this.isWhite;
	}
}
