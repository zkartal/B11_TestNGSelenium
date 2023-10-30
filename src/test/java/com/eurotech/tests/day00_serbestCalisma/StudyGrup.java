package com.eurotech.tests.day00_serbestCalisma;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class StudyGrup {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");


    }
}
