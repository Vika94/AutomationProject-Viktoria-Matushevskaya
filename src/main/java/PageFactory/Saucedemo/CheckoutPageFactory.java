package PageFactory.Saucedemo;

import Pattern.Builder.PersonBuilderSaucedemo;
import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPageFactory extends BasePage {
    @FindBy(name = "checkout")
    WebElement checkout;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement zipCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finish;

    public CheckoutPageFactory(WebDriver driver) {
        super(driver);
        initElements(driver, this);
    }

    public CheckoutPageFactory clickCheckout() {
        this.checkout.click();
        return this;
    }

    public CheckoutPageFactory enterYourInformation(PersonBuilderSaucedemo personBuilder) {
        this.firstName.sendKeys(personBuilder.getFirstName());
        this.lastName.sendKeys(personBuilder.getLastName());
        this.zipCode.sendKeys(personBuilder.getZipCode());
        return this;
    }

    public CheckoutPageFactory clickContinueButton() {
        this.continueButton.click();
        return this;
    }

    public CheckoutPageFactory clickFinish() {
        this.finish.click();
        return this;
    }

}



