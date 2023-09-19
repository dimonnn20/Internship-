package com.JSON.Jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Example2 {
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("clear sky", "Солнечно");
        map.put("scattered clouds", "Облачно");
        map.put("few clouds", "Мало Облачно");
        map.put("overcast clouds", "Пасмурно");
        map.put("broken clouds", "Пасмурно");


    }

    private final static DateTimeFormatter INPUT_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter OUTPUT_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("EEEE dd MMMM HH:mm", Locale.US);

    public static void main(String[] args) throws Exception {

        weather();


    }

    public static StringBuffer request() throws IOException {
        final String API_CALL_TEMPLATE = "https://api.openweathermap.org/data/2.5/forecast?q=";
        final String city = "Warsaw";
        final String API_KEY_TEMPLATE = "&APPID=658841465c89239aed6eef0c23849bc4";


        String urlString = API_CALL_TEMPLATE + city + API_KEY_TEMPLATE;
        URL urlObject = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new IllegalArgumentException();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response;
    }

    public static void weather() throws Exception {
        String data = request().toString();
        JsonNode arrNode = new ObjectMapper().readTree(data).get("list");
        for (JsonNode node : arrNode) {
            String str = node.get("dt_txt").toString();
            if (str.contains("09:00:00") || str.contains("15:00:00")) {
                String date = node.get("dt_txt").toString().replaceAll("\"", "");
                LocalDateTime localDateTime = LocalDateTime.parse(date, INPUT_DATE_TIME_FORMAT);
                System.out.print(localDateTime.getDayOfMonth() + " ");
                System.out.print(Month.valueOf(localDateTime.getMonth().toString()).getName() + ", ");
                System.out.print(DayOfWeek.valueOf(localDateTime.getDayOfWeek().toString()).getName() + ", ");
                System.out.print("Время " + localDateTime.getHour() + " часов,");


                //System.out.print(localDateTime.format(OUTPUT_DATE_TIME_FORMAT));
                int temperature = (int) Math.round((node.get("main").get("temp").asDouble() - 273.15));
                System.out.print(" Температура: " + temperature + "℃,");
                String description = node.get("weather").get(0).get("description").toString();
                description = description.replaceAll("\"", "");
                System.out.println(" " + map.get(description));
            }
        }

    }


}

