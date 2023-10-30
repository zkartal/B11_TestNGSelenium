package com.eurotech.tests.day00_serbestCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task_01 {

    public static WebDriver getDriverTask(String browserType){
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case"chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case"firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }
        return driver;
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=getDriverTask("chrome");
        driver.get("https://www.linkedin.com/");
        Thread.sleep(3000);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitleLinkedin= "LinkedIn: Einloggen oder anmelde";
        String actualTitleLinkedin= driver.getTitle();
        if (actualTitleLinkedin.equals(expectedTitleLinkedin)){
            System.out.println("passed");
        }else System.out.println("failed");
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(3000);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitleFacebook= "Facebook – Anmelden oder Registriere";
        String actualTitleFacebook= driver.getTitle();
        if (actualTitleFacebook.equals(expectedTitleFacebook)){
            System.out.println("passed");
        }else System.out.println("failed");
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close();
    }
}
