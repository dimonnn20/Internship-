package com.example;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

    public static String allDishesToString () {
        StringBuilder stringBuilder = new StringBuilder();

        Dish[] dish = Dish.values();
        for (Dish d: dish){
            stringBuilder.append(d.toString());
            if (!d.equals(dish[dish.length-1])) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
