package jp.personal.gi.pipe_api.adapter.logger;

public interface Logger {
    void fatal(String message);

    void error(String message);

    void debug(String message);
}
