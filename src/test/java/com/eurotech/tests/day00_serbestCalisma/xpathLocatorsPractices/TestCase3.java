package com.eurotech.tests.day00_serbestCalisma.xpathLocatorsPractices;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {

        /*Test case 3
        Go to wikipedia.org (Links to an external site.)
        enter search term selenium webdriver
        click on search button
        click on search result Selenium (software)
        verify url ends with `Selenium_(software)'*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
        inputBox.sendKeys("Selenium Webdriver");

        Thread.sleep(1000);
        WebElement searchIcon = driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
        searchIcon.click();

        String expectedUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PAss");
        }else {
            System.out.println("Fail");
        }

        driver.close();
    }
}
