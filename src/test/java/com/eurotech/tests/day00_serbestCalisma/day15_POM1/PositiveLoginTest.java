package com.eurotech.tests.day00_serbestCalisma.day15_POM1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    
 LoginPage loginPage;
 DashboardPage dashboardPage;
 String email = ConfigurationReader.get("emailTeacher");
 String password = ConfigurationReader.get("passwordTeacher");
    @Test
    public void testName() {

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }
    @Test
    public void t_loginPageTestWithMethod(){

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
        System.out.println("driver.getCurrentUrl().contains(\"dashboard\") = " + driver.getCurrentUrl().contains("dashboard"));

    }
    @Test
    public void t_loginWithMethodWithParameter() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(3000);
        loginPage.login(email,password);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");

    }
    /**  Task 1
     * 1- use loginAsTeacher method
     2-use  loginAsStudent method
     Task 2
     * go to http://eurotech.study/login page
     * login with teacher credentials
     * Get the text of the welcome message and verify following menu
     * Developers
     * All Posts
     * My Account
     */

    @Test
    public void task1() {
    loginPage = new LoginPage();
    dashboardPage = new DashboardPage();
// Task 1
    driver.get(ConfigurationReader.get("url"));
    loginPage.login();
     wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
   //  Assert.assertTrue(dashboardPage.dashboardText.isDisplayed()," Welcome");
    //Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");



    }

    @Test
    public void task2() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
// Task 2
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed()," Welcome");


    }
}
