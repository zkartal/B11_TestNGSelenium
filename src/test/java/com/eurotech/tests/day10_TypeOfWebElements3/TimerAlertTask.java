package com.eurotech.tests.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimerAlertTask {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
    driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://demoqa.com/alerts");
    wait = new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() {

    }

    @Test
    public void timerAlertBtn() {
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        Assert.assertEquals(alert.getText(),"This alert appeared after 5 seconds");
        alert.accept();


    }
}
