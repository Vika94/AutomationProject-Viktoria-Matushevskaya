package PageFactory.Herokuapp;

import Pattern.Builder.LoginBuilderHerokuapp;
import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPageBuilder extends BasePage {
    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//i")
    WebElement loginBtn;

    @FindBy(id = "flash")
    WebElement verifyText;

    public LoginPageBuilder(WebDriver driver) {
        super(driver);
        initElements(driver,this);
    }

    public LoginPageBuilder openPage() {
        driver.get("http://the-internet.herokuapp.com/login");
        return this;
    }

    public LoginPageBuilder login(LoginBuilderHerokuapp loginBuilder) {
        this.userName.sendKeys(loginBuilder.getUserName());
        this.password.sendKeys(loginBuilder.getPassword());
        this.loginBtn.click();
        return this;
    }

    public LoginPageBuilder verifyText(LoginBuilderHerokuapp loginBuilder){
        Assert.assertEquals(this.verifyText.getText(), loginBuilder.getVerifyText());
        return this;
    }
}
