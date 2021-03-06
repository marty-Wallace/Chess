package piece;

import java.util.ArrayList;

import board.Board;
import board.Location;
import board.Square;

/**
 *  Class to hold all the logic regarding the King piece
 *  
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 *
 */
public class King extends Piece{

	public King(boolean isWhite) {
		super(isWhite, "king");
	}

	@Override
	public ArrayList<String> getAvailableMoves(Board board, Location loc) {
		ArrayList<String> availableMoves = new ArrayList<String>();
		int row = loc.getRow();
		int col = loc.getCol();
		boolean down = (row != 7);
		boolean left = (col != 0);
		boolean right = (col != 7);
		boolean up = (row != 0);
		Square[][]gameBoard = board.getBoard();
		
		///////// adding moves down ////////////
		if(down){
			if(viable(gameBoard, row+1, col)){
				availableMoves.add(moveNotation(row, col, row+1, col));
			}
		}
		
		///////// adding moves up /////////////
		if(up) {
			if(viable(gameBoard, row-1, col)){
				availableMoves.add(moveNotation(row, col, row-1, col));
			}
		}
		
		/////// adding moves left ////////////
		if(left){
			if(viable(gameBoard, row, col-1)){
				availableMoves.add(moveNotation(row, col, row, col-1));
			}
		}
		
		////// adding moves right ///////////
		if(right) {
			if(viable(gameBoard, row, col+1)){
				availableMoves.add(moveNotation(row, col, row, col+1));
			}
		}
		///////// adding up+left /////////////
		if(up && left){
			if(viable(gameBoard, row-1, col-1)){
				availableMoves.add(moveNotation(row, col, row-1, col-1));
			}
		}
		
		//////// adding up+right ////////////
		if(up && right){
			if(viable(gameBoard, row-1, col+1)){
				availableMoves.add(moveNotation(row, col, row-1, col+1));
			}
		}
		
		/////// adding down+right //////////
		if(down && right){
			if(viable(gameBoard, row+1, col+1)){
				availableMoves.add(moveNotation(row, col, row+1, col+1));
			}
		}
		
		////// adding down+left ////////////
		if(down && left){
			if(viable(gameBoard, row+1, col-1)){
				availableMoves.add(moveNotation(row, col, row+1, col-1));
			}
		}
		
		//////// checking for castle ///////
		//TODO Do not allow castle if king is in check or moves through check or moves into check
		if(!hasMoved()){
			if(this.isWhite()){
				Piece p = gameBoard[7][7].getPiece();
				if(p != null){
					if(p instanceof Rook && p.isWhite() && !p.hasMoved()){
						if(gameBoard[7][6].isEmpty() && gameBoard[7][5].isEmpty()){
							availableMoves.add("king 7 4 7 6");
						}
					}
					
				}
				p = gameBoard[7][0].getPiece();
				if(p != null){
					if(p instanceof Rook && p.isWhite() && !p.hasMoved()){
						if(gameBoard[7][1].isEmpty() && gameBoard[7][2].isEmpty() && gameBoard[7][3].isEmpty()){
							availableMoves.add("king 7 4 7 2");
						}
					}
				}
			}else{
				Piece p = gameBoard[0][0].getPiece();
				if(p != null){
					if(p instanceof Rook && !p.isWhite() && !p.hasMoved()){
						if(gameBoard[0][1].isEmpty() && gameBoard[0][2].isEmpty()){
							availableMoves.add("king 0 3 0 1");
						}
					}
				}
				p = gameBoard[0][7].getPiece();
				if(p != null){
					if(p instanceof Rook && !p.isWhite() && !p.hasMoved()){
						if(gameBoard[0][4].isEmpty() && gameBoard[0][5].isEmpty() && gameBoard[0][6].isEmpty()){
							availableMoves.add("king 0 3 0 5");
						}
					}
				}
			}
		}
		
		return availableMoves;
	}
	
	public int getCode(){
		return 5;
	}
	

}
