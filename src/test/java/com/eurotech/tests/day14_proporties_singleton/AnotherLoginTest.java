package com.eurotech.tests.day14_proporties_singleton;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    /** Class Task
     *  go to url
     *  click login      -> loginBtn.click()
     *  enter email      ->email.sendKeys();
     *  enter password   ->password.sendKeys();
     *  click login button -> submit.click()
     */
    @Test
    public void t2_openBrowserUsingConfigReader() throws InterruptedException {

        //driver.get(ConfigurationReader.get("url"));
        WebElement userEmailInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement userPasswordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);
    }



    @Test
    public void t_singletonReview() throws InterruptedException {
//        WebDriver driver1= WebDriverFactory.getDriver("chrome");// open the chrome
//        WebDriver driver2= WebDriverFactory.getDriver("chrome");// open new (another) chrome

        WebDriver driver1= Driver.get(); // open the chrome
        Thread.sleep(3000);
        WebDriver driver2= Driver.get(); // goes on same chrome

        driver1.get("https://www.google.com/");
        driver2.findElement(By.name("q")).sendKeys("selenium");

    }
}