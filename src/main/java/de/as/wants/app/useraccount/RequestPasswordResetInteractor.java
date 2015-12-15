package de.as.wants.app.useraccount;

import de.as.interactor.Interactor;

public class RequestPasswordResetInteractor implements Interactor<UserAccountContext> {

    @Override
    public void apply(UserAccountContext r) {

    }

    @Override
    public void rollback(UserAccountContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
