package com.sa.tests.login;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;
import com.sa.pages.SucessfullLoginPage;
import com.sa.tests.BaseTest;

public class LoginTests extends BaseTest {
    @Test(groups = { "positive", "regression", "smoke" })
    public void testLoginFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        SucessfullLoginPage sucessfullLoginPage = loginPage.executeLogin("student", "Password123");
        sucessfullLoginPage.load();
        Assert.assertEquals(sucessfullLoginPage.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertTrue(sucessfullLoginPage.getPageSource().contains("Congratulations student. You successfully logged in!"));
        Assert.assertTrue(sucessfullLoginPage.isLogoutButtonDisplayed());
    }

    @Parameters({"username", "password", "expectedErrorMessage"})
    @Test(groups = { "negative", "regression" })
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.executeLogin(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }
}
