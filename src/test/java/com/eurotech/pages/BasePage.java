package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(className = "nav__menu-item")
    public List<WebElement> menuList;
    @FindBy(linkText = "All Posts")
    public WebElement allPosts;
    @FindBy(linkText = "Developers")
    public WebElement developers;
    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    public void navigateToMenu(String menuName){
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }
    public void navigateToSubMenu(String subMenuName){
        BrowserUtils.hover(myAccount);
        Driver.get().findElement(By.xpath("//span[text()='"+subMenuName+"']")).click();
    }
}