package com.date.LocalDate.NameOfWeekdayInItalian;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Example {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        //String formatedDate = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDate = localDate.format(dateTimeFormatter);
        System.out.println(formatedDate);
    }

}
