package de.as.validation.rules;

import de.as.reflection.Reflactor;
import de.as.validation.*;

public abstract class ReflectionBasedValidationRule<T> implements ValidationRule<T> {

    private String propertyName;
    private ViolationBuilder violationBuilder = new ConstrainViolationBuilder();

    public ReflectionBasedValidationRule(String propertyName) {
        this.propertyName = propertyName;
    }

    protected String getProperty(T o) {
        return new Reflactor().getProperty(o, propertyName);
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public abstract Violation<T> validate(T o);

    protected Violation<T> createViolation(T o, ViolationType type) {
        return violationBuilder.build(o, getPropertyName(), type);
    }

}
