package de.as.wants.sessions;

import de.as.wants.app.entities.users.User;
import java.util.UUID;

public class UserSession implements Session {

    private User user;
    private UUID sessionId;

    public UserSession(UUID sessionId) {
        this.user = user;
        this.sessionId = sessionId;
    }

    UserSession(User user, UUID sessionId) {
        this.user = user;
        this.sessionId = sessionId;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getSessionId() {
        return sessionId;
    }
}
