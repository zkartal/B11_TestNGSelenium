package com.eurotech.tests.day00_serbestCalisma.testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTestTask1 {
    WebDriver driver;

    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.close();
    }

    @Test
    public void hoverOver() {
//
//        WebElement img1= driver.findElement(By.xpath("(//img)[2]"));
//
//        //Actions actions = new Actions(driver);
//        actions.moveToElement(img1).perform();
//
//        WebElement viewProfile1= driver.findElement(By.linkText("View profile"));
//        System.out.println("viewProfile1.getText() = " + viewProfile1.getText());
//        Assert.assertTrue(viewProfile1.isDisplayed(),"verify that view profile text is displayed");

        /**  Hover class Task
         *      go to https://the-internet.herokuapp.com/hovers url
         *      and get "view profile" elements' text (all of them)
         *      and verify element is displayed (one by one)
         *
         *      hint: Use list and for loop
         */
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> elements = driver.findElements(By.cssSelector("[class='figure']"));
        for (int i = 0; i < elements.size(); i++) {
            actions.moveToElement(elements.get(i)).perform();
            Assert.assertTrue(elements.get(i).isDisplayed());
        }
        System.out.println("elements.size() = " + elements.size());
    }
}
