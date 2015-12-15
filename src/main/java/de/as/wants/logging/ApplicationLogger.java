package de.as.wants.logging;

public interface ApplicationLogger {

    public static ApplicationLogger getLogger(Class c) {
        return new RootLogger(c);
    }

    public void trace(Log log);

    public void debug(Log log);

    public void info(Log log);

    public void warn(Log log);

    public void error(Log log);

    public void fatal(Log log);

}
