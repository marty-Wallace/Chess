package game;

import board.Board;
import player.Player;
import visualizer.Visualizer;

/**
 * Starts up game by initializing board and setting pieces
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 */
public class Driver {
	
	private Board board;
	private Player player1, player2;
	private Processor processor;
	private Visualizer visualizer;
	public static void main(String[]args){
		Driver driver = new Driver();
		driver.run();	
	}
	
	private Driver(){
		this.player1 = new Player(true);
		this.player2 = new Player(false);
		this.processor = new Processor();
		this.visualizer = new Visualizer();
	}
	
	/**
	 * Main game loop requests move from player 1 then updates board then visualizes then the same for player 2
	 */
	public void run(){
		boolean running = true;
		board = new Board();
		while(running){
			requestPlayerMove(player1);
			running = update();
			board.printBoard();
			visualizer.update(board);
			requestPlayerMove(player2);
			running = update();
			board.printBoard();
			visualizer.update(board);
			
		}
	}
	
	/**
	 * Requests move from player and updates board through the processor
	 * 
	 * @param p
	 * {@code Player} that is currently moving their piece.
	 */
	public void requestPlayerMove(Player p){
		String pMove = p.requestMove();
		processor.evaluateMove(pMove, board, p);
	}
	
	/**
	 * TODO 
	 * Method to check if game is over 
	 * @return
	 * returns {@code boolean} that is false if the game is over
	 */
	public boolean update(){
		
		return true;
	}
	
}
