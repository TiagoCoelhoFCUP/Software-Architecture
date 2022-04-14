package rsa.shared;

public class RideSharingAppException extends java.lang.Exception{
	private static final long serialVersionUID = 1L;
	String message;
	Throwable cause;
	boolean enableSuppression;
	boolean writableStackTrace;
	
	public RideSharingAppException() {
		this.message = null;
	}
	
	public RideSharingAppException(String message) {
		this.message = message;
	}
	
	public RideSharingAppException(String message,Throwable cause) {
		this.message = message;
		this.cause = cause;
	}
	
	public RideSharingAppException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
		this.message = message;
		this.cause = cause;
		this.enableSuppression = enableSuppression;
		this.writableStackTrace = writableStackTrace;
	}
	
	public RideSharingAppException(Throwable cause) {
		this.message = (cause==null ? null : cause.toString());
		this.cause = cause;
	}
	
}
