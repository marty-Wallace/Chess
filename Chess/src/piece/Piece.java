package piece;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;

/**
 * 
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 *
 */
public abstract class Piece {
	
	private String pieceName = "";
	private Square currentSquare;
	private final boolean isWhite;
	private boolean hasMoved;
	
	public Piece(boolean isWhite, String pieceName){
		this.isWhite = isWhite;
		this.pieceName = pieceName;
	}
	
	
	public void setSquare(Square square){
		this.currentSquare = square;
		this.currentSquare.setFilled();
	}
	
	public void move(Square square){
		this.currentSquare.setEmpty();
		this.currentSquare = square;
 assert this.currentSquare.isEmpty() : "Attempted to move to filled Square";
		this.currentSquare.setFilled();
	}
	
	public boolean isWhite(){
		return this.isWhite;
	}
	
	public boolean isBlack(){
		return !this.isWhite;
	}

	public abstract ArrayList<String> getAvailableMoves(Board board, Location loc);
	
	public String moveNotation(int startRow, int startCol, int endRow, int endCol){
		String move = "";
		move += pieceName + " " + startRow + " " + startCol + " " + endRow + " " + endCol;
		
		return move;
	}

	public boolean viable(Square[][]gameBoard, int row, int col){
		if(gameBoard[row][col].isEmpty() || (gameBoard[row][col].getPiece().isWhite() ^ this.isWhite())){
			return true;
		}
		return false;
	}
	
	public void setMoved(){
		this.hasMoved = true;
	}
	
	public boolean hasMoved(){
		return this.hasMoved;
	}
	@Override
	public String toString(){
		return this.pieceName;
	}
	
	public abstract int getCode();
}
