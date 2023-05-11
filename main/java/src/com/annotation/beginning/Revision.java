package com.annotation.beginning;

public @interface Revision {
    int revision();

    Date date();

    Author[] authors() default {};

    String comment() default "";
}
