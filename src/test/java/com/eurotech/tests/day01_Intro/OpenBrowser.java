package com.eurotech.tests.day01_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // Chrome setup ediyoruz
        // ChromeDriver() da obj olusturuyoruz
        // driver.get("")e link ekleyip siteye gidiyoruz
        WebDriverManager.chromedriver().setup();
        // new ChromeDriver().get("http://eurotech.study/"); --> alternatif driver obj olusturma
        WebDriver driver = new ChromeDriver();// polymorphsym
        driver.get("http://eurotech.study/");
        /*  Firefox ile de setup edebiliriz
       WebDriverManager.firefoxdriver().setup();
          WebDriver driver1 = new FirefoxDriver();
          driver1.get("http://eurotech.study/");

         */

    }
}
