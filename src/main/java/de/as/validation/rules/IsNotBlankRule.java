package de.as.validation.rules;

import de.as.validation.*;
import org.apache.commons.lang3.StringUtils;

public class IsNotBlankRule<T> extends ReflectionBasedValidationRule<T> {

    public IsNotBlankRule(String propertyName) {
        super(propertyName);
    }

    @Override
    public Violation<T> validate(T o) {
        String value = getProperty(o);
        if (StringUtils.isBlank(value)) {
            return createViolation(o, ConstraintViolationType.BLANK);
        }
        return null;
    }

}
