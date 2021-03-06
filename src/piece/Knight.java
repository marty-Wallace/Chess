package piece;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;

/**
 *  Class to hold all logic regarding the Knight piece
 *  
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 *
 */
public class Knight extends Piece{

	public Knight(boolean isWhite) {
		super(isWhite, "knight");
	}

	@Override
	public ArrayList<String> getAvailableMoves(Board board, Location loc) {
		ArrayList<String> availableMoves = new ArrayList<String>();
		int row = loc.getRow();
		int col = loc.getCol();
		Square[][]gameBoard = board.getBoard();
		
		if(inBounds(row+1, col+2) && viable(gameBoard, row+1, col+2)){
			availableMoves.add(moveNotation(row, col, row+1, col+2));
		}
		
		if(inBounds(row+1, col-2) && viable(gameBoard, row+1, col-2)){
			availableMoves.add(moveNotation(row, col, row+1, col-2));
		}
		
		if(inBounds(row+2, col+1) && viable(gameBoard, row+2, col+1)){
			availableMoves.add(moveNotation(row, col, row+2, col+1));
		}
		
		if(inBounds(row+2, col-1) && viable(gameBoard, row+2, col-1)){
			availableMoves.add(moveNotation(row, col, row+2, col-1));
		}
		
		if(inBounds(row-1, col+2) && viable(gameBoard, row-1, col+2)){
			availableMoves.add(moveNotation(row, col, row-1, col+2));
		}
		
		if(inBounds(row-1, col-2) && viable(gameBoard, row-1, col-2)){
			availableMoves.add(moveNotation(row, col, row-1, col-2));
		}
		
		if(inBounds(row-2, col-1) && viable(gameBoard, row-2, col-1)){
			availableMoves.add(moveNotation(row, col, row-2, col-1));
		}
		if(inBounds(row-2, col+1) && viable(gameBoard, row-2, col+1)){
			availableMoves.add(moveNotation(row, col, row-2, col+1));
		}
		return availableMoves;
	}
	
	public boolean inBounds(int row, int col){
		
		if(row < 0 || row >= 8){
			return false;
		}
		if(col < 0 || col >= 8){
			return false;
		}
		return true;
	}
	
	public int getCode(){
		return 2;
	}
}
