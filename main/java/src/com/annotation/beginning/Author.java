package com.annotation.beginning;

public @interface Author {
    String value();

    Position position() default Position.OTHER;
}
