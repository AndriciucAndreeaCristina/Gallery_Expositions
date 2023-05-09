package pao.lab9;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLogger {
    private static final Logger logger = Logger.getLogger(SimpleLogger.class.getName());

    public static void main(String[] args) {
        // Create a console handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); // Set the logging level for the console handler

        // Configure the logger
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL); // Set the logging level for the logger

        // Log messages with different log levels
        logger.severe("This is a severe message");
        logger.warning("This is a warning message");
        logger.info("This is an info message");
    }
}
