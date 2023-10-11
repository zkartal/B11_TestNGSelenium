package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_With_MultipleAttribute {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //multiple attribute with XPath
        String xpathText = driver.findElement(By.xpath("//p[@class='lead'][@id='loginpage-p1']")).getText();
        System.out.println("xpathText = " + xpathText);

        //multiple attribute with CSS Selector with TagName
        String cssText1 = driver.findElement(By.cssSelector("p[class='lead'][id='loginpage-p1']")).getText();
        System.out.println("cssText1 = " + cssText1);
        //multiple attribute with CSS Selector without TagName
        String cssText2 = driver.findElement(By.cssSelector("[class='lead'][id='loginpage-p1']")).getText();
        System.out.println("cssText2 = " + cssText2);
        Thread.sleep(1000);
        driver.close();

    }
}
