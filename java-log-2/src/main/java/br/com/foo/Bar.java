package br.com.foo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Bar {
	static final Logger logger = (Logger) LogManager.getLogger(Bar.class.getName());

	public boolean doIt() {
		logger.entry();
		logger.error("Did it again!");
		return logger.exit(false);
	}
}
