package utility.constants;

public enum ErrorStatus {
    
	HANDLEALLEXCEPTION(101,"Bad Request","Please recheck your inputs"),
    ENTITYNOTFOUND(102, "Entity Not Found","Entity not registered in database.please create the entry"),
    ENTITYALREADYEXIST(103,"Entity Already Exist","Entity seems to be already registered"),
    METHODARGUMENTTYPEMISMATCH(104,"Input not allowed","please recheck the input type"),
    MISSINGSERVLETREQUESTPARAMETER(105,"Parameter is missing","Please recheck the parameters"),
    MESSAGENOTREADABLE(106,"Input not readable","Please recheck the inputs"),
    HTTPMEDIATYPENOTSUPPORTED(107,"Unsupported Media Type","Supported Media Type are JSON and XML"),
    NOHANDLERFOUND(108,"Couldnt find the method to handle","Please recheck the input"),
    DATAINTEGRITYVIOLATION(109,"DB Error Detected","Can be beacuse of conflict or an internal server error") ;
	
    
    public String getSuggestion() {
		return suggestion;
	}
	private final int value;
    private final String reasonPhrase;
    private final String suggestion;
    private ErrorStatus(int value, String reasonPhrase, String suggestion) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
		this.suggestion = suggestion;
	}
	
    public int getValue() {
        return value;
    }
    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
