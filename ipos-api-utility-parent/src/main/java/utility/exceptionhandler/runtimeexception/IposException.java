package utility.exceptionhandler.runtimeexception;

public class IposException extends RuntimeException {
	
private int errorCode;
	
	private int statusCode;
	
	private String errorMessage;
	
	private String errorDetails;

	public IposException(int errorCode, int statusCode, String errorMessage, String errorDetails) {
		super();
		this.errorCode = errorCode;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}

	public IposException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
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
