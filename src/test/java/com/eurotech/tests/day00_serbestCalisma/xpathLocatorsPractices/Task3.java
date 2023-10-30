package com.eurotech.tests.day00_serbestCalisma.xpathLocatorsPractices;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        /*Task 3
/** Class Task
* go to the amazon webpage
* write "selenium" to search box
* verify that the result of the search*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.sendKeys("Selenium");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        searchBtn.click();

        String expectedResult = "1-48 of 323 results for";
        String actualResult = driver.findElement(By.xpath("//*[text()='1-48 of 323 results for']")).getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Pass");
        }else {
            System.out.println("fail");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
