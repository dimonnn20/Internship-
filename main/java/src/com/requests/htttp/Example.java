package com.requests.htttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Example {

    public static void main(String[] args) throws IOException {
        final String API_CALL_TEMPLATE = "https://api.openweathermap.org/data/2.5/forecast?q=";
        final String city = "Minsk";
        final String API_KEY_TEMPLATE = "&APPID=658841465c89239aed6eef0c23849bc4";

//создаём строку со ссылкой на нужную страницу,
//я тут её склеиваю из заранее определённых констант, меняя только сам город
// пример запроса https://api.openweathermap.org/data/2.5/forecast?q=(город)&APPID=(уникальный токен, полученный при регистрации)

        String urlString = API_CALL_TEMPLATE + city + API_KEY_TEMPLATE;
//создаём объект который будет содержать ссылку
        URL urlObject = new URL(urlString);
//создаём соединение, используя объект
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
//выбираем тип запроса (GET)
        connection.setRequestMethod("GET");
//тут мы указываем, данные о себе, что мы можем принять всё то,
//что примет и любой современный браузер
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
//В начало ответа сервер всегда вставляет число, по которому можно судить, прошло ли всё хорошо.
//200 - значит OK
        int responseCode = connection.getResponseCode();
//на несуществующий город или город с опечаткой, сервер выдаст код ответа 404,
//бросаем на него исключение, чтобы обработать на уровне повыше и предложить
//пользователю ввести город заново
        if (responseCode == 404) {
            throw new IllegalArgumentException();
        }
// создаём поток, вычитываем все строки, и склеиваем в одну большую строку,
//которую будем потом обрабатывать в других методах
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(responseCode);
        System.out.println(response);

    }
}
