package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
	private static Logger logger = LogManager.getLogger(TestLogger.class);

	public static void info(String message) {
		logger.info(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void startTestCase(String testName) {
		logger.info("====== TEST STARTED: " + testName + " ======");
	}

	public static void endTestCase(String testName) {
		logger.info("====== TEST FINISHED: " + testName + " ======");
	}
}