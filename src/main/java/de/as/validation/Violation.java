package de.as.validation;

public interface Violation<T> {

    String getPropertyName();
    T getOffender();
    ViolationType getType();

}
