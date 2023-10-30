package com.eurotech.tests.day00_serbestCalisma.xpathLocatorsPractices;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocatorsPractices_Task1 {

    public static void main(String[] args) throws InterruptedException {

        /*
        Task-1
    Locator XPATH PRACTICES
    DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    1. Open Chrome browser
    2. Go to
    (https://the-internet.herokuapp.com/forgot_password) Links to an external site.
    3. Locate all the WebElements on the page using XPATH locator only
    a. “Forgot password” header
    b. “E-mail” text
    c. E-mail input box
    d. “Retrieve password” button
    4.Print text of a,b,d and put some email to c.

         */

        Faker faker = new Faker();

        // xPath Text bulma yöntemi : //*[.='Forgot Password']
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        // headerText --->  //*[.='Forgot Password']
        WebElement headerTextElement = driver.findElement(By.xpath("//*[.='Forgot Password']"));
        System.out.println("headerTextElement.getText() = " + headerTextElement.getText()); // headerTextElement.getText() = Forgot Password

        //xPath Text bulma yöntemi : emailTextElement------> //label[@for='email']
        WebElement emailTextElement = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println("emailTextElement.getText() = " + emailTextElement.getText()); // emailTextElement.getText() = E-mail

        WebElement emailInputBox = driver.findElement(By.xpath("//form/div/div/input"));
        emailInputBox.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
        WebElement passwordBtn = driver.findElement(By.xpath("//i[contains(text(),'Retrieve password')]"));
        System.out.println("passwordBtn.getText() = " + passwordBtn.getText()); // passwordBtn.getText() = Retrieve password
        passwordBtn.click();



        Thread.sleep(1000);
        driver.close();

    }
}
