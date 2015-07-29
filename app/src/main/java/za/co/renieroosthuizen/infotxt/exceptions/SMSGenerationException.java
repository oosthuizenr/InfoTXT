package za.co.renieroosthuizen.infotxt.exceptions;

/**
 * Created by Renier on 2015/06/23.
 */
public class SMSGenerationException extends Exception {

    private String message;
    public void setMessage(String message) { this.message = message; }
    public String getMessage() { return message; }

}
