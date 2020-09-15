package utility.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import utility.exceptionhandler.ExceptionSubResponse;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ExceptionSubResponse {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }


	public ApiValidationError(String object2, String field2, Object rejectedValue2, String message2) {
		// TODO Auto-generated constructor stub
	}}