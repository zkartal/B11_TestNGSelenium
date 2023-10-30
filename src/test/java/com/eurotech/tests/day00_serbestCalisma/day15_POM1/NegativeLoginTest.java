package com.eurotech.tests.day00_serbestCalisma.day15_POM1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
LoginPage loginPage;

    @Test
    public void t_warningMessage() throws InterruptedException {

        loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        loginPage.userPasswordInput.sendKeys("wrongPassword");
        loginPage.submitBtn.click();

        String actualMessage = loginPage.warningMessage.getText();
        Thread.sleep(2000);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,"Invalid Credentials!");

    }
}

