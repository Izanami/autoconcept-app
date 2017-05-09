package tk.ap17.app.autoconcept.orm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ORM Logger
 *
 * @author Kelian Bousquet
 */
public class ORMLogger {
    /**
     *
     * Configure handler logging.
     *
     * It SHOULD call inside "main" function.
     *
     * Example :
     *
     * class Foo {
     *  private static Logger logger = Logger.getLogger(AutoconceptLogger.class.getName());
     *
     *  def baz() {
     *      logger.info("A notice message.");
     *  }
     * }
     *
     * @throws IOException
     */
    static public void setup() throws IOException {
        // Get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.INFO);
    }
}
