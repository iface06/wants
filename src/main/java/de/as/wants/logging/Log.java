package de.as.wants.logging;

public class Log {

    protected static String SEPERATOR = "| ";

    private String userId;
    private String sessionId;
    private String message;
    private Exception exception;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return sessionId + SEPERATOR + userId + SEPERATOR + message;
    }

}
