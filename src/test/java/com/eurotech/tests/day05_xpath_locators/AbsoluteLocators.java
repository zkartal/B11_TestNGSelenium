package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteLocators {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

       //WebElement emailInputBox = driver.findElement(By.xpath("/html/body/div/section/form/div[1]/input"))



    }
}
