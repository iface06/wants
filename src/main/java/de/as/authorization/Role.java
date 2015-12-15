package de.as.authorization;

import java.io.Serializable;

public interface Role<ID extends Serializable & Comparable> {

    public ID getId();

    public String getName();

    public String getDescriptor();

}
