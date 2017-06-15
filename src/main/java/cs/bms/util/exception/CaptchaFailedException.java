package cs.bms.util.exception;

public class CaptchaFailedException
        extends Exception {

    public CaptchaFailedException() {
    }

    public CaptchaFailedException(String message) {
        super(message);
    }
}
