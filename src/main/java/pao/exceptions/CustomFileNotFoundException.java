package pao.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomFileNotFoundException extends Exception{
    private Logger logger = Logger.getLogger("Exception");
    public CustomFileNotFoundException(String message) {
        super(message);
        logger.log(Level.SEVERE, "File inexistent!");
    }
}
