package com.sa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SucessfullLoginPage extends BasePage {
    private By logoutButtonLocator = By.linkText("Log out");

    public SucessfullLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDiplayed(logoutButtonLocator);
    }

    public void load() {
        waitForElement(logoutButtonLocator);
    }
}
