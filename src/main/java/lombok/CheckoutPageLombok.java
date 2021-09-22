package lombok;

import pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPageLombok extends BasePage {
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

    public CheckoutPageLombok(WebDriver driver) {
        initElements(driver, this);
    }

    public CheckoutPageLombok clickCheckout() {
        this.checkout.click();
        return this;
    }

    public CheckoutPageLombok enterYourInformation(BuilderSaucedemo builderSaucedemo) {
        this.firstName.sendKeys(builderSaucedemo.getFirstName());
        this.lastName.sendKeys(builderSaucedemo.getLastName());
        this.zipCode.sendKeys(builderSaucedemo.getZipCode());
        return this;
    }

    public CheckoutPageLombok clickContinueButton() {
        this.continueButton.click();
        return this;
    }

    public CheckoutPageLombok clickFinish() {
        this.finish.click();
        return this;
    }
}



