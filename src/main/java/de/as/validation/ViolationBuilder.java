package de.as.validation;

public interface ViolationBuilder<T> {

    public Violation<T> build(T o, String propertyName, ViolationType type);

}
