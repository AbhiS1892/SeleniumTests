package com.sa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class LoginPage extends BasePage {
    private By usernameInputLocator = By.id("username");
    private By passwordInputLocator = By.id("password");
    private By submitButtonLocator = By.id("submit");
    private By errorMessageLocator = By.id("error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }

    public void enterUsername(String username) {
        File ss = driver.findElement(usernameInputLocator).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(ss, new File("D:/logo_element.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public SucessfullLoginPage executeLogin(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.clickSubmitButton();
        return new SucessfullLoginPage(driver);
    }

    public String getErrorMessage() {
        WebElement errorMessageElement = waitForElement(errorMessageLocator);
        return errorMessageElement.getText();
    }
}
