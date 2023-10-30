package com.eurotech.tests.day00_serbestCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();

     driver.get("http://eurotech.study/");
     Thread.sleep(1000);
        driver.close();

        driver = new ChromeDriver();
        driver.get("https://www.eurotechstudy.com");

        Thread.sleep(1000);
        driver.quit();
    }
}
