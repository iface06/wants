package de.as.wants.app.useraccount;

import de.as.interactor.Interactor;
import de.as.wants.app.DaoFactory;
import de.as.wants.app.entities.users.User;
import java.util.Objects;

public class LoginInteractor implements Interactor<UserAccountContext> {

    private final UserAccountDao dao = DaoFactory.INSTANCE.getUserAccountDao();

    @Override
    public void apply(UserAccountContext r) {
        User user = dao.findByEmailAddress(r.getEmailAddress());
        if (Objects.equals(user.getEmailAddress(), r.getEmailAddress())
                && Objects.equals(user.getPassword(), r.getPassword())) {
            r.setUser(user);
        } else {
            r.setUser(User.EMPTY);
        }
    }

    @Override
    public void rollback(UserAccountContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
