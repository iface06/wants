package de.as.wants.app;

import de.as.wants.app.database.UserAccounts;
import de.as.wants.app.useraccount.UserAccountDao;

public class PersistanceDaoFactory extends DaoFactory {

    @Override
    public UserAccountDao getUserAccountDao() {
        return new UserAccounts();
    }

}
