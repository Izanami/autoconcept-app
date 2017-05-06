package tk.ap17.app.autoconcept;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoconceptLogger {

	static public void setup() throws IOException {

		// get the global logger to configure it
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		logger.setLevel(Level.INFO);
	}
}
