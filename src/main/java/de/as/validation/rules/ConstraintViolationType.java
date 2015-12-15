package de.as.validation.rules;

import de.as.validation.ViolationType;

public enum ConstraintViolationType implements ViolationType {

    BLANK,
    NON_VALID_EMAIL_ADDRESS,
    AlREADY_EXIST,
    UNSAFE;
}
