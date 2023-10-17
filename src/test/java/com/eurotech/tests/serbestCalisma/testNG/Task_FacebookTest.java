package com.eurotech.tests.serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_FacebookTest {

     /*
    -open chrome browser
    -go to https://www.facebook.com/
    -enter fake username
    -enter fake password
    -click login button
    -verify not that login successfully
     */
    WebDriver driver;
Faker faker = new Faker();
    @BeforeMethod
    public void setUp() {
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void FAcebookTest() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("[data-cookiebanner='accept_button']")).click();
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(faker.internet().emailAddress());
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys(faker.internet().password());
        WebElement clickBtn = driver.findElement(By.cssSelector("[name=\"login\"]"));
        clickBtn.click();

        String expectedMessage = "Facebook'a Giriş Yap";
        String actualMessage = driver.findElement(By.className("_9axz")).getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage,"Facebook'a Giriş Yap"); // actualMessage = Facebook'a Giriş Yap


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
