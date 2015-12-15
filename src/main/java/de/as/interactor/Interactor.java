package de.as.interactor;

public interface Interactor<CONTEXT extends InteractorContext> {

    public void apply(CONTEXT ctx);

    public void rollback(CONTEXT ctx);

    public static Interactor DO_NOTHING = new Interactor() {

        @Override
        public void apply(InteractorContext ctx) {
        }

        @Override
        public void rollback(InteractorContext ctx) {
        }
    };

}
