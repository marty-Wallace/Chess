package player;
import java.util.Scanner;

public class Player {

	private boolean isWhite;
	private String playerName;
	
	public Player(boolean isWhite){
		this.isWhite = isWhite;
		if(isWhite){
			this.playerName = "player1";
		}else{
			this.playerName = "player2";
		}
	}
	public String requestMove() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your move in the form piece(lowercase) startingRow(0-7) startingCol(0-7) endingRow(0-7) endingCol(0-7)");
		System.out.println("Only enter valid moves: ");
		return scan.nextLine();
	}

	public String getPlayerName(){
		return this.playerName;
	}
	
	public boolean isWhite(){
		return this.isWhite;
	}
}
