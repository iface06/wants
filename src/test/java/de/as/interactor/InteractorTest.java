package de.as.interactor;

import de.as.wants.app.entities.users.User;
import org.junit.*;

public class InteractorTest {

    /**
     * Warum sollte das DAO durch eine Factory injiziert werden? - Der
     * Softwareentwickler kann dadurch einen Interactor einfach instanzieren,
     * ohne wissen zu müssen wie die Abhängigkeiten aufgebaut werden. -
     * Abhängigkeiten können in Testumgebung gebrochen bzw. umgebogen werden -
     * ...
     */
    @Test
    public void breakDaoDependency_RealDao() {

        DaoFactory.INSTANCE = new LocalDbDaoFactory();
        Interactor testInteractor = new TestInteractor();
        TestContext ctx = new TestContext();
        testInteractor.apply(ctx);
        Assert.assertNotNull(ctx.getUser());
        Assert.assertEquals("Real User", ctx.getUser().getUsername());

    }

    @Test
    public void breakDaoDependency_MockDao() {
        DaoFactory.INSTANCE = new MockDbDaoFactory();
        TestContext ctx = new TestContext();
        Interactor testInteractor = new TestInteractor();
        testInteractor.apply(ctx);
        Assert.assertNotNull(ctx.getUser());
        Assert.assertEquals("Mock User", ctx.getUser().getUsername());
    }

    static abstract class DaoFactory {

        public static DaoFactory INSTANCE;

        public abstract UserDao getUserDao();
    }

    static class LocalDbDaoFactory extends DaoFactory {

        @Override
        public UserDao getUserDao() {
            return new LocalDbUserDao();
        }

    }

    static class MockDbDaoFactory extends DaoFactory {

        @Override
        public UserDao getUserDao() {
            return new MockUserDao();
        }

    }

    static class TestInteractor implements Interactor<TestContext> {

        private UserDao dao = DaoFactory.INSTANCE.getUserDao();

        @Override

        public void apply(TestContext ctx) {
            User user = dao.getUser("1234");
            ctx.setUser(user);
        }

        @Override
        public void rollback(TestContext ctx) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    static class TestContext implements InteractorContext {

        User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    static class LocalDbUserDao implements UserDao {

        @Override
        public User getUser(String id) {
            User u = new User();
            u.setId(id);
            u.setUsername("Real User");
            return u;
        }

    }

    static class MockUserDao implements UserDao {

        @Override
        public User getUser(String id) {
            User u = new User();
            u.setId(id);
            u.setUsername("Mock User");
            return u;
        }

    }

    static interface UserDao {

        public User getUser(String id);
    }

}
