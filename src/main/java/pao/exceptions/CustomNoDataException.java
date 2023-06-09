package pao.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomNoDataException extends Exception {
    private Logger logger = Logger.getLogger("Exception");
    public CustomNoDataException(String message) {
        super(message);
        logger.log(Level.WARNING, "Data not found!");
    }
}
