package com.patterns.serviceLocator;

public class InitialContext {
    public Object lookup (String jndiName) {
        if (jndiName.equalsIgnoreCase("service1")) {
            return new Service_1();
        } else if (jndiName.equalsIgnoreCase("service2")) {
            return new Service_2();
        }
        return null;
    }
}
