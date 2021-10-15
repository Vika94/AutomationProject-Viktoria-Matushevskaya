package Task16;

import driver.BaseTestSelenide;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObject.moodPanda.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Task16 extends BaseTestSelenide {

    @Description("Checking the visibility of an element on the page and scroll page")
    @Test(priority = 1)
    public void homePageTest() {
        get(HomePage.class)
                .imgPandaIsDisplayed()
                .clickScrollBtn();
    }

    @Description("Checking the registration of an existing user")
    @Test(priority = 2)
    public void RegisterPageTest() {
        get(LoginPage.class).clickLoginBtn();
        get(RegisterPage.class)
                .clickCreateAccountBtn()
                .enterFirstName("Ivan")
                .enterSurname("I")
                .selectGender()
                .selectYearOfBirth()
                .enterEmail("dg@mail.ru")
                .enterPassword("1234")
                .enterConfirmPassword("1234")
                .clickLoginBtn()
                .verifyErrorText();
    }

    @Description("Checking login successfully")
    @Test(priority = 3)
    public void loginPageTest() {
        get(LoginPage.class)
                .clickLoginBtn()
                .enterEmail("dg@mail.ru")
                .enterPassword("1234")
                .clickButtonLogin()
                .verifyText();
    }

    @Description("check the transition to the app store page")
    @Test(priority = 4)
    public void iosPage() {
        get(IosPage.class)
                .clickIosBtn()
                .verifyAppStorePage();
    }

    @Description("checking title text on FAQs page")
    @Test(priority = 4)
    public void faqsPage() {
        get(FAQs.class)
                .clickFaqsBtn()
                .verifyText();
    }

    @AfterMethod
    public void postconditions() {
        closeWebDriver();
    }
}
