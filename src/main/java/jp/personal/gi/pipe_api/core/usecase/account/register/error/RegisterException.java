package jp.personal.gi.pipe_api.core.usecase.account.register.error;

public class RegisterException extends Exception {
    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
