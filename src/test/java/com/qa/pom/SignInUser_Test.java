package com.qa.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class SignInUser_Test {

    private WebDriver driver;
    private String url;
    SignInUser_Page signInUser_page;

    @Before
    public void setUp() throws InterruptedException {
        url="http://automationpractice.com/index.php";
        signInUser_page = new SignInUser_Page(driver);
        driver = signInUser_page.ChromeDriverConnection();
        signInUser_page.visit(url);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSignInUserPOM() throws InterruptedException {
        signInUser_page.signInUser();
        Thread.sleep(5000);
        assertEquals("Ju DE", signInUser_page.signInUserNameAccount());
    }
}