package com.eurotech.tests.day07_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
    @BeforeMethod
    public void SetUpMethod(){
        System.out.println("Open Browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
    @Test
    public void test1(){
        System.out.println("Test Annotations");
        Assert.assertEquals("Titel","Titel");
        System.out.println("second asertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {
        System.out.println("test2");
        Assert.assertEquals("test2","test2");
    }
    @Test

    public void test3(){
        String expectedTitel = "Eurotech";
        String actualTitel = "Eurotech";
        Assert.assertTrue(actualTitel.startsWith(expectedTitel));
        //Assert.assertTrue(actualTitel.contains(expectedTitel));

    }
    @Test

    public void test4() {
        // verify that email contains"@"
        String email = "eurotech@gmail.com";

//        if (email.contains("@")){
//            System.out.println("Pass");
//    }else{
//            System.out.println("failed");
//        }
        Assert.assertTrue(email.contains("@"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(1>0,"verify is grater than 0");
    }

    @Test
    public void test6() {
        Assert.assertNotEquals("1","one");
    }
}
