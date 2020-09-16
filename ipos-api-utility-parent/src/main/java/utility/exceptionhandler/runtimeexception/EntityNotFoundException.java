package utility.exceptionhandler.runtimeexception;

/*import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;*/


public class EntityNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String exception) {
		super(exception);
	}
}
