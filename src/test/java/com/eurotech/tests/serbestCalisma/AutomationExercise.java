package com.eurotech.tests.serbestCalisma;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class AutomationExercise {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://automationexercise.com");

        String expectedUrl = "http://automationexercise.com";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }



    }
}
