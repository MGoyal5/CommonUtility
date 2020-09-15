package utility.exceptionhandler.runtimeexception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String exception) {
		super(exception);
	}
}
