package jp.personal.gi.pipe_api.core.usecase;

public class NoEntityWithIdWasFound extends Exception {
    public NoEntityWithIdWasFound(String message) {
        super(message);
    }

    public NoEntityWithIdWasFound(String message, Throwable cause) {
        super(message, cause);
    }
}
