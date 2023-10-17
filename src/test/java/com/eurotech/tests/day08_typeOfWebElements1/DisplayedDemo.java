package com.eurotech.tests.day08_typeOfWebElements1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement hello = driver.findElement(By.xpath("//*[.='Hello World!']")); // ==> //h4[text()='Hello World!']
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());

        Assert.assertFalse(hello.isSelected());

        WebElement startBtn = driver.findElement(By.cssSelector("div>button"));
        startBtn.click();

        Thread.sleep(5000);
        Assert.assertTrue(hello.isDisplayed());

    }
}
