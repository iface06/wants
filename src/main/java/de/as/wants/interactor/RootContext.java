package de.as.wants.interactor;

import de.as.interactor.InteractorContext;
import de.as.wants.app.entities.users.User;

public class RootContext implements InteractorContext {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
