package com.eurotech.tests.day00_serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day09_TaskSelectTietel {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
       // driver.close();

    }

    @Test
    public void selectTietel() {

        /*        Task 1
        go to https://demoqa.com/select-menu
         locate the "Select Title" web element
         click on it
         click on 'Mrs.'*/

        driver.findElement(By.xpath("//div[text()='Select Title']")).click();
        WebElement selectTietel = driver.findElement(By.xpath("//div[text()='Mrs.']"));
        selectTietel.click();
    }
    @Test
    public void task2() throws InterruptedException {
            /*Task 2
        go to https://demoqa.com/select-menu
         locate the "Select Title" web element
         click on it
        get all options with findElements()*/

        WebElement x = driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[2]"));
        x.click();
        Thread.sleep(4000);

        List<WebElement> elements = driver.findElements(By.xpath("//div[.='Mrs.']/../div"));

        System.out.println("elements.size() = " + elements.size());
        for (WebElement item:elements){
            System.out.println("item.getText() = " + item.getText());
        }


    }

}
