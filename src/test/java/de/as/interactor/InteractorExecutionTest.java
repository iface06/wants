package de.as.interactor;

import de.as.wants.app.entities.users.User;
import de.as.wants.interactor.RootContext;
import org.junit.*;

public class InteractorExecutionTest {

    private InteractorProcessor processor;
    private RootContext context;
    private Interactor interactor;

    @Before
    public void before() {
        processor = new InteractorProcessor();
        context = new RootContext();
        interactor = new Interactor<RootContext>() {

            @Override
            public void apply(RootContext ctx) {
                System.out.println("apply interactor");
                ctx.setUser(User.EMPTY);
            }

            @Override
            public void rollback(RootContext ctx) {
                System.out.println("rollback interactor");
                ctx.setUser(null);
            }
        };
    }

    @Test
    public void testDoBeforeAndBefore() {

        processor.addFilter(new Surrounding() {

            @Override
            public void doBefore(Interactor interactor, InteractorContext context) {
                System.out.println("do before");
            }

            @Override
            public void doAfter(Interactor interactor, InteractorContext context) {
                System.out.println("do after");
            }
        });

        processor.execute(interactor, context);

        org.junit.Assert.assertNotNull(context.getUser());
    }

    @Test(expected = InteractorException.class)
    public void testRollback() {

        processor.execute(new Interactor<RootContext>() {

            @Override
            public void apply(RootContext ctx) {
                ctx.setUser(User.EMPTY);
                throw new RuntimeException("Something goes wrong...");
            }

            @Override
            public void rollback(RootContext ctx) {
                ctx.setUser(null);
            }
        }, context);

        org.junit.Assert.assertNull(context.getUser());
    }

}
