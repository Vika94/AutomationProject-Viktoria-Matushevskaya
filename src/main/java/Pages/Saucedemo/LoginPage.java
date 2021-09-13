package Pages.Saucedemo;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class LoginPage extends BasePage {
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorText = By.tagName("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage openPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(this.loginButton);
        return this;
    }

    public LoginPage checkingErrorText(String expectedText) {
        Assert.assertEquals(checkingText(this.errorText), expectedText);
        return this;
    }
}

