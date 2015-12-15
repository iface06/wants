package de.as.wants.app.useraccount;

import de.as.wants.app.DaoFactory;

class MockDaoFactory extends DaoFactory {

    private final UserAccountDao userAccountDao;

    MockDaoFactory(UserAccountDao dao) {
        this.userAccountDao = dao;

    }

    @Override
    public UserAccountDao getUserAccountDao() {
        return userAccountDao;
    }

}
