package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_Contains {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Address')]"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        Thread.sleep(1000);
        driver.close();
    }
}
