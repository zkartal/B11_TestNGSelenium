package com.eurotech.tests.serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TypeOfWebelements_Class_Task {
    @Test
    public void task() throws InterruptedException {
        /**
         * Class Task
         * go to https://the-internet.herokuapp.com/dynamic_loading/2
         * see Example 2: Element rendered after the fact -->click
         * Then do this task;
         *    verify that hello world is not displayed
         *    click start button
         *    verify that hello element is displayed
         *    and verify that "Hello World!" text is present
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        String expectedTxt = "Hello World!";
        String allTxt = driver.findElement(By.xpath("//body")).getText();
        Assert.assertFalse(allTxt.contains(expectedTxt));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div>button")).click();
        Thread.sleep(5000);
        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertTrue(hello.isDisplayed());
        driver.close();

}
}
