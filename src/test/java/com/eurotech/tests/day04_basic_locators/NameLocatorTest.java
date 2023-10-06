package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://eurotech.study/login");

            Thread.sleep(1000);
            //lazy way
            driver.findElement(By.id("rcc-confirm-button")).click();

            WebElement inputEmail = driver.findElement(By.name("email"));
            inputEmail.sendKeys("eurotech@gmail.com");

            Thread.sleep(1000);
            WebElement inputPassword = driver.findElement(By.name("password"));
            inputPassword.sendKeys("Test12345!");

            Thread.sleep(1000);

            //1st way
            WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
            loginBtn.click();

            //2nd way - Lazy way
            //driver.findElement(By.id("loginpage-form-btn")).click();

            Thread.sleep(1000);

           // driver.close();


    }
}
