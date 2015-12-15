package de.as.wants.web.useraccount;

import de.as.wants.sessions.*;
import de.as.wants.web.Cookies;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.restlet.resource.*;

public class LogoutResource extends ServerResource {

    private UserSessionManager sessions = new UserSessionManager();

    public LogoutResource() {
    }

    public LogoutResource(UserSessionManager sessionManager) {
        sessions = sessionManager;
    }

    @Get
    public void logout() {
        String authhoken = getCookies().getValues(Cookies.AUTH_TOKEN);

        if (StringUtils.isNotBlank(authhoken)) {
            UserSession session = sessions.close(UUID.fromString(authhoken));

        }
        getCookies().remove(Cookies.AUTH_TOKEN);
        getResponse().setStatus(org.restlet.data.Status.SUCCESS_OK);
    }

}
