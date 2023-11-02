package com.eurotech.tests.day20_DDF_dataProvieder;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {
@DataProvider
    public Object[][] userData(){
    ExcelUtil testData= new ExcelUtil("src/test/resources/Batch11_DevEx.xlsx","Test Data");
    return testData.getDataArrayWithoutFirstRow();

}

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username,String password,String title,String company,String name) {
    // we added from Excel File as parameters to the method

        LoginPage loginPage= new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger = report.createTest(name + "'s Login Test");
        extentLogger.info("Click understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter username");
        loginPage.userEmailInput.sendKeys(username);
        extentLogger.info("Enter password");
        loginPage.userPasswordInput.sendKeys(password);
        extentLogger.info("Click Login Button");
        loginPage.submitBtn.click();


        String expectedMessage= "Welcome "+name;
        extentLogger.info("Verify that welcome message is "+expectedMessage);
        Assert.assertEquals(dashboardPage.welcomeText.getText(),expectedMessage);

        extentLogger.info("Verify that title is "+title);
        //Assert.assertEquals(dashboardPage.getTitle(title),title);
        Assert.assertEquals(dashboardPage.getTextCommon(title),title);

        extentLogger.info("Verify that "+name+" is working in "+company);
        //Assert.assertEquals(dashboardPage.getCompany(company),company);
        Assert.assertEquals(dashboardPage.getTextCommon(company),company);

        extentLogger.pass("Test Passed");


    }
}
