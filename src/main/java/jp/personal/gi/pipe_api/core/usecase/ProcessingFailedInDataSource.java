package jp.personal.gi.pipe_api.core.usecase;

public class ProcessingFailedInDataSource extends Exception {
    public ProcessingFailedInDataSource(String message) {
        super(message);
    }

    public ProcessingFailedInDataSource(String message, Throwable cause) {
        super(message, cause);
    }
}
