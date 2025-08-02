package com.janitriinnovations.tests;

import com.beust.ah.A;
import com.janitriinnovations.bases.BaseTest;
import com.janitriinnovations.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest{

    // private WebDriver driver;
    private LoginPage loginPage;


    @Test(priority = 0)
    public void testLoginButtonDisabledWhenFieldAreEmpty() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Validation successful: Page title is displayed.");
        Assert.assertTrue(loginPage.isUserIDTextDisplayed(), "Validation successful: User ID text is displayed.");
        Assert.assertTrue(loginPage.isPasswordTextDisplayed(), "Validation successful: Password text is displayed.");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Validation successful: Login button is displayed.");
        loginPage.enterUserId("");
        loginPage.enterPassword("");
        System.out.println("Login button enabled: " + loginPage.isLoginButtonEnabled());
        Assert.assertTrue(!loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test(priority = 1) // This test is disabled as per your request
    public void testPasswordMaskedButton() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Validation successful: Page title is displayed.");
        Assert.assertTrue(loginPage.isUserIDTextDisplayed(), "Validation successful: User ID text is displayed.");
        Assert.assertTrue(loginPage.isPasswordTextDisplayed(), "Validation successful: Password text is displayed.");
        Assert.assertTrue(loginPage.isEyeIconDisplayed(), "Validation successful: Eye icon is displayed.");
        loginPage.enterPassword("dummyPassword123");
        boolean initiallyMasked = loginPage.isPasswordMasked();
        Assert.assertTrue(initiallyMasked, "Password should be masked initially.");
        
        Thread.sleep(5000); // Wait for UI to update
        loginPage.clickPasswordToggle();
        boolean afterToggleMasked = loginPage.isPasswordUnMasked();
        Assert.assertTrue(afterToggleMasked, "Password should be unmasked aftertoggle.");
        Thread.sleep(5000); // Wait for UI to update
    }

    //@Test(enabled = false) // This test is disabled as per your request
    @Test(priority = 2) // This test is disabled as per your request
    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Validation successful: Page title is displayed.");
        Assert.assertTrue(loginPage.isUserIDTextDisplayed(), "Validation successful: User ID text is displayed.");
        Assert.assertTrue(loginPage.isPasswordTextDisplayed(), "Validation successful: Password text is displayed.");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Validation successful: Login button is displayed.");
        Assert.assertTrue(loginPage.isEyeIconDisplayed(), "Validation successful: Eye icon is displayed.");
        
        loginPage.clearFields();
        loginPage.enterUserId("wrong@example.com");
        loginPage.enterPassword("incorrectPass123");
        loginPage.clickLogin();
Thread.sleep(5000); 
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg.toLowerCase().contains("invalid") ,
                " Expected error message for invalid credentials but got: '" + errorMsg + "'");
    }
}













