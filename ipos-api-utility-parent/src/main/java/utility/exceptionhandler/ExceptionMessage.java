package utility.exceptionhandler;

public class ExceptionMessage {

	private int errorCode;
	
	private int statusCode;
	
	private String errorMessage;
	
	private String errorDetails;

	public int getErrorCode() {
		return errorCode;
	}

	/*
	 * public ExceptionMessage(int errorCode, String errorMessage) { super();
	 * this.errorCode = errorCode; this.errorMessage = errorMessage; }
	 */
	
	
	public ExceptionMessage(int statusCode, String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
}
