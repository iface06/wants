package de.as.wants.app.entities;

import de.as.wants.app.entities.users.User;
import java.util.*;

public abstract class Entity {

    private String id;
    private Date createdDate;
    private Date lastModificationDate;
    private User lastModificationByUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public User getLastModificationByUser() {
        return lastModificationByUser;
    }

    public void setLastModificationByUser(User lastModificationByUser) {
        this.lastModificationByUser = lastModificationByUser;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entity other = (Entity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
