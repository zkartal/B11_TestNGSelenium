package com.eurotech.tests.serbestCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {

    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
       WebDriver driver = new ChromeDriver();

        driver.get("https://de-de.facebook.com/");

        //getting title with selenium method
        String title = driver.getTitle();
        System.out.println(title);

        String expectedTitel = "Facebook – Anmelden oder Registrieren";
        String actualTitel = driver.getTitle();
        System.out.println("expectedTitel.equals(actualTitel) = " + expectedTitel.equals(actualTitel)); // expectedTitel.equals(actualTitel) = true

        if (expectedTitel.equals(actualTitel)){
            System.out.println("Passed"); // Passed
        }else{
            System.out.println("Failed");
        }

        // get the URL from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl); // currentUrl = https://de-de.facebook.com/

        // get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
