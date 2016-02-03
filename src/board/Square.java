package board;
import piece.*;

/**
 * Class to hold all the information regarding one square of a chess board
 * 
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 */
public class Square {
	
	private boolean empty;
	private Piece piece;
	private Location loc;
	private final boolean isWhite;
	
	/**
	 * Constructor for Square
	 * @param loc
	 * {@code Location} of the square
	 * @param isWhite
	 * {@code boolean} that is true if square is white and flase if square is black
	 */
	public Square(Location loc, boolean isWhite){
		this.loc = loc;
		this.empty = true;
		this.piece = null;
		this.isWhite = isWhite;
	}
	
	/**
	 * Check if square is empty
	 * @return
	 * {@code boolean} that is true if square is empty
	 */
	public boolean isEmpty(){
		return this.empty;
	}
	
	/**
	 * Get location of square on the board
	 * @return
	 * {@code Location} of square
	 */
	public Location getLocation(){
		return this.loc;
	}
	
	/**
	 * Sets this square to be filled a.k.a not empty
	 */
	public void setFilled(){
		this.empty = false;
	}
	
	/**
	 * Sets this square to be empty
	 */
	public void setEmpty() {
		this.empty = true;
	}
	
	/**
	 * Check if square is white or black
	 * @return
	 * {@code boolean} true if square is white. false if it is black
	 */
	public boolean isWhite(){
		return isWhite;
	}
	
	/**
	 * set a piece to be on this square
	 * @param piece
	 * {@code Piece} the piece that is being set on this square
	 */
	public void setPiece(Piece piece){
		this.piece = piece;
		setFilled();
	}
	/**
	 * removes the piece from this square and sets the square to be empty
	 */
	public void removePiece(){
		this.piece = null;
		setEmpty();
	}
	
	/**
	 * Get the current piece on this square
	 * @return
	 * Reference to the {@code Piece} that is on this square 
	 */
	public Piece getPiece(){
		return this.piece;
	}
	
	
	/**
	 * Returns single string representation of of the piece in the square or a dash if empty
	 */
	public String toString(){
		if( piece instanceof Rook){
			return "r";
		}
		if(piece instanceof Knight){
			return "n";
		}
		if(piece instanceof Bishop){
			return "b";
		}
		if(piece instanceof Pawn){
			return "p";
		}
		if(piece instanceof Queen){
			return "q";
		}
		if(piece instanceof King){
			return "k";
		}
		if(isWhite){
			return "-";
		}
		return "-";
	}
}
