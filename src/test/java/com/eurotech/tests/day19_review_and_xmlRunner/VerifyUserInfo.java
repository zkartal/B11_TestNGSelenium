package com.eurotech.tests.day19_review_and_xmlRunner;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /*
 Login as a teacher
 Verify that login is successful
 Click on  Edit Profile button
 Verify that github name is eurotech2023
 Click on go back button
 Verify that user's title is ....../Test Automation Engineer
  */

    @Test
    public void t_userInfo() {
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        ProfilPage profilPage=new ProfilPage();

        extentLogger=report.createTest("User info verification");
        extentLogger.info("Go to "+ ConfigurationReader.get("url") +" website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();
        extentLogger.info("Enter username");
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        extentLogger.info("Enter password");
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Click login button");
        loginPage.submitBtn.click();
        //1. way to verify
        extentLogger.info("Verify that login is successful");
        BrowserUtils.waitForVisibility(dashboardPage.dashboardText,5);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
        //2. way to verify
        String expectedMessage="Welcome Teacher";
        extentLogger.info("Verify that login is successful from Dashboard page and message is " + expectedMessage);
        String actualMessage=dashboardPage.welcomeText.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Click on  Edit Profile button");
        //dashboardPage.dashboardMenu("Edit Profile"); // same locator type with base menu so we can use navigateToMenu()
        dashboardPage.navigateToMenu("Edit Profile");

        String expectedGithubUserName="eurotech2023";
        extentLogger.info("Verify that github name is " + expectedGithubUserName);
        Assert.assertEquals(profilPage.githubusername.getAttribute("value"),expectedGithubUserName);
        extentLogger.info("Click on go back button");
        profilPage.goBackBtn.click();

        String expectedJobTitle="Test Automation Engineer";
        extentLogger.info("Verify that user's title is " + expectedJobTitle);
        Assert.assertEquals(dashboardPage.jobTitle.getText(),expectedJobTitle);
        extentLogger.pass("Test Passed");

    }
}
