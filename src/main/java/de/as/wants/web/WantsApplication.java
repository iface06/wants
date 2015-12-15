package de.as.wants.web;

import de.as.wants.app.*;
import de.as.wants.web.statics.ViewResource;
import de.as.wants.web.useraccount.*;
import org.restlet.*;
import org.restlet.data.*;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class WantsApplication extends Application {

    private static final String ROOT_URI = "file:///" + System.getProperty("user.dir");
    private static final String WEB_CONTENT = ROOT_URI + "/resources/statics";

    public static void main(String[] args) throws Exception {
        Component server = new Component();
        server.getClients().add(Protocol.FILE);
        server.getServers().add(Protocol.HTTP, 8182);

        server.getDefaultHost().attach("/wants", new WantsApplication());
        DaoFactory.INSTANCE = new PersistanceDaoFactory();
        server.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/view/{name}", ViewResource.class);
        router.attach("/login/{emailaddress}/{password}", LoginResource.class);
        router.attach("/logout", LogoutResource.class);
        Directory d = new Directory(getContext(), WEB_CONTENT);
        d.setListingAllowed(true);
        d.setDeeplyAccessible(true);
        router.attach("/files", d);

        return router;
    }

}
