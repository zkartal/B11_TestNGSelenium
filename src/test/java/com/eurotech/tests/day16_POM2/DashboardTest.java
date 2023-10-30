package com.eurotech.tests.day16_POM2;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
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
public class DashboardTest extends TestBase {
    /**  Task

     * go to http://eurotech.study/login page
     * login with teacher credentials
     * Get the text of the welcome message and verify following menu
     * Developers
     * All Posts
     * My Account
     */

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();

    @Test
    public void dashboardMenu() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher");

        ArrayList<String> expectedList= new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        //1st way
        ArrayList<String> actualList= new ArrayList<>();
        List<WebElement> dashboardMenu= dashboardPage.menuList;
        for (WebElement menu : dashboardMenu) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(actualList,expectedList);

        //2nd way
        List<String> actualList1= BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList1,expectedList);

        //3rd way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList),expectedList);

    }

    @Test
    public void navigateMenu() {
        /** Class Task - Duration is 10min
         *  Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Navigate to All Posts menu and verify url is http://eurotech.study/posts
         *  Navigate to Developers menu and verify url is http://eurotech.study/profiles
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher");
        dashboardPage.allPosts.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");
        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
    }

    @Test
    public void navigateMenu2() {
        /** Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Navigate to All Posts menu and verify url is http://eurotech.study/posts
         *  Navigate to Developers menu and verify url is http://eurotech.study/profiles  */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher");
        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");
        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
    }
    public void navigateToSubMenu(String subMenuName){
        Driver.get().findElement(By.xpath("//span[text()='"+subMenuName+"']")).click();
    }
    @Test
    public void navigateMenu3() throws InterruptedException { // Navigate to Sub Menu
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeText.getText(),"Welcome Teacher");
        dashboardPage.navigateToSubMenu("My Posts");
        dashboardPage.navigateToSubMenu("Logout");
    }
}
