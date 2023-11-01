package com.eurotech.tests.day18_extentReports_screenshot;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    // Positive Test with login methods and take report
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void t_Login1() throws InterruptedException {
        extentLogger= report.createTest("Positive Login Test");

        extentLogger.info(" Go to" + ConfigurationReader.get("url") + "Web Seite");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("login With " + ConfigurationReader.get("emailTeacher") +"credentials");
        loginPage.login();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher");

        extentLogger.pass("Test passed");

    }

    @Test
    public void t_Login2() {
        extentLogger= report.createTest("Positive Login Test");

        extentLogger.info(" Go to" + ConfigurationReader.get("url") + "Web Seite");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("login With " + ConfigurationReader.get("emailTeacher") +"credentials");
        loginPage.login();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher");

        extentLogger.pass("Test passed");
    }
}
