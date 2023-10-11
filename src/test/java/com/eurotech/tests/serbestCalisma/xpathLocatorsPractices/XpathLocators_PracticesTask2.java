package com.eurotech.tests.serbestCalisma.xpathLocatorsPractices;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocators_PracticesTask2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement acceptBtn = driver.findElement(By.xpath("//button[text()='Accept All']"));
        acceptBtn.click();
        Thread.sleep(3000);

        WebElement inputBtn = driver.findElement(By.xpath("//input[@type='text']"));
        inputBtn.sendKeys("java");

        Thread.sleep(3000);
        WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        searchBtn.click();
        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println(result.getText());

        driver.close();

    }
}
