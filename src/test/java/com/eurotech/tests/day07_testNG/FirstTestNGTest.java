package com.eurotech.tests.day07_testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void test1() {

        System.out.println("My first Test Case");


    }

    @Test @Ignore
    public void Btest2() {
        System.out.println("My second Case");
    }

    @Test
    public void atest3() {
        System.out.println("My Third Test Case");
    }
}
