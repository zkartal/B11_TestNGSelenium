package com.eurotech.tests.serbestCalisma.xpathLocatorsPractices;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocatorsPracticesTask2 {

    public static void main(String[] args) throws InterruptedException {
//        /*
//        Task 2
//        Feel free to use any project for automation.
//        Test case 1
//        Go to Ebay
//        enter search term as "java"
//        click on search button
//        print number of results
//
//        Test case 3
//        Go to wikipedia.org (Links to an external site.)
//        enter search term selenium webdriver
//        click on search button
//        click on search result Selenium (software)
//        verify url ends with `Selenium_(software)'*/
//
//       // Test case 1
//
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.get("https://www.ebay.com/");
//        driver.manage().window().maximize();
//
//        WebElement acceptBtn = driver.findElement(By.xpath("//button[text()='Accept All']"));
//        acceptBtn.click();
//
//        WebElement inputBoxBtn = driver.findElement(By.xpath("//input[@type='text']"));
//        inputBoxBtn.sendKeys("Java");
//        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
//        System.out.println(result.getText());
//
//
//        //        Test case 2
//        //        Go to Ebay
//        //        search Selenium
//        //        click on search button
//        //        verify title contains Selenium
//
//        driver.get("https://www.ebay.de/");
//        WebElement searchInputBox = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Bei eBay finden')]"));
//        searchInputBox.sendKeys("Selenium");
//
//        WebElement elementSearch = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
//        elementSearch.click();
//
//        WebElement elementTitle = driver.findElement(By.xpath("(//*[@class='BOLD'])[5]"));
//        String expectedTitle = "Selenium";
//        String actualTitle = elementTitle.getText();
//
//        Thread.sleep(2000);
//
//        /**Test case 3
//         Go to wikipedia.org (Links to an external site.)
//         enter search term selenium webdriver
//         click on search button
//         click on search result Selenium (software)
//         verify url ends with `Selenium_(software)'*/
//
//        driver.get("https://www.wikipedia.org/");
//
//        WebElement searchBtn1 = driver.findElement(By.xpath("//input[contains(@id,'searchInput')]"));
//        searchBtn1.sendKeys("selenium webdriver");
//
//        WebElement search = driver.findElement(By.xpath("(//button/i)[1]"));
//        search.click();
//
//        WebElement elementClick = driver.findElement(By.xpath("//span[text()='Selenium']"));
//        elementClick.click();
//
//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl= "https://de.wikipedia.org/wiki/Selenium";
//
//        if (expectedUrl.equals(actualUrl)){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Fail");
//        }
//
//        Thread.sleep(2000);
//        driver.close();

    }
}
