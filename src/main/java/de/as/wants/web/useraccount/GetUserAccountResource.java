package de.as.wants.web.useraccount;

import com.google.common.base.Objects;
import de.as.wants.sessions.*;
import de.as.wants.web.Cookies;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.*;
import org.restlet.resource.*;

public class GetUserAccountResource extends ServerResource {

    private UserSessionManager sessions = new UserSessionManager();

    public GetUserAccountResource() {
    }

    public GetUserAccountResource(UserSessionManager sessionManager) {
        sessions = sessionManager;
    }

    @Get
    public Representation getUserAccount() {
        String authhoken = getCookies().getValues(Cookies.AUTH_TOKEN);

        if (StringUtils.isNotBlank(authhoken)) {
            UserSession session = sessions.get(UUID.fromString(authhoken));
            if (!Objects.equal(session, UserSession.EMPTY)) {
                getResponse().setStatus(org.restlet.data.Status.SUCCESS_OK);
                return new JsonRepresentation(session.getUser());
            }
        }

        getResponse().setStatus(org.restlet.data.Status.CLIENT_ERROR_FORBIDDEN);
        return new StringRepresentation("");
    }
}
