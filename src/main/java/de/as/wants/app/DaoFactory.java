package de.as.wants.app;

import de.as.wants.app.useraccount.UserAccountDao;

public abstract class DaoFactory {

    public static DaoFactory INSTANCE;

    public abstract UserAccountDao getUserAccountDao();

}
