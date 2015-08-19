
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import br.com.foo.Bar;

public class MyApp {
	// Define a static logger variable so that it references the
	// Logger instance named "MyApp".

	// Define uma variável logger static que referencia uma instancia de Logger
	// chamada de MyApp
	static final Logger logger = (Logger) LogManager.getLogger(MyApp.class.getName());

	public static void main(String[] args) {

		// Uma aplicação simples que mostra o log no console

		logger.trace("Entering application.");
		Bar bar = new Bar();
		if (!bar.doIt()) {
			logger.error("Didn't do it.");
		}
		logger.trace("Exiting application.");
	}

}
