package com.JSON.Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertThat;

public class Example {
    public static void main(String[] args) throws JsonProcessingException {

        Employee employee = new Employee("Mark", "James", 20);

        System.out.println(savePOJO(employee));
        System.out.println(getPOJO().toString());

    }

    public static String savePOJO (Employee employee) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employee);
        return json;
    }

    public static Employee getPOJO () throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
            String employeeJson = "{\n" +
                    " \"firstName\" : \"Jalil\",\n" +
                    " \"lastName\" : \"Jarjanazy\",\n" +
                    " \"age\" : 30\n" +
                    "}";

            Employee employee = objectMapper.readValue(employeeJson, Employee.class);

        return employee;

    }
}

