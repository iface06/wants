package de.as.wants.sessions;

import de.as.wants.app.entities.users.User;
import java.util.UUID;

public interface SessionManager<T extends Session> {

    T get(UUID uuid);

    T open(UUID uuid, User user);

    T close(UUID uuid);
}
