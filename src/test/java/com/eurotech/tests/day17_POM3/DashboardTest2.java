package com.eurotech.tests.day17_POM3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.PostsPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase  {
    /** Class Task - Duration: 10min
     go to "http://eurotech.study/login"
     Login with teacher credentials
     Verify login is successful
     Verify following menu
     - Edit Profile
     - Add Experience
     - Add Education
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    PostsPage postsPage = new PostsPage();
    @Test
    public void verifyList() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher","login verification is failed");
        ArrayList<String> expectedList= new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");
//1 way
        List<String> actualList= new ArrayList<>();

//        for (WebElement listItem : dashboardPage.dashboardList) {
//            actualList.add(listItem.getText());
//        }
//        System.out.println("expectedList = " + expectedList);
//        System.out.println("actualList = " + actualList);
//        Assert.assertEquals(actualList,expectedList,"Verification of dasboard list is FAILED");

        // 2 way
//        List<WebElement> dashboardList = dashboardPage.dashboardList;
//        for (WebElement listItem : dashboardList) {
//            actualList.add(listItem.getText());
//        }
//        Assert.assertEquals(actualList,expectedList,"Verification of dashboard list is failed");

        // 3. way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.dashboardList),expectedList);
    }

    @Test
    public void logout() {
        /** Class Task - Duration: 15min
         go to "http://eurotech.study/login"
         Login with teacher credentials
         Verify login is successful
         Navigate to My Account and My Posts and verify that submit button is visible
         Navigate to Log Out  and verify that logout successful
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher","login verification is failed");
        dashboardPage.navigateToSubMenu("My Posts");
        postsPage.navigateToSubMenu("My Posts");

        // 1st way of verifing Submit button is visible/displayed
        Assert.assertTrue(postsPage.submitBtn.isDisplayed());

        // 2st way of verifing Submit button is visible/displayed
        BrowserUtils.verifyElementDisplayed(postsPage.submitBtn);

       // 3st way of verifing get attributte
        Assert.assertEquals(postsPage.submitBtn.getAttribute("value"),"Submit");
        System.out.println("postsPage.submitBtn.getAttribute(\"value\") = " + postsPage.submitBtn.getAttribute("value"));

        //logout
        postsPage.navigateToSubMenu("Logout");

        // verifiy logout

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));


    }

    @Test
    public void postComment() {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher","login verification is failed");
        dashboardPage.navigateToSubMenu("My Posts");

        String titelText = "page Object Model";
        String postText = "We love Automation";

//        postsPage.titleInput.sendKeys(titelText);
//        postsPage.postInput.sendKeys(postText);
//        postsPage.submitBtn.click();
//        Assert.assertEquals(postsPage.postCreatedMessage.getText(),"Post Created");

        postsPage.postComment(titelText,postText);
        BrowserUtils.waitFor(3);

    }
}
