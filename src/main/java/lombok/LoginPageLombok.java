package lombok;

import pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPageLombok extends BasePage {
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement errorText;

    public LoginPageLombok(WebDriver driver) {
        initElements(driver, this);
    }

    public LoginPageLombok openPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPageLombok enterUsername(ValueObjectSaucedemo valueObjectSaucedemo) {
        this.userName.sendKeys(valueObjectSaucedemo.getUserName());
        return this;
    }

    public LoginPageLombok enterPassword(ValueObjectSaucedemo valueObjectSaucedemo) {
        this.password.sendKeys(valueObjectSaucedemo.getPassword());
        return this;
    }

    public LoginPageLombok clickLogin() {
        this.loginButton.click();
        return this;
    }

    public LoginPageLombok checkingErrorText(ValueObjectSaucedemo valueObjectSaucedemo) {
        Assert.assertEquals(this.errorText.getText(), valueObjectSaucedemo.getErrorText());
        return this;
    }
}

