package de.as.validation;

import org.junit.Test;

public class ValidatorTest {

    @Test
    public void testSomeMethod() {
        ValidationRule v = new ValidationRule() {

            @Override
            public Violation validate(Object o) {
                return new Violation<Object>() {

                    @Override
                    public String getPropertyName() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public Object getOffender() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public ViolationType getType() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
            }
        };
        v.validate(new Object());
    }

}
