package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignInUser_Page extends Base {

    By signInLinkLocator = By.className("login");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("passwd");
    By signInButtonLocator = By.id("SubmitLogin");
    By signInPageLocator = By.xpath("//h1[@class='page-heading'][contains(.,'Authentication')]");
    By accountLocator = By.cssSelector(".account > span");


    public SignInUser_Page(WebDriver driver){
        super(driver);
    }

    public void signInUser(String userName, String password) throws InterruptedException {
        click(signInLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(signInPageLocator)){
          type(userName,emailLocator);
          type(password,passwordLocator);
          click(signInButtonLocator);
        } else {
            System.out.println("SignIn Page was not found");
        }
    }

    public String signInUserNameAccount(){
        return getText(accountLocator);
    }



}
