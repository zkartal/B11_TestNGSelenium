package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        Thread.sleep(1000);

        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("eurotech@gmail.com");

        Thread.sleep(1000);
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys("Test12345!");

        Thread.sleep(1000);

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(1000);
        WebElement experienceCredentials = driver.findElement(By.tagName("h2"));
        System.out.println("experienceCredentials.getText() = " + experienceCredentials.getText());

        // https://the-internet.herokuapp.com/inputs
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement Inputs = driver.findElement(By.tagName("h3"));
        System.out.println("Inputs.getText() = " + Inputs.getText());
        System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());
        driver.close();

//        System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = " + driver.findElement(By.tagName("h3")).getText());
//        System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());

    }
}
