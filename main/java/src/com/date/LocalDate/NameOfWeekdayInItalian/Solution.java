package com.date.LocalDate.NameOfWeekdayInItalian;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

    public class Solution {
        public static void main(String[] args) {
            System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
            System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
        }

        public static String getWeekdayOfBirthday(String birthday, String year) {

            String [] str = birthday.split("\\.");
            DateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.ITALY);
            Calendar calendar = new GregorianCalendar(Integer.valueOf(year),Integer.valueOf(str[1])-1,Integer.valueOf(str[0]));
            return dateFormat.format(calendar.getTime());
            //=====================================================================
//        DateTimeFormatter birthdayDateFormat = DateTimeFormatter.ofPattern("d.M.y");
//        LocalDate birthdayDate = LocalDate.parse(birthday, birthdayDateFormat);
//
//        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("y");
//        Year yearDate = Year.parse(year, yearFormat);
//
//        return birthdayDate.withYear(yearDate.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));


        }
    }
