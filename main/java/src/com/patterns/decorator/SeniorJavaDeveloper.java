package com.patterns.decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator{

    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }
    public String makeCodeReview () {
        return "Senior is making code rewiew";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}
