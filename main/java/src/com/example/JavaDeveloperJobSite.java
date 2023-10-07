package com.example;

import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed {
    private List<String> vacancies = new ArrayList<>();
    private List <Observer> subscribers = new ArrayList<>();

    public void addVacancy (String vacancy){
        vacancies.add(vacancy);
        vacancyAdded();
    }

    public void removeVacancy (String vacancy){
        vacancies.remove(vacancy);
        vacancyRemoved();
    }


    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void vacancyAdded() {
        for (Observer observer: subscribers){
            observer.vacancyAdded(vacancies);
        }
    }

    @Override
    public void vacancyRemoved() {
        for (Observer observer: subscribers){
            observer.vacancyRemoved(vacancies);
        }
    }
}
