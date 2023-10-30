package com.eurotech.tests.day00_serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlertsAndImplicitsWaitExample {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



        
    }

    @AfterMethod
    public void tearDown() {
      // driver.close();
        
    }

    @Test
    public void testNahoverOwerme() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement clickBtn = driver.findElement(By.id("alertButton"));
        clickBtn.click();
        alert  = driver.switchTo().alert();
        alert.accept();

        WebElement click2 = driver.findElement(By.id("timerAlertButton"));
        click2.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();



    }
}
