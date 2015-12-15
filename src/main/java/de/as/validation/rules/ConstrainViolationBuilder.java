package de.as.validation.rules;

import de.as.validation.*;

public class ConstrainViolationBuilder<T> implements ViolationBuilder<T> {

    @Override
    public Violation<T> build(T o, String propertyName, ViolationType type) {
        return new ConstraintViolation<>(o, propertyName, type);
    }

}
