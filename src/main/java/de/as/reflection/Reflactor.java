package de.as.reflection;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

public class Reflactor {

    public String getProperty(Object o, String propertyName) {
        try {
            return BeanUtils.getProperty(o, propertyName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
