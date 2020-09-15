package utility.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import utility.exceptionhandler.runtimeexception.EntityAlreadyExistException;
import utility.exceptionhandler.runtimeexception.EntityNotFoundException;



@ControllerAdvice

public class RestExceptionHandler  extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(101,500,"Bad Request","Internal Server Error");
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	  @ExceptionHandler(EntityNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(EntityNotFoundException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(102,404,"Entity Not Found","User details not registered in database.please create the entry");
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(EntityAlreadyExistException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserAlreadyExistException(EntityAlreadyExistException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(103,406,"Entity Already Exists","please recheck the user deatils,the user details seems to be already registered");
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	  }

}
