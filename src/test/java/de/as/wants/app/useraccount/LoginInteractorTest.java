package de.as.wants.app.useraccount;

import de.as.wants.app.DaoFactory;
import de.as.wants.app.entities.users.User;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginInteractorTest {

    private LoginInteractor interactor;

    @Test
    public void testSuccessfullLogin() {

        UserAccountContext login = new UserAccountContext();
        login.setPassword("234565");
        login.setEmailAddress("musterman@as.local");
        interactor.apply(login);

        assertEquals("musterman@as.local", login.getUser().getEmailAddress());
    }

    @Test
    public void testNotSucessfullLogin() {

        UserAccountContext login = new UserAccountContext();
        login.setPassword("wrongPassword!");
        login.setEmailAddress("wrongUsername@as.local");
        interactor.apply(login);

        assertEquals(User.EMPTY, login.getUser());

    }

    @BeforeClass
    public static void beforeClass() {
        UserAccountDao dao = createDao();
        DaoFactory.INSTANCE = new MockDaoFactory(dao);
    }

    @Before
    public void before() {
        interactor = new LoginInteractor();
    }

    @AfterClass
    public static void tearDown() {
        DaoFactory.INSTANCE = null;
    }

    public static UserAccountDao createDao() {
        User musterman = new User();
        musterman.setEmailAddress("musterman@as.local");
        musterman.setPassword("234565");

        UserAccountDao dao = mock(UserAccountDao.class);
        when(dao.findByEmailAddress(anyString())).thenReturn(musterman);

        return dao;
    }

}
