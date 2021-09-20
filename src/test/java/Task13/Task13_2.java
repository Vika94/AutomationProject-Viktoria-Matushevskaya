package Task13;

import Pattern.Builder.LoginBuilderHerokuapp;
import PageFactory.Herokuapp.LoginPageBuilder;
import PageFactory.Herokuapp.LoginPageValue;
import Pattern.ValueObject.Herokuapp;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task13_2 extends BaseTest {
    LoginPageBuilder loginPage;
    LoginBuilderHerokuapp loginBuilder;
    LoginPageValue loginPageValue;
    Herokuapp herokuapp;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPageBuilder(driver);
        loginPageValue = new LoginPageValue(driver);
        herokuapp = new Herokuapp();
    }

    @Test
    public void loginToApplication_Test() {
        herokuapp.setUserName("tomsmith");
        herokuapp.setPassword("SuperSecretPassword!");
        herokuapp.setErrorText("You logged into a secure area!\n" + "×");
        loginPage.openPage();
        loginPageValue.login(herokuapp)
                .verifyText(herokuapp);
    }

    @Test
    public void loginToApplication_Test1() {
        loginBuilder = new LoginBuilderHerokuapp.Builder().build();
        loginPage.openPage()
                .login(loginBuilder)
                .verifyText(loginBuilder);
    }

    @Test
    public void loginToApplicationNegative_Test2() {
        loginBuilder = new LoginBuilderHerokuapp.Builder()
                .withUserName("tomsmith")
                .withPassword("123")
                .withVerifyText("Your password is invalid!\n" + "×")
                .build();
        loginPage.openPage()
                .login(loginBuilder)
                .verifyText(loginBuilder);
    }
}
