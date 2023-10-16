package com.logopak;

import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        String serverAddress = "192.168.1.3";
        int serverPort = 9100; // Замените на порт, на котором слушает сервер

        try {
            // Создаем сокет для подключения к серверу
            Socket socket = new Socket(serverAddress, serverPort);

            // Получаем поток вывода из сокета
            OutputStream outputStream = socket.getOutputStream();

            // Отправляем данные на сервер
            String requestData = "FD,1,19071991\n" +
                    "FD,2,Dzmitry\n"+"FD,3,Makarau\n";
            byte[] data = requestData.getBytes("UTF-8");
            outputStream.write(data);

            // Закрываем потоки и сокет
            outputStream.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
