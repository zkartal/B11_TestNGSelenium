package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_StartingWith {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Email')]"));
        emailInputBox.sendKeys("eurotech@gmail.com");
            // ends-with does not work with xpath it can be only chrome 0.1 v

        Thread.sleep(2000);
        driver.close();
    }
}
