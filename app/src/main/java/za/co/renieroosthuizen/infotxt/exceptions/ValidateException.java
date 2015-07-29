package za.co.renieroosthuizen.infotxt.exceptions;

/**
 * Created by Renier on 2015/06/23.
 */
public class ValidateException extends Exception {

    private String message;

    public ValidateException(String message)
    {
        this.message = message;
    }

    public void setMessage(String message) { this.message = message; }
    public String getMessage() { return message; }

}
