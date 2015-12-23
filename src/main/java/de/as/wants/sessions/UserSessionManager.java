package de.as.wants.sessions;

import de.as.wants.app.entities.users.User;
import java.util.*;

public class UserSessionManager implements SessionManager<UserSession> {

    private static Map<UUID, UserSession> sessions = new HashMap<>();

    @Override
    public UserSession get(UUID uuid) {
        UserSession session = sessions.get(uuid);
        if (session == null) {
            session = UserSession.EMPTY;
        }
        return session;
    }

    @Override
    public UserSession open(UUID uuid, User user) {
        return sessions.put(uuid, new UserSession(user, uuid));
    }

    @Override
    public UserSession close(UUID uuid) {
        return sessions.remove(uuid);
    }
}
