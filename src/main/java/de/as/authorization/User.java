package de.as.authorization;

import java.io.Serializable;
import java.util.*;

public interface User<ID extends Serializable & Comparable> {

    public ID getId();

    public List<Role> getRoles();

    public Set<Right> getRights();

}
