package com.eurotech.tests.day02_webDriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        //Task open chrome and navigate to https://www.eurotechstudy.com
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
       // driver.get("https://www.eurotechstudy.com");

        driver.get("https://de-de.facebook.com/");

        //getting title with selenium method
        String title = driver.getTitle();
        System.out.println("title = " + title); //Facebook – Anmelden oder Registrieren

        String expectedTitle = "Facebook – Anmelden oder Registrieren";
        String actualTitel = driver.getTitle();
        System.out.println("expectedTitle.equals(actualTitel) = " + expectedTitle.equals(actualTitel)); // expectedTitle.equals(actualTitel) = true

        if (expectedTitle.equals(actualTitel)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        // get the URL from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl); // currentUrl = https://de-de.facebook.com/

        // get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
