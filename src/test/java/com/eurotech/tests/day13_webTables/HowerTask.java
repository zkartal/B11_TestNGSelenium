package com.eurotech.tests.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HowerTask {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        // driver.close();

    }

    @Test
    public void howerUp() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.findElement(By.xpath("(//img)[2]"));
        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println("imgList.size() = " + imgList.size());

        for (int i = 2; i <= imgList.size(); i++) {
        String imgXpath = "(//img) ["+ i +"]";
         System.out.println("imgXpath = " + imgXpath);
         WebElement img = driver.findElement(By.xpath(imgXpath));
         Thread.sleep(2000);
         actions.moveToElement(img).perform();

            String textPath="//h5[text()='name: user"+(i-1)+"']";
            System.out.println("textPath = " + textPath);

            WebElement text=driver.findElement(By.xpath(textPath));

            System.out.println("text.getText() = " + text.getText());

            Assert.assertTrue(text.isDisplayed(),"Verify that user "+(i-1)+" is displayed");

            System.out.println("Verify that user "+(i-1)+" is displayed");


        }


    }

    @Test
    public void digerMetodIle() {

        // Diger yol
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='figure']"));
        for (int i = 0; i < elementList.size(); i++) {
            actions.moveToElement((elementList.get(i))).perform();
            Assert.assertTrue(elementList.get(i).isDisplayed());
        }
    }
}
