package utility.exceptionhandler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import utility.constants.ErrorStatus;
import utility.exceptionhandler.runtimeexception.IposException;

//@EnableWebMvc
@ControllerAdvice
@Component
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorStatus.HANDLEALLEXCEPTION.getValue(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorStatus.HANDLEALLEXCEPTION.getReasonPhrase(),
				ErrorStatus.HANDLEALLEXCEPTION.getSuggestion());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorStatus.METHODARGUMENTTYPEMISMATCH.getValue(),
				HttpStatus.NOT_ACCEPTABLE.value(), ErrorStatus.METHODARGUMENTTYPEMISMATCH.getReasonPhrase(),
				ErrorStatus.METHODARGUMENTTYPEMISMATCH.getSuggestion());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				ErrorStatus.MISSINGSERVLETREQUESTPARAMETER.getValue(), HttpStatus.BAD_REQUEST.value(),
				ErrorStatus.MISSINGSERVLETREQUESTPARAMETER.getReasonPhrase(),
				ErrorStatus.MISSINGSERVLETREQUESTPARAMETER.getSuggestion());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ServletWebRequest servletWebRequest = (ServletWebRequest) request;
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorStatus.MESSAGENOTREADABLE.getValue(),
				HttpStatus.BAD_REQUEST.value(), ErrorStatus.MESSAGENOTREADABLE.getReasonPhrase(),
				ErrorStatus.MESSAGENOTREADABLE.getSuggestion());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorStatus.HTTPMEDIATYPENOTSUPPORTED.getValue(),
				HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), ErrorStatus.HTTPMEDIATYPENOTSUPPORTED.getReasonPhrase(),
				ErrorStatus.HTTPMEDIATYPENOTSUPPORTED.getSuggestion());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorStatus.NOHANDLERFOUND.getValue(),
				HttpStatus.BAD_REQUEST.value(), ErrorStatus.NOHANDLERFOUND.getReasonPhrase(),
				ErrorStatus.NOHANDLERFOUND.getSuggestion());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(IposException.class)
	public final ResponseEntity<ExceptionResponse> handleIposException(IposException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = null;
		if(ErrorStatus.ENTITYNOTFOUND.getReasonPhrase().equals(ex.getErrorMessage()))
				{
			exceptionResponse = new ExceptionResponse(ErrorStatus.ENTITYNOTFOUND.getValue(),HttpStatus.NOT_FOUND.value(),ErrorStatus.ENTITYNOTFOUND.getReasonPhrase(),ErrorStatus.ENTITYNOTFOUND.getSuggestion());
				}
		else if(ErrorStatus.ENTITYALREADYEXIST.getReasonPhrase().equals(ex.getErrorMessage()))
		{
			exceptionResponse = new ExceptionResponse(ErrorStatus.ENTITYALREADYEXIST.getValue(),HttpStatus.NOT_FOUND.value(),ErrorStatus.ENTITYALREADYEXIST.getReasonPhrase(),ErrorStatus.ENTITYALREADYEXIST.getSuggestion());
		}
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}
	
	
}
