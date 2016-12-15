package Command.exceptions;

import java.io.IOException;

/**
 * Created by yevgen on 13.12.16.
 */
public class StreamException extends IOException {
    //IOException if an I/O error occurs

    public StreamException(String message) {
        super(message);
    }
}
