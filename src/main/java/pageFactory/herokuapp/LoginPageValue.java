package pageFactory.herokuapp;

import pattern.valueObject.Herokuapp;
import pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPageValue extends BasePage {
    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//i")
    WebElement loginBtn;

    @FindBy(id = "flash")
    WebElement verifyText;

    public LoginPageValue(WebDriver driver) {
        initElements(driver, this);
    }

    public LoginPageValue login(Herokuapp herokuapp) {
        this.userName.sendKeys(herokuapp.getUserName());
        this.password.sendKeys(herokuapp.getPassword());
        this.loginBtn.click();
        return this;
    }

    public LoginPageValue verifyText(Herokuapp herokuapp) {
        Assert.assertEquals(this.verifyText.getText(), herokuapp.getErrorText());
        return this;
    }
}
