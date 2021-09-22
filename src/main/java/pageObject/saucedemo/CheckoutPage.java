package pageObject.saucedemo;

import pageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;



public class CheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By pageName = By.className("title");
    private By finish = By.id("finish");
    private By textAfterOrder = By.className("complete-text");
    private By backHome = By.id("back-to-products");

    public CheckoutPage displayCancelButton() {
        displayElement(this.cancelButton);
        return this;
    }

    public CheckoutPage displayPageName() {
        displayElement(this.pageName);
        return this;
    }

    public CheckoutPage enterFirstName(String firstName) {
        enter(this.firstName, firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        enter(this.lastName, lastName);
        return this;
    }

    public CheckoutPage enterZipCode(String zipCode) {
        enter(this.zipCode, zipCode);
        return this;
    }

    public CheckoutPage clickContinueButton() {
        click(this.continueButton);
        return this;
    }

    public CheckoutPage clickFinish() {
        click(this.finish);
        return this;
    }

    public CheckoutPage checkingTextAfterOrder(String textAfterOrder) {
        Assert.assertEquals(checkingText(this.textAfterOrder), textAfterOrder);
        return this;
    }

    public CheckoutPage clickBackHome() {
        click(this.backHome);
        return this;
    }
}
