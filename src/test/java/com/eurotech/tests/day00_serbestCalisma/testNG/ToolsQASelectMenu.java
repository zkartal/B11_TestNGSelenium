package com.eurotech.tests.day00_serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolsQASelectMenu {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);

    }

    @AfterMethod
    public void tearDown() {
       // driver.close();

    }

    @Test
    public void selectMenuListOfElements() {
        driver.get("https://demoqa.com/select-menu");
        /*        Task 1
        go to https://demoqa.com/select-menu
         locate the "Select Title" web element
         click on it
         click on 'Mrs.'*/
        driver.findElement(By.xpath("//div[.='Select Title']")).click();
        driver.findElement(By.xpath("//div[text()='Mrs.']")).click();


    }
}
