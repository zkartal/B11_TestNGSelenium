package com.eurotech.tests.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLChanged {
    public static void main(String[] args) throws InterruptedException {



        String email="eurotech@gmail.com";
        String password="Test12345!";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn= driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();
        //lazy way -> click understandBtn
        //driver.findElement(By.id("rcc-confirm-button")).click();
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);
        //driver.findElement(By.id("loginpage-input-email")).sendKeys(email);
        WebElement passwordInputBox = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBox.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();
        Thread.sleep(2000);

        String expectedUrl="http://eurotech.study/dashboard";
        String actualUrl= driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
