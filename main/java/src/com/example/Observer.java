package com.example;

import java.util.List;

public interface Observer {

    void handleEvent (List <String> vacancies);



    void vacancyAdded(List<String> vacancies);

    void vacancyRemoved(List<String> vacancies);
}
