package com.sa.tests.exceptions;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sa.pages.ExceptionPage;
import com.sa.tests.BaseTest;

public class ExceptionTests extends BaseTest {
    @Test
    public void noSuchElementExceptionTest() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.clickAddButton();
        Assert.assertTrue(exceptionPage.isRowTwoDiplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.clickAddButton();
        Assert.assertTrue(exceptionPage.isRowTwoDiplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableException() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.clickAddButton();
        exceptionPage.isRowTwoDiplayedAfterWait();
        exceptionPage.enterTextInRowTwo("Coffee");
        exceptionPage.saveRow2();
        Assert.assertEquals(exceptionPage.getSuccessMessage(), "Row 2 was saved", "Message is not expected");
    }

    @Test
    public void invalidElementStateExceptionTest() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.clickEditButton();
        exceptionPage.isRowOneDiplayedAfterWait();
        exceptionPage.enterTextInRowOne("Coffee");
        exceptionPage.saveRow1();
        Assert.assertEquals(exceptionPage.getSuccessMessage(), "Row 1 was saved", "Message is not expected");
    }

    @Test
    public void staleElementReferenceExceptionTest() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.clickAddButton();
        Assert.assertTrue(exceptionPage.isInstructionsElementHiddenAfterWait(), "Instructions text is still displayed");
    }
}
