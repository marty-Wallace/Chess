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
	
	public void run(){
		boolean running = true;
		board = new Board();
		while(running){
			requestPlayerMove(player1);
			running = update();
			board.printBoard();
			requestPlayerMove(player2);
			running = update();
			board.printBoard();
			visualizer.update(board);
			
		}
	}
	
	public void requestPlayerMove(Player p){
		String pMove = p.requestMove();
		processor.evaluateMove(pMove, board, p);
	}
	public boolean update(){
		
		return true;
	}
	
}
