package de.as.wants.logging;

import java.util.*;
import org.apache.log4j.*;

public class LoggerConfiguration {

    private int bufferSize = 500;
    private PatternLayout layout = new PatternLayout("%-5p| %d| %m%n");
    private List<Appender> appender = Arrays.asList(new ConsoleAppender(layout));

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public PatternLayout getLayout() {
        return layout;
    }

    public void setLayout(PatternLayout layout) {
        this.layout = layout;
    }

    public List<Appender> getAppender() {
        return appender;
    }

    public void setAppender(List<Appender> appender) {
        this.appender = appender;
    }

}
