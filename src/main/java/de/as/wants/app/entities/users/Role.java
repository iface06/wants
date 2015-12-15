package de.as.wants.app.entities.users;

import de.as.authorization.Right;
import de.as.wants.app.entities.Entity;
import java.util.List;

public class Role extends Entity {

    private String name;
    private String description;
    private List<Right> rights;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

}
