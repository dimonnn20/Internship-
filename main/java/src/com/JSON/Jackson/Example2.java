package com.JSON.Jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Example2 {

    public static void main(String[] args) throws IOException {
        List<String> weatherList = new ArrayList<>();
        String data =  request().toString();
        //JsonNode - это один из узлов в древовидной иерархии, от которого идут ветви
        //получаем узел, который называется "list"
        JsonNode arrNode = new ObjectMapper().readTree(data).get("list");
    //если это действительно массив узлов
        if (arrNode.isArray()) {
    //выполняем для каждого узла, который содержится в массиве
            for (final JsonNode objNode : arrNode) {
    //в атрибуте "dt_txt" каждого маленького узла хранилось время прогноза, я отобрал данные за 9 утра и 6 вечера
                String forecastTime = objNode.get("dt_txt").toString();
                if (forecastTime.contains("2023-09-16 09:00:00")) {
                    weatherList.add(objNode.toString());
                }
            }
        }

        System.out.println(weatherList);
    }

    public static StringBuffer request () throws IOException {
        final String API_CALL_TEMPLATE = "https://api.openweathermap.org/data/2.5/forecast?q=";
        final String city = "Minsk";
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
}
