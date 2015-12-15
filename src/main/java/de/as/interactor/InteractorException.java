package de.as.interactor;

class InteractorException extends RuntimeException {

    private final Interactor interactor;
    private final InteractorContext context;

    public InteractorException(Interactor interactor, InteractorContext context, Exception ex) {
        super("Error while executing Interactor: " + interactor.getClass().getName(), ex);
        this.interactor = interactor;
        this.context = context;
    }

    public Interactor getInteractor() {
        return interactor;
    }

    public InteractorContext getContext() {
        return context;
    }

}
