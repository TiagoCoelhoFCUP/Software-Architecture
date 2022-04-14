package rsa.quad;

/**
 * Exception raised when the quad tree is used with a point outside its boundaries.
 * @author Tiago Coelho e Vasco Soares;
 */

public class PointOutOfBoundException extends java.lang.RuntimeException {
	private static final long serialVersionUID = 1L;
	String message;
	
	public PointOutOfBoundException() {
		this.message = "PoinOutOfBoundException";
	}

}
