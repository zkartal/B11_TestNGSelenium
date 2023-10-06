package com.eurotech.tests.serbestCalisma;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFActory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.eurotechstudy.com");
        Thread.sleep(1000);
        driver.close();

        /**
         * Class Task
         * go to devex website --> https://eurotech.study/
         * expected title = DevEx
         * get title and verify that title is DevEx
         * then close browser
         */

     driver = WebDriverFactory.getDriver("chrome");
     driver.get("http://eurotech.study/");

     String expectedTitel = "DevEx";
     String actualTitel = driver.getTitle();

     if (expectedTitel.equals(actualTitel)){
         System.out.println("Test Passed");
     }else{
         System.out.println("Test Failed");
     }
        Thread.sleep(1000);
     driver.close();
    }
}
