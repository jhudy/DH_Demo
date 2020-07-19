package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BuyProduct_Page extends Base {

    By categoryWomenLocator = By.cssSelector("a[title='Women']");
    By productLocator = By.linkText("Faded Short Sleeve T-shirts");
    By addCartButtonLocator = By.cssSelector(".exclusive > span");
    By checkoutButtonLocator = By.xpath("//span[contains(.,'Proceed to checkout')]");
    By proceedCheckoutButtonLocator = By.xpath("(//span[contains(.,'Proceed to checkout')])[2]");
    By agreeCheckBoxLocator = By.xpath("//label[contains(.,'I agree to the terms of service and will adhere to them unconditionally.')]");
    By payByCheckLocator = By.xpath(("//a[@title = 'Pay by check.']"));
    By confirmOrderButtonLocator = By.xpath("//span[contains(.,'I confirm my order')]");
    By orderCompleteLocator = By.xpath("//p[contains(.,'Your order on My Store is complete.')]");

    public BuyProduct_Page(WebDriver driver){
        super(driver);
    }

    public void buyProduct() throws InterruptedException {


        waitElementToBeClickable(categoryWomenLocator);
        click(categoryWomenLocator);
        click(productLocator);
        waitElementToBeClickable(addCartButtonLocator);
        click(addCartButtonLocator);
        waitElementToBeClickable(checkoutButtonLocator);
        click(checkoutButtonLocator);
        waitElementToBeClickable(proceedCheckoutButtonLocator);
        click(proceedCheckoutButtonLocator);
        waitElementToBeClickable(proceedCheckoutButtonLocator);
        click(proceedCheckoutButtonLocator);
        waitElementToBeClickable(agreeCheckBoxLocator);
        click(agreeCheckBoxLocator);
        waitElementToBeClickable(proceedCheckoutButtonLocator);
        click(proceedCheckoutButtonLocator);
        waitElementToBeClickable(payByCheckLocator);
        click(payByCheckLocator);
        waitElementToBeClickable(confirmOrderButtonLocator);
        click(confirmOrderButtonLocator);
    }

    public String orderCompleteMessage(){
        return getText(orderCompleteLocator);
    }

}
