package jp.personal.gi.pipe_api.core.usecase.account.find;

public class FindException extends Exception {
    public FindException(String message) {
        super(message);
    }

    public FindException(String message, Throwable cause) {
        super(message, cause);
    }
}
