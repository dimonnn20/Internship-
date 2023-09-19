package com.JSON.Jackson;

public enum DayOfWeek {
    MONDAY ("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
