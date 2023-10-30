package com.eurotech.tests.day00_serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlerts {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
      //  driver.close();
    }
    @Test
    public void task1() throws InterruptedException {

        /** HOMEWORK TASK 1
         * For the above test
         * Verify all results are as expected for the JavaScript alerts
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(1000);
        //click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);
        WebElement resultAlert = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        Assert.assertEquals(resultAlert.getText(),"You successfully clicked an alert");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);

        alert.dismiss();
        Thread.sleep(1000);
        WebElement resultConfrim = driver.findElement(By.id("result"));
        Assert.assertEquals(resultConfrim.getText(),"You clicked: Cancel");

        Thread.sleep(1000);
        WebElement jsPromt = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
        jsPromt.click();

        alert.sendKeys("successful");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='You entered: successful']")).getText(),"You entered: successful");

        Thread.sleep(1000);

    }

    @Test
    public void task2() throws InterruptedException {

        /** HOMEWORK TASK 2
         * Go to https://demoqa.com/alerts
         * Practice with all JavaScript Alerts
         * Verify all results are as expected for the JavaScript alerts
         */

        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("[class='mr-3']"));
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
        alert.dismiss();
        String actualResult = driver.findElement(By.id("confirmResult")).getText();
        String expeectedResult = "You selected Cancel";
        Assert.assertEquals(actualResult,expeectedResult);
        Thread.sleep(1000);

        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(7000);
        alert.accept();



    }
}
