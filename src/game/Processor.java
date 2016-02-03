package game;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;
import piece.Piece;
import player.Player;

/**
 * Class to process the a move and adjust the board as necessary. 
 * @author Martin Wallace
 * <p> Martin.V.Wallace@ieee.org
 * 
 *
 */
public class Processor {
	
	/**
	 * Evaluates the validity of a players move and adjusts the board as necessary. 
	 * 
	 * TODO enPassant 
	 * 
	 * @param pMove
	 * {@code String} representation of a players move in the "Piece" "StartRow" , "StartCol", "EndRow", "EndCol"
	 * @param board
	 * {@code Board} the current board 
	 * @param player
	 * {@code Player} the player who is making the move
	 */
	public void evaluateMove(String pMove, Board board, Player player) {
		ArrayList<String>moves = new ArrayList<String>();

		moves = board.getMoves(player.isWhite());

		if(!moves.contains(pMove)){
			System.out.println("That is not a move");
			boolean badInput = true; 
			while(badInput){
				pMove = player.requestMove();

				if(moves.contains(pMove)){
					badInput = false;
				}
			}
		}
		String[]moveParts = pMove.split(" ");
		Location start = new Location(Integer.parseInt(moveParts[1]), Integer.parseInt(moveParts[2]));
		Location end = new Location(Integer.parseInt(moveParts[3]), Integer.parseInt(moveParts[4]));
		Square[][]gameBoard = board.getBoard();
		
		// handle castles
		boolean castling = false;
		if(moveParts[0].equals("king")){
			if(Math.abs(start.getCol() - end.getCol()) > 1){
				castling = true;
			}
		}
		Piece movingPiece = gameBoard[start.getRow()][start.getCol()].getPiece();
		gameBoard[start.getRow()][start.getCol()].removePiece();
		gameBoard[end.getRow()][end.getCol()].setEmpty();
		gameBoard[end.getRow()][end.getCol()].setPiece(movingPiece);
		movingPiece.setMoved();
		
		if(castling){
			if(start.getCol() - end.getCol() == 2){
				
				if(start.getRow() == 7){
					Piece castleRook = gameBoard[7][0].getPiece();
					gameBoard[7][0].removePiece();
					gameBoard[7][3].setPiece(castleRook);
					castleRook.setMoved();
				}else{
					Piece castleRook = gameBoard[0][0].getPiece();
					gameBoard[0][0].removePiece();
					gameBoard[0][2].setPiece(castleRook);
					castleRook.setMoved();
				}
			}else if( start.getCol() - end.getCol() == -2){
				
				if (start.getRow() == 7){
					Piece castleRook = gameBoard[7][7].getPiece();
					gameBoard[7][7].removePiece();
					gameBoard[7][5].setPiece(castleRook);
					castleRook.setMoved();
				}else{
					Piece castleRook = gameBoard[0][7].getPiece();
					gameBoard[0][7].removePiece();
					gameBoard[0][4].setPiece(castleRook);
					castleRook.setMoved();
				}
			}
			
		}
	}
}