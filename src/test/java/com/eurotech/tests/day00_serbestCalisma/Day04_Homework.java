package com.eurotech.tests.day00_serbestCalisma;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day04_Homework {
    public static void main(String[] args) throws InterruptedException {

/** Class Task
 *  go to the url -  "https://www.browserstack.com/users/sign_up"
 *  maximize the window --> driver.manage().window().maximize();
 *  accept cookies if any,
 *  fill in the blanks with the faker class
 *  click "Term of service" checkbox
 *  and close the window
 *
 *  hint: u can use any locator you want
 *
 */
        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");

        driver.manage().window().maximize();

        WebElement acceptBtn = driver.findElement(By.id("accept-cookie-notification"));
        acceptBtn.click();
        Thread.sleep(1000);

        WebElement fullNameBtn = driver.findElement(By.id("user_full_name"));
        fullNameBtn.sendKeys(faker.name().fullName());
        Thread.sleep(1000);

        WebElement emailBtn = driver.findElement(By.id("user_email_login"));
        emailBtn.sendKeys(faker.internet().emailAddress());
        Thread.sleep(1000);

        WebElement passwordBtn = driver.findElement(By.id("user_password"));
        passwordBtn.sendKeys(faker.internet().password());
        Thread.sleep(2000);

        WebElement checkBoxBtn = driver.findElement(By.id("tnc_checkbox_link_terms_sso"));
        checkBoxBtn.click();

        Thread.sleep(1000);
        driver.quit();


    }
}
