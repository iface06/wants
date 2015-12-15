package de.as.interactor;

public interface Surrounding<I extends Interactor, C extends InteractorContext> {

    public void doBefore(I interactor, C context);

    public void doAfter(I interactor, C context);
}
