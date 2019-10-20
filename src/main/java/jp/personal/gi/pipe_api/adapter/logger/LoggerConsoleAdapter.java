package jp.personal.gi.pipe_api.adapter.logger;

import org.springframework.stereotype.*;

import java.time.*;
import java.time.format.*;

@Component
public class LoggerConsoleAdapter implements Logger {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS::");

    private String createTimeStamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    @Override
    public void fatal(String message) {
        System.out.println(this.createTimeStamp() + "FATAL - " + message);
    }

    @Override
    public void error(String message) {
        System.out.println(this.createTimeStamp() + "ERROR - " + message);
    }

    @Override
    public void debug(String message) {
        System.out.println(this.createTimeStamp() + "DEBUG - " + message);
    }
}
