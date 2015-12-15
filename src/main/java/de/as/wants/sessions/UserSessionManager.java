package de.as.wants.sessions;

import de.as.wants.app.entities.users.User;
import java.util.*;

public class UserSessionManager implements SessionManager<UserSession> {

    private static Map<UUID, UserSession> sessions = new HashMap<>();

    public UserSession get(UUID uuid) {
        return sessions.get(uuid);
    }

    public UserSession open(UUID uuid, User user) {
        return sessions.put(uuid, new UserSession(user, uuid));
    }

    public UserSession close(UUID uuid) {
        return sessions.remove(uuid);
    }
}
