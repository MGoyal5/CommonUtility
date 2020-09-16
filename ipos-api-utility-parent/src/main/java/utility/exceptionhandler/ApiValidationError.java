package utility.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ExceptionSubResponse{
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

	public ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

	public ApiValidationError()
	{
		super();
	}
	
    public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
