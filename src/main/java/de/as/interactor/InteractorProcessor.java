package de.as.interactor;

import java.util.*;

public class InteractorProcessor {

    private List<Surrounding> filters = new LinkedList<>();

    public void execute(Interactor interactor, InteractorContext context) {
        try {
            doBefore(interactor, context);
            interactor.apply(context);
            doAfter(interactor, context);
        } catch (Exception ex) {
            handleException(interactor, context, ex);
        }

    }

    protected void handleException(Interactor interactor, InteractorContext context, Exception ex) {
        interactor.rollback(context);
        throw new InteractorException(interactor, context, ex);
    }

    private void doBefore(Interactor interactor, InteractorContext context) {
        for (Surrounding filter : filters) {
            filter.doBefore(interactor, context);
        }
    }

    protected void doAfter(Interactor interactor, InteractorContext context) {
        for (Surrounding filter : filters) {
            filter.doAfter(interactor, context);
        }
    }

    public void addFilter(Surrounding filter) {
        this.filters.add(filter);
    }

}
