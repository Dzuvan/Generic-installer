package util;

import app.MainFrame;
import com.google.gson.JsonParseException;

/**
 *
 * Klasa koja baca zadužena za prikaz lokalizovanog izuzetka.
 */
public class MyJsonException extends JsonParseException {
    
    private static final long serialVersionUID = 1L;
    
    /**
     *
     * @param msg
     * @param cause
     */
    public MyJsonException(String msg, Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getLocalizedMessage() {
        return MainFrame.getInstance().getResourceBundle().getString("json-error");
    }
    
}
