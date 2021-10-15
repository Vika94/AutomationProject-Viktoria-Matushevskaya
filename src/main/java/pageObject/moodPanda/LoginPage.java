package pageObject.moodPanda;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;

public class LoginPage {

    @FindBy(xpath = "//*[text()='Login']")
    SelenideElement loginBtn;

    @FindBy(css = "input[id$='Email']")
    SelenideElement email;

    @FindBy(css = "input[id$='Password']")
    SelenideElement password;

    @FindBy(css = "input[id$='ButtonLogin']")
    SelenideElement buttonLogin;

    @FindBy(css = "span[class$='primary']")
    SelenideElement verifyText;

    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

    public LoginPage clickButtonLogin(){
        buttonLogin.click();
        return this;
    }

    public LoginPage enterEmail(String text){
        email.setValue(text);
        return this;
    }

    public LoginPage enterPassword(String text){
        password.setValue(text);
        return this;
    }

    public LoginPage verifyText(){
        verifyText.shouldBe(matchText("Go to my conversations"));
        return this;
    }
}
