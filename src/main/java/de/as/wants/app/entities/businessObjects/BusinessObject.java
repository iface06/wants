package de.as.wants.app.entities.businessObjects;

import de.as.wants.app.entities.Entity;
import de.as.wants.app.entities.users.User;

public abstract class BusinessObject extends Entity {

    private User fromUser;
    private User toUser;
    private String description;

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
