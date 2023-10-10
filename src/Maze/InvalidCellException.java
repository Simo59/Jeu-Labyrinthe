package Maze;

public class InvalidCellException extends RuntimeException {

	public InvalidCellException() {}
	
	public InvalidCellException (String msg) {
		super(msg);
	}
}