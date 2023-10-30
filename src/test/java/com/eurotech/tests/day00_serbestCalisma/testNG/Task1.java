package com.eurotech.tests.day00_serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @AfterMethod
    public void tearDown() {
      //  driver.close();
    }

    @Test
    public void test1() {


    }
}
