package board;

import java.util.ArrayList;

import piece.*;

/**
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 */
public class Board {
	
	private final int HEIGHT = 8, WIDTH = 8;
	Square[][] board = new Square[HEIGHT][WIDTH];
	
	public Board(){
		setEmptyBoard();
		setInitialConfiguration();
		printMoves();
		printBoard();
		
	}
	
	/**
	 * initializes each square of the board to be empty and sets the color of the square to be either white or black
	 * 
	 */
	public void setEmptyBoard(){
		boolean white = true;
		for(int row = 0; row< HEIGHT; row++){
			for(int col = 0; col < WIDTH; col++){
				board[row][col] = new Square(new Location(row, col), white);
				white = !white;
			}
			white = !white;
		}
	}
	
	/**
	 * gets Square at a requested location on the board
	 * @param loc
	 * Location of square being requested
	 * @return
	 * Square at Location requested
	 */
	public Square getSquare(Location loc){
		return board[loc.getRow()][loc.getCol()];
	}
	
	/**
	 * Sets the pieces in their initial chess Configurations
	 */
	public void setInitialConfiguration(){
		boolean black = false;
		boolean white = true;
		
		////////////// setting pawns //////////////////////
		for(int col = 0; col < WIDTH; col++){
			board[1][col].setPiece(new Pawn(black));
			board[6][col].setPiece(new Pawn(white));
		}
		/////////////// setting Rooks /////////////////////
		board[0][0].setPiece(new Rook(black));
		board[0][WIDTH-1].setPiece(new Rook(black));
		board[HEIGHT-1][0].setPiece(new Rook(white));
		board[HEIGHT-1][WIDTH-1].setPiece(new Rook(white));
		
		///////////// setting Knights /////////////////////
		board[0][1].setPiece(new Knight(black));
		board[0][WIDTH-2].setPiece(new Knight(black));
		board[HEIGHT-1][1].setPiece(new Knight(white));
		board[HEIGHT-1][WIDTH-2].setPiece(new Knight(white));
		
		///////////// setting Bishops//////////////////////
		board[0][2].setPiece(new Bishop(black));
		board[0][WIDTH-3].setPiece(new Bishop(black));
		board[HEIGHT-1][2].setPiece(new Bishop(white));
		board[HEIGHT-1][WIDTH-3].setPiece(new Bishop(white));
		
		///////////// setting Queens //////////////////////
		board[0][4].setPiece(new Queen(black));
		board[HEIGHT-1][3].setPiece(new Queen(white));
		
		///////////// setting Kings ///////////////////////
		board[0][3].setPiece(new King(black));
		board[HEIGHT-1][4].setPiece(new King(white));
		
		
	}
	
	public void printBoard(){
		
		for(int i = 0; i < HEIGHT; i++){
			System.out.print(i+ "  |");
			for(int j = 0; j < WIDTH; j++){
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println("    0 1 2 3 4 5 6 7 ");
	}
	
	
	/**
	 * Returns the values of the board as an integer array 
	 * Values are
	 * Pawn-0
	 * Rook-1
	 * Knight-2
	 * Bishop-3
	 * Queen-4
	 * King-5
	 * EMPTY = 9
	 * Values will be plus 10 if they are black
	 * @return
	 */
	public int[][]getBoardAsIntArray(){
		int[][] ret = new int[HEIGHT][WIDTH];
		for(int row = 0; row < HEIGHT; row++){
			for(int col = 0; col < WIDTH; col++){
				Piece temp = board[row][col].getPiece();
				if(temp != null){
					ret[row][col] = temp.getCode();
				}else{
					ret[row][col] = 9;
				}
			}
		}
		return ret;
	}
	
	public void printMoves(){
		for(int i = 0; i < HEIGHT; i++){
			for(int j = 0; j < WIDTH; j++){
				Piece p = board[i][j].getPiece();
				System.out.println(p);
				if(p != null){
					System.out.println(p.getAvailableMoves(this, new Location(i, j)));
				}
				System.out.println("-------------------------------");
			}
		}
	}
	
	/**
	 * get list of all available moves  for one color of pieces
	 * @param white
	 * true if you want moves for white pieces false for black moves
	 */
	public ArrayList<String> getMoves( boolean white){
		ArrayList<String> moves = new ArrayList<String>();
		for(int i = 0; i < HEIGHT; i++){
			for(int j = 0; j < WIDTH; j++){
				Piece p = board[i][j].getPiece();
				if(p != null && (p.isWhite() == white)){
					for(String s : p.getAvailableMoves(this, new Location(i, j))){
						moves.add(s);
					}
				}
			}
		}
		return moves;
	}
	
	/**
	 * 
	 * @return
	 */
	public Square[][] getBoard(){
		return this.board;
	}

}
