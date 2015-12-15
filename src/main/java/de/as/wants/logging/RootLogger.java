package de.as.wants.logging;

import org.apache.log4j.*;
import org.apache.log4j.spi.*;

class RootLogger implements ApplicationLogger {

    public static LoggerConfiguration DEFAULT_CONFIGRUATION = new LoggerConfiguration();

    protected static LoggerFactory DEFAULT_LOGGER_FACTORY = new LoggerFactory() {
        @Override
        public Logger makeNewLoggerInstance(String string) {
            Logger logger = Logger.getLogger(string);
            for (Appender appender : DEFAULT_CONFIGRUATION.getAppender()) {
                logger.addAppender(appender);
            }

            return logger;
        }
    };

    private Logger logger;
    private String FQCN;
    private LoggerConfiguration configuration;

    public RootLogger(Class c) {
        FQCN = this.getClass().getName();
        logger = Logger.getLogger(c.getName(), DEFAULT_LOGGER_FACTORY);
        configuration = DEFAULT_CONFIGRUATION;
    }

    public RootLogger(Class c, LoggerConfiguration conf) {
        FQCN = this.getClass().getName();
        logger = Logger.getLogger(c.getName(), DEFAULT_LOGGER_FACTORY);
        configuration = conf;
    }

    public void trace(Log log) {
        logger.log(FQCN, Level.TRACE, log, log.getException());
    }

    public void debug(Log log) {
        logger.log(FQCN, Level.DEBUG, log, log.getException());
    }

    public void info(Log log) {
        logger.log(FQCN, Level.INFO, log, log.getException());
    }

    public void warn(Log log) {
        logger.log(FQCN, Level.WARN, log, log.getException());
    }

    public void error(Log log) {
        logger.log(FQCN, Level.ERROR, log.toString(), log.getException());
    }

    public void fatal(Log log) {
        logger.log(FQCN, Level.FATAL, log, log.getException());
    }

}
