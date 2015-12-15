package de.as.wants.app.useraccount;

import de.as.wants.interactor.RootContext;

public class UserAccountContext extends RootContext {

    private String password;
    private String emailAddress;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
