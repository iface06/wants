package de.as.wants.web.useraccount;

import de.as.wants.app.entities.users.User;
import de.as.wants.app.useraccount.*;
import de.as.wants.sessions.*;
import de.as.wants.web.Cookies;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.restlet.data.CookieSetting;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.*;
import org.restlet.resource.*;

public class LoginResource extends ServerResource {

    private UserSessionManager sessions;
    private LoginInteractor interactor;

    public LoginResource() {
        sessions = new UserSessionManager();
        interactor = new LoginInteractor();
    }

    public LoginResource(UserSessionManager sessions, LoginInteractor interactor) {
        this.sessions = sessions;
        this.interactor = interactor;
    }

    @Get
    public Representation login() {
        UserSession session = getSession();
        if (session == null) {
            return handleLogin();
        } else {
            return new JsonRepresentation(session.getUser());
        }
    }

    protected UserSession getSession() {
        String authhoken = getCookies().getValues(Cookies.AUTH_TOKEN);
        if (StringUtils.isNotBlank(authhoken)) {
            return sessions.get(UUID.fromString(authhoken));
        }
        return null;
    }

    private Representation handleLogin() {
        String emailAddress = getAttribute("emailaddress");
        String password = getAttribute("password");
        UserAccountContext login = new UserAccountContext();
        login.setEmailAddress(emailAddress);
        login.setPassword(password);

        interactor.apply(login);
        if (!Objects.equals(User.EMPTY, login.getUser())) {
            UUID authtoken = UUID.randomUUID();
            CookieSetting cookie = new CookieSetting(0, Cookies.AUTH_TOKEN, authtoken.toString(), "/", null);
            getResponse().getCookieSettings().add(cookie);
            sessions.open(authtoken, login.getUser());
            return new JsonRepresentation(login.getUser());
        } else {
            getResponse().setStatus(org.restlet.data.Status.CLIENT_ERROR_FORBIDDEN);
            return new StringRepresentation("");
        }
    }

}
