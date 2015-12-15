package de.as.wants.web.statics;

import org.restlet.representation.*;
import org.restlet.resource.*;

public class ViewResource extends ServerResource {

    @Get
    public Representation createView() {
        String requestedView = String.valueOf(getRequestAttributes().get("name"));

        return new StringRepresentation("requested view:: " + requestedView);
    }

}
