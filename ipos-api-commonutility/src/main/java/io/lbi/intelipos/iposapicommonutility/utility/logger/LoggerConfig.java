package io.lbi.intelipos.iposapicommonutility.utility.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import io.lbi.intelipos.iposapicommonutility.IposApiCommonutilityApplication;

@Component
public class LoggerConfig {

	private static final Logger logger = LogManager.getLogger(IposApiCommonutilityApplication.class);
	
	public Logger getLoggerObj()
	{
		return logger;
	}
}
