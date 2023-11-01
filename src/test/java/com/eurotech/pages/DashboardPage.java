package com.eurotech.pages;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{
    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;

    @FindBy(id = "dashboard-p1")
    public WebElement welcomeText;

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> dashboardList;
    @FindBy(xpath = "(//tbody)[1]/tr[1]/td[2]") //*[text()='Test Automation Engineer']
    public WebElement jobTitle;
    /** // same locator type with base menu so we can use navigateToMenu()
     public void dashboardMenu(String menuName){
     Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
     }
     */


}
