package jp.personal.gi.pipe_api.core.usecase;

public class CouldNotAccessDataSource extends Exception {
    public CouldNotAccessDataSource(String message) {
        super(message);
    }

    public CouldNotAccessDataSource(String message, Throwable cause) {
        super(message, cause);
    }
}
