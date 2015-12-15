package de.as.wants.app.database;

import de.as.wants.app.entities.users.User;
import de.as.wants.app.useraccount.UserAccountDao;

public class UserAccounts implements UserAccountDao {

    @Override
    public User findByEmailAddress(String emailaddress) {
        User user = new User();
        user.setEmailAddress("musterman@as.local");
        user.setPassword("123456");
        user.setUsername("MaxMusty");
        return user;
    }

}
