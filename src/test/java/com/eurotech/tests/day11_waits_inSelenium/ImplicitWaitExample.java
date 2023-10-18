package com.eurotech.tests.day11_waits_inSelenium;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);
      //  driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.close();

    }

    @Test
    public void implicitWait() {
        driver.findElement(By.cssSelector("#checkbox-example>button")).click();
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");
    }

    @Test
    public void explicitWaitTest1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();
       // WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(hello));
        Assert.assertEquals(hello.getText(),"Hello World!");


    }

    @Test
    public void explicitWaitTest2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("[type='text']"));

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("zafer");

        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's enabled!");

    }
}
