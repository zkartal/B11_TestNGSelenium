package com.eurotech.tests.day02_webDriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://eurotech.study/");


        Thread.sleep(1000);

        driver.close(); //closes current tab -  geçerli tabı kapatır

        driver=new ChromeDriver();

        driver.get("https://www.eurotechstudy.com");

        Thread.sleep(1000);

        driver.quit(); // closes all tabs - bütün tabları kapatır

    }
}
