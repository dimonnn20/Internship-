package com.example;

import java.util.List;

public interface Observed {
    void addObserver (Observer observer);
    void removeObserver (Observer observer);
    void vacancyAdded();

    void vacancyRemoved();

}
