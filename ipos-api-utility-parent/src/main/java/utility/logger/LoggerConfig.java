package utility.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerConfig {

	private static final Logger logger = LogManager.getLogger();
	
	public Logger getLoggerObj()
	{
		return logger;
	}
}
