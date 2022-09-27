package utils.security.log;

import org.slf4j.LoggerFactory;

interface Logger {
    private org.slf4j.Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }
}
