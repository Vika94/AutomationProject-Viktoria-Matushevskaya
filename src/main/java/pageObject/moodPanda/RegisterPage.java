package pageObject.moodPanda;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    SelenideElement createAccountBtn = $(By.xpath("//*[text()='Create Account']"));

    SelenideElement firstName = $("input[id$='Name']");

    SelenideElement surname = $("input[id$='Surname']");

    SelenideElement gender = $("select[id$='Gender']");

    SelenideElement yearOfBirth = $("select[id$='Birth']");

    SelenideElement email = $("input[id$='Email']");

    SelenideElement password = $("input[id$='Password']");

    SelenideElement confirmPassword = $("input[id$='Confirm']");

    SelenideElement loginBtn = $(" input[value$='Login']");

    SelenideElement errorText = $("div[id$='MessageExists']");

    public RegisterPage clickCreateAccountBtn() {
        createAccountBtn.click();
        return this;
    }

    public RegisterPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public RegisterPage enterFirstName(String text) {
        firstName.setValue(text);
        return this;
    }

    public RegisterPage enterPassword(String text) {
        password.setValue(text);
        return this;
    }

    public RegisterPage enterConfirmPassword(String text) {
        confirmPassword.setValue(text);
        return this;
    }

    public RegisterPage enterEmail(String text) {
        email.setValue(text);
        return this;
    }

    public RegisterPage enterSurname(String text) {
        surname.setValue(text);
        return this;
    }

    public RegisterPage selectGender() {
        gender.selectOption(2);
        return this;
    }

    public RegisterPage selectYearOfBirth() {
        yearOfBirth.selectOption(14);
        return this;
    }

    public RegisterPage verifyErrorText(){
        errorText.shouldBe(matchText("Error: This email is already registed with MoodPanda"));
        return this;
    }
}
