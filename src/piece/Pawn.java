package piece;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;

/**
 *  Class to hold all logic regarding the pawn piece
 *  
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 *
 */
public class Pawn extends Piece {
	
	private int vector;
	private boolean canPassant;
	
	public Pawn(boolean isWhite) {
		super(isWhite, "pawn");
		if(isWhite){
			vector = -1;
		}else{
			vector = 1;
		}
	}

	@Override
	public ArrayList<String> getAvailableMoves(Board board, Location loc) {
		ArrayList<String> availableMoves = new ArrayList<String>();
		int row = loc.getRow();
		int col = loc.getCol();
		row += vector;
		Square[][]gameBoard = board.getBoard();
		if( row > 0 && row < 7 && gameBoard[row][col].isEmpty()){
			availableMoves.add(moveNotation(row-vector, col, row, col));
		}
		//TODO add en passant 
		if( col !=0 ){
			Piece tempPiece = gameBoard[row][col-1].getPiece();
			if(tempPiece != null && (tempPiece.isWhite() ^ this.isWhite())){
				availableMoves.add(moveNotation(row-vector, col, row, col-1));
			}
		}
		if( col != 7){
			Piece tempPiece = gameBoard[row][col+1].getPiece();
			if(tempPiece != null && (tempPiece.isWhite() ^ this.isWhite())){
				availableMoves.add(moveNotation(row-vector, col, row, col+1));
			}
		}
		if(!hasMoved()){
			if( viable(gameBoard, row+vector, col)){
				availableMoves.add(moveNotation(row-vector, col, row+vector, col));
			}
		}
		return availableMoves;
	}
	
	public void setCanPassant(){
		this.canPassant = true;
	}
	public void setCannotPassant(){
		this.canPassant = false;
	}
	public boolean canPassant(){
		return canPassant;
	}
	
	public int getCode(){
		return 0;
	}
	
}