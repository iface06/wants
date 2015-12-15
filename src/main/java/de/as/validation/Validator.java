package de.as.validation;

import java.util.*;

public class Validator {

    private List<ValidationRule> rules = new ArrayList<>();

    public Validator addValidationRule(ValidationRule rule) {
        rules.add(rule);
        return this;
    }

    public List<Violation> validate(Object o) {
        List<Violation> violations = new ArrayList<>();
        for (ValidationRule rule : rules) {
            Violation v = rule.validate(o);
            violations.add(v);
        }

        return violations;
    }

}
