package piece;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;

/**
 * Class to hold all logic regarding the Bishop piece
 * 
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 *
 */
public class Bishop extends Piece {

	public Bishop(boolean isWhite) {
		super(isWhite, "bishop");
	}
	
	@Override
	public ArrayList<String> getAvailableMoves(Board board, Location loc) {
		ArrayList<String> availableMoves = new ArrayList<String>();
		int row = loc.getRow();
		int col = loc.getCol();
		final int HEIGHT = 8, WIDTH = 8;
		Square[][]gameBoard = board.getBoard();
		
	/////// adding all moves up+left /////
			int i = row-1;
			int j = col-1;
			while(i >= 0 && j >=0){
				if(gameBoard[i][j].isEmpty()){
					availableMoves.add(moveNotation(row, col, i, j));	
				}else if(viable(gameBoard, i, j)){
					availableMoves.add(moveNotation(row, col, i, j));
					break;
				}else{
					break;
				}
				i--;
				j--;
			}



			///// adding all moves up+right //////
			i = row-1;
			j = col+1;
			while(i >=0 && j < WIDTH){
				if(gameBoard[i][j].isEmpty()){
					availableMoves.add(moveNotation(row, col, i, j));
				}else if(viable(gameBoard, i, j)){
					availableMoves.add(moveNotation(row, col, i, j));
					break;
				}else{
					break;
				}
				i--;
				j++;
			}


			//// adding all moves down+left //////
			i = row+1;
			j = col-1;
			while(i < HEIGHT && j >= 0){
				if(gameBoard[i][j].isEmpty()){
					availableMoves.add(moveNotation(row, col, i, j));
				}else if(viable(gameBoard, i, j)){
					availableMoves.add(moveNotation(row, col, i, j));
					break;
				}else{
					break;
				}
				i++;
				j--;
			}

			///// adding all moves down+right /////
			i = row+1;
			j = col+1;
			while(i < HEIGHT && j < WIDTH){
				if(gameBoard[i][j].isEmpty()){
					availableMoves.add(moveNotation(row, col, i, j));
				}else if(viable(gameBoard, i, j)){
					availableMoves.add(moveNotation(row, col, i, j));
					break;
				}else{
					break;
				}
				i++;
				j++;
			}
		
		return availableMoves;
	}
	

	/**
	 * Returns the integer code used to identify a bishop
	 * @return
	 *  3
	 */
	public int getCode(){
		return 3;
	}

}
