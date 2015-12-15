package de.as.validation;

public interface ValidationRule<T> {

    Violation<T> validate(T o);

}
