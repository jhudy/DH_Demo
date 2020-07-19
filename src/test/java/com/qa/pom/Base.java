package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;

    By signInLinkLocator = By.className("login");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("passwd");
    By signInButtonLocator = By.id("SubmitLogin");
    By signInPageLocator = By.xpath("//h1[@class='page-heading'][contains(.,'Authentication')]");
    By accountLocator = By.cssSelector(".account > span");


    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver ChromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    public void signInMyStore() throws InterruptedException {
        click(signInLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(signInPageLocator)){
            type("jhu.de.ro@gmial.com",emailLocator);
            type("12345J",passwordLocator);

            click(signInButtonLocator);
        } else {
            System.out.println("SignIn Page was not found");
        }
    }
}
