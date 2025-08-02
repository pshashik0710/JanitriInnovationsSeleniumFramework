package com.janitriinnovations.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    
    @FindBy(id = "formEmail")
    private WebElement userIdInput;

    @FindBy(id = "formPassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='login-button']")
    private WebElement loginButton;

    @FindBy(css = "img.passowrd-visible")
    private WebElement passwordToggleEye;

    @FindBy(css = ".invalid-credential-div")
    private WebElement errorMessage;

    @FindBy(css = "img.login-janitri-logo")
    private WebElement pageTitle;

    // Actions
    public void enterUserId(String userId) {
        userIdInput.clear();
        userIdInput.sendKeys(userId);
    }



    public void enterPassword(String pwd) {
        passwordInput.isDisplayed();
        passwordInput.clear();
        passwordInput.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickPasswordToggle() {
        passwordToggleEye.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isPasswordMasked() {
        return passwordInput.getAttribute("type").equals("password");
    }

    public boolean isPasswordUnMasked() {
        return passwordInput.getAttribute("type").equals("text");
    }

    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".invalid-credential-div")
            ));
            return errorMessage.getText();
        } catch (TimeoutException e) {
            return ""; // return empty if not visible within timeout
        }
    }

    public void clearFields() {
        userIdInput.clear();
        passwordInput.clear();
    }

    // Testing utilities (not recommended in PageObject but shown as per your structure)
    public boolean testLoginButtonDisabledWhenFieldAreEmpty() {
        clearFields();
        return !isLoginButtonEnabled();
    }

    public boolean testPasswordMaskedbutton() {
        enterPassword("samplePWD");
        boolean masked = isPasswordMasked();
        clickPasswordToggle();
        boolean unmasked = !isPasswordMasked();
        return masked && unmasked;
    }

    public String testInvalidLoginShowErrorMsg() {
        enterUserId("randomUser");
        enterPassword("randomPass");
        clickLogin();
        return getErrorMessage();
    }

    public boolean isPageTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    public boolean isUserIDTextDisplayed() {
       return pageTitle.isDisplayed();
    }

    public boolean isPasswordTextDisplayed() {
        return passwordInput.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean isEyeIconDisplayed() {
        return passwordToggleEye.isDisplayed();
    }

    public boolean isTitleDisplayed() {
        return pageTitle.isDisplayed();
    }
}




