package de.as.wants.app.useraccount;

import de.as.wants.app.entities.users.User;

public interface UserAccountDao {

    public User findByEmailAddress(String emailaddress);

}
