package utility.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import utility.exceptionhandler.ExceptionResponse;
//import utility.exceptionhandler.ExceptionResponse;
import utility.exceptionhandler.runtimeexception.EntityAlreadyExistException;
import utility.exceptionhandler.runtimeexception.EntityNotFoundException;



@ControllerAdvice
@Component
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	  @ExceptionHandler(Exception.class) 
	  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex,WebRequest request){
		  ExceptionResponse exceptionResponse = new ExceptionResponse(101,500,"Bad Request","Internal Server Error"); 
		  return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 

	  @ExceptionHandler(EntityNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(EntityNotFoundException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(102,404,"Entity Not Found","User details not registered in database.please create the entry");
	    return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(EntityAlreadyExistException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserAlreadyExistException(EntityAlreadyExistException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(103,406,"Entity Already Exists","please recheck the user deatils,the user details seems to be already registered");
	    return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	  }

	  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
      protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                        WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(104,406,"Input not allowed","please recheck the input deatils");
          return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
      }
	  
	  @Override
      protected ResponseEntity<Object> handleMissingServletRequestParameter(
              MissingServletRequestParameterException ex, HttpHeaders headers,
              HttpStatus status, WebRequest request) {
          ExceptionResponse exceptionResponse = new ExceptionResponse(108,406,"Parameter is missing","please recheck the parameters");
          return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
      }
}
