import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class MyLogger {
	private Logger logger = (Logger) LogManager.getLogger(this.getClass()
			.getName());

	public void check() {

		long withCOunt = 0;
		long withOutCount = 0;

		for (int i = 0; i < 1000; i++) {

			// with debug
			long start = System.currentTimeMillis();
			for (int n = 0; n < 1000; n++) {
				if (logger.isDebugEnabled())
					logger.debug(n);
			}
			long end = System.currentTimeMillis();
			withCOunt = withCOunt + (end - start);

			// with out debug
			long start2 = System.currentTimeMillis();
			for (int j = 0; j < 1000; j++) {
				logger.debug(j);
			}
			long end2 = System.currentTimeMillis();
			withOutCount = withOutCount + (end2 - start2);
		}

		System.out.println("Total Time Elapsed(With isDebugEnabled) : "
				+ withCOunt);
		System.out.println("Total Time Elapsed(Without isDebugEnabled) : "
				+ withOutCount);
	}

	public static void main(String[] args) {
		MyLogger myLogger = new MyLogger();
		myLogger.check();
	}
}
