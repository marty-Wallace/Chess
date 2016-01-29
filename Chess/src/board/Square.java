package board;
import piece.*;

/**
 * @author Martin Wallace
 * <p> marty.wallace@ymail.com
 * <p> Jan 28th 2016
 */
public class Square {
	
	private boolean empty;
	private Piece piece;
	private Location loc;
	private final boolean isWhite;
	
	public Square(Location loc, boolean isWhite){
		this.loc = loc;
		this.empty = true;
		this.piece = null;
		this.isWhite = isWhite;
	}
	
	public boolean isEmpty(){
		return this.empty;
	}
	
	public Location getLocation(){
		return this.loc;
	}
	public void setFilled(){
		this.empty = false;
	}
	public void setEmpty() {
		this.empty = true;
	}
	
	public boolean isWhite(){
		return isWhite;
	}
	public void setPiece(Piece piece){
		this.piece = piece;
		setFilled();
	}
	public void removePiece(){
		this.piece = null;
		setEmpty();
	}
	public Piece getPiece(){
		return this.piece;
	}
	
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
