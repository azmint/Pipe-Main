package jp.personal.gi.pipe_api.adapter.logger;

import org.slf4j.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.time.format.*;

@Component
public class Slf4jAdapter implements Logger {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(Slf4jAdapter.class);

    @Override
    public void fatal(String message) {
        logger.error("FATAL: " + message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }
}
