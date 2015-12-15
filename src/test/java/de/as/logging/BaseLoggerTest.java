package de.as.logging;

import de.as.wants.logging.*;
import java.io.*;
import org.junit.*;

public class BaseLoggerTest {

    @Test
    public void testBasicConfiguration() throws IOException {
        ApplicationLogger logger = ApplicationLogger.getLogger(BaseLoggerTest.class);

        Log log = new Log();
        log.setMessage("Erstes Test Log auf der Console");
        logger.info(log);

    }

    @Test
    public void testCreateLog() {
        Log log = new Log();
        log.setUserId("123-123dsd-123212312");
        log.setSessionId("609fs-dfda23-223233-2323");

        log.setMessage("Message to the Exception");

        ApplicationLogger logger = ApplicationLogger.getLogger(BaseLoggerTest.class);
        logger.error(log);

    }

}
