package com.eurotech.tests.day07_testNG;

import org.testng.annotations.*;

public class Before_AfterMethods {

    @Test (priority = 1)
    public void test1() {
        System.out.println("WebDriver, Opening Browser");
        System.out.println("First Test Case");
        System.out.println("Closing Browser, Quit");

    }

    @BeforeMethod
    public void setUp() {
        System.out.println("**** Before Method ****");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("**** After Method ****");
        System.out.println("Closing Browser, Quit");
    }

    @Test @Ignore
    public void test2() {
        System.out.println("Second Test Case");
    }

    @Test (priority = 2)
    public void test3() {
        System.out.println("Third Test Case");
    }
@BeforeClass
    public void setUpClass(){
    System.out.println("*******  Before Class ********");
}
@AfterClass
    public void tearDownClass(){
    System.out.println("********* After Class ********");
}
}
