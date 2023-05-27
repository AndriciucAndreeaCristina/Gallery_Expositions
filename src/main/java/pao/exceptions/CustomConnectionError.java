package pao.exceptions;

import java.util.logging.Logger;

public class CustomConnectionError extends Exception {
    private Logger logger = Logger.getLogger("Exception");
    public CustomConnectionError(String message) {
        super(message);

    }
}
