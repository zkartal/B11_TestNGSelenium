package com.eurotech.tests.day14_proporties_singleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    //    @Test
//    public void testName() {
//        Singleton singleton=new Singleton();
//    }

    // before driver class
    @Test
    public void test1() {
        //Singleton singleton=new Singleton();
        String s1=Singleton.getInstance();
        String s2=Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    //after driver class

    @Test
    public void test2() {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();

        driver.get("https://www.amazon.co.uk/");
        driver.get(ConfigurationReader.get("url"));

    }

    @Test
    public void test3() {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();

        driver.get(ConfigurationReader.get("url"));

    }

    @Test
    public void test4() {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();

        driver.get("https://www.amazon.co.uk/");

    }
}
