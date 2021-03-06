package piece;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;

/**
 * Class to hold all logic regarding the Rook Piece
 * 
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 */
public class Rook extends Piece{

	public Rook(boolean isWhite) {
		super(isWhite, "rook");
	}

	@Override
	public ArrayList<String> getAvailableMoves(Board board, Location loc) {
		ArrayList<String> availableMoves = new ArrayList<String>();
		int row = loc.getRow();
		int col = loc.getCol();
		final int HEIGHT = 8, WIDTH = 8;
		Square[][]gameBoard = board.getBoard();
		
			/////// adding all moves up   ///////
			for(int i = row-1; i >= 0; i-- ){
				if(gameBoard[i][col].isEmpty()){
					availableMoves.add(moveNotation(row, col, i, col));
				}else if(viable(gameBoard, i, col)){
					availableMoves.add(moveNotation(row, col, i, col));
					break;
				}else{
					break;
				}
			}

			////// adding all moves down  ///////
			for(int i = row+1; i < HEIGHT; i++){
				if(gameBoard[i][col].isEmpty()){
					availableMoves.add(moveNotation(row, col, i, col));
				}else if(viable(gameBoard, i, col)){
					availableMoves.add(moveNotation(row, col, i, col));
					break;
				}else{
					break;
				}
			}
			
			///// adding all moves right ////////
			for(int j = col+1; j < WIDTH; j++){
				if(gameBoard[row][j].isEmpty()){
					availableMoves.add(moveNotation(row, col, row, j));
				}else if(viable(gameBoard, row, j)){
					availableMoves.add(moveNotation(row, col, row, j));
					break;
				}else{
					break;
				}
			}
			
			//////adding all moves left //////////
			for(int j = col-1; j >= 0; j--){
				if(gameBoard[row][j].isEmpty()){
					availableMoves.add(moveNotation(row, col, row, j));
				}else if(viable(gameBoard, row, j)){
					availableMoves.add(moveNotation(row, col, row, j));
					break;
				}else{
					break;
				}
			}
			
		
		
		return availableMoves;
	}
	
	public int getCode(){
		return 1;
	}

}
