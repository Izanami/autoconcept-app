package tk.ap17.app.autoconcept.orm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ORM Logger
 *
 * setup() SHOULD call inside "main" function.
 *
 * Example :
 * <pre>{@code
 * class Foo {
 *  private static Logger logger = Logger.getLogger(ORMLogger.class.getName());
 *
 *  def baz() {
 *      logger.info("A notice message.");
 *  }
 * }
 * </pre>
 *
 * @author Kelian Bousquet
 */
public class ORMLogger {
    /**
     *
     * Configure handler logging.
     *
     *
     * @throws IOException
     */
    static public void setup() throws IOException {
        // Get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.INFO);
    }
}
