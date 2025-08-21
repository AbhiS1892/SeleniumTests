package com.sa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionPage extends BasePage {

    private By addButtonLocator = By.id("add_btn");
    private By editButtonLocator = By.id("edit_btn");
    private By row1InputFieldLocator = By.xpath("//div[@id='row1']/input");
    private By row1SaveButtonLocator = By.xpath("//div[@id='row1']/button[@name='Save']");
    private By row2InputFieldLocator = By.xpath("//div[@id='row2']/input");
    private By row2SaveButtonLocator = By.xpath("//div[@id='row2']/button[@name='Save']");
    private By confirmationLocator = By.id("confirmation");
    private By instructionsLocator = By.id("instructions");

    public ExceptionPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAddButton() {
        driver.findElement(addButtonLocator).click();
    }

    public void clickEditButton() {
        driver.findElement(editButtonLocator).click();
    }

    public boolean isRowOneDiplayedAfterWait() {
        return waitForIsDisplayed(row1InputFieldLocator);
    }

    public boolean isRowTwoDiplayedAfterWait() {
        return waitForIsDisplayed(row2InputFieldLocator);
    }

    public void enterTextInRowOne(String text) {
        WebElement row1Input = driver.findElement(row1InputFieldLocator);
        row1Input.clear();
        row1Input.sendKeys(text);
    }

    public void enterTextInRowTwo(String text) {
        driver.findElement(row2InputFieldLocator).sendKeys(text);
    }

    public void saveRow1() {
        driver.findElement(row1SaveButtonLocator).click();
    }

    public void saveRow2() {
        driver.findElement(row2SaveButtonLocator).click();
    }

    public String getSuccessMessage() {
        return waitForElement(confirmationLocator).getText();
    }

    public boolean isInstructionsElementHiddenAfterWait() {
        return waitForIsHidden(instructionsLocator);
    }
}
