package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTestTest {
    FizzBuzzTest fizzBuzzTest;
    @Before
    public void setUpAll () {
        fizzBuzzTest = new FizzBuzzTest();
    }
    @Test
    public void kratnoTrem() {
        assertArrayEquals(FizzBuzzTest.FIZZ.getBytes(),fizzBuzzTest.fizzBuzz(3));
    }
    @Test
    public void kratnoFive() {
        assertArrayEquals(FizzBuzzTest.BUZZ.getBytes(),fizzBuzzTest.fizzBuzz(5));
    }
    @Test
    public void kratnoFiveIThree() {
        assertArrayEquals((FizzBuzzTest.FIZZ+FizzBuzzTest.BUZZ).getBytes(),fizzBuzzTest.fizzBuzz(15));
    }
    @Test (expected = IllegalArgumentException.class)
    public void neKratno() throws IllegalArgumentException{
        fizzBuzzTest.fizzBuzz(8);
    }
}