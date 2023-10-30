package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PostsPage extends BasePage{
    @FindBy(id = "post-form-title")
    public WebElement titleInput;
    @FindBy(id = "post-form-textarea")
   public WebElement postInput;
    @FindBy(id = "post-form-btn")
    public WebElement submitBtn;
    @FindBy(xpath = "//div[text()='Post Created']")
    public WebElement postCreatedMessage;


    public void postComment(String titelText, String postText) {
        titleInput.sendKeys(titelText);
        postInput.sendKeys(postText);
        submitBtn.click();
        Assert.assertEquals(postCreatedMessage.getText(),"Post Created");
    }
}
