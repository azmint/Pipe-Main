package jp.personal.gi.pipe_api.core.usecase.account.register.error;

public class GenerateIdException extends Exception {
    public GenerateIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
