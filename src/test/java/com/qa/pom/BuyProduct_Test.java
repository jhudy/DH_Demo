package com.qa.pom;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class BuyProduct_Test {

    private WebDriver driver;
    private String url;

    BuyProduct_Page buyProduct_page;

    @Before
    public void setUp() throws InterruptedException {
        url="http://automationpractice.com/index.php";
        buyProduct_page = new BuyProduct_Page(driver);
        driver = buyProduct_page.ChromeDriverConnection();
        driver.manage().window().maximize();
        buyProduct_page.visit(url);
        buyProduct_page.signInMyStore();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulPurchase()throws InterruptedException{
        buyProduct_page.buyProduct();
        assertEquals("Your order on My Store is complete.",buyProduct_page.orderCompleteMessage());
    }

}
