package utility.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
	  
	/**
	 * helper class d() to log debug level information.
	 */
	public static void debug(Class<?> cls, String message)
	{
		Logger log = LogManager.getLogger(cls);
		log.debug(message);
	}
	
	
	/**
	 * helper class i() to log info level information.
	 */
	public static void info(Class<?> cls, String message)
	{
		Logger log = LogManager.getLogger(cls);
		log.info(message);
	}
	
	public static void info(String message)
	{
		Logger log = LogManager.getLogger();
		log.info(message);
	}
	
	/**
	 * helper class w() to log warning level information.
	 */
	public static void warn(Class<?> cls, String message)
	{
		Logger log = LogManager.getLogger(cls);
		log.warn(message);
	}
	
	
	
	/**
	 * helper class e() to log error information.
	 */
	public static void error(Class<?> cls, String message)
	{
		Logger log = LogManager.getLogger(cls);
		log.error(message);
	}
	
	
	
	/**
	 * helper class f() to log fatal level information.
	 */
	public static void fatal(Class<?> cls, String message)
	{
		Logger log = LogManager.getLogger(cls);
		log.fatal(message);
	}
	
	
	
	/**
	 * helper class t() to log trace information.
	 */
	public static void trace(Class<?> cls, String message)
	{
		Logger log = LogManager.getLogger(cls);
		log.trace(message);
	}
}