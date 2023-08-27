package com.JDBC;

import java.sql.*;

public class Example {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "123.";
        String connectionUrl = "jdbc:mysql://localhost:3306/sweater";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl,userName,password);
             Statement statement = connection.createStatement()) {

            System.out.println("we are connected");
            statement.executeUpdate("drop table Books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id));");
            statement.executeUpdate("insert into Books (name) values ('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon Kane'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Books;");
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id"));
                System.out.print(": ");
                System.out.print(resultSet.getString("name"));
                System.out.println();
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
