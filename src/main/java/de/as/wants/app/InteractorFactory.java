package de.as.wants.app;

import de.as.interactor.Interactor;

public abstract class InteractorFactory {

    public static InteractorFactory INSTANCE;

    public Interactor getInteractor(Class<Interactor> cl) {
        try {
            return cl.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            handleException(ex, cl);
        }

        return Interactor.DO_NOTHING;
    }

    protected void handleException(java.lang.ReflectiveOperationException ex, Class<Interactor> cl) {
        throw new RuntimeException("Error while instanciation the interactor: " + cl.getName(), ex);
    }

}
