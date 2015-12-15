package de.as.authorization;

public class Doorman {

    public boolean hasUserTheRight(User user, Right right) {
        return user.getRights().contains(right);
    }

}
