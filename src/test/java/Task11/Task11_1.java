package Task11;

import Pages.Saucedemo.LoginPage;
import Pages.Saucedemo.MenuPage;
import Pages.Saucedemo.ProductsPage;
import driver.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.annotations.*;

public class Task11_1 extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    MenuPage menuPage;

    @BeforeMethod
    public void precondition() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        menuPage = new MenuPage(driver);
        loginPage.openPage();
    }

    @DataProvider(name = "Данные для входа в приложение")
    public Object[][] inputForLogin() {
        return new Object[][]{
                {"standard_user", "secret_sauce", ""},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"problem_user", "secret_sauce", ""},
                {"performance_glitch_user", "secret_sauce", ""},
                {"123", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Link("https://www.saucedemo.com/")
    @Description("Login to application")
    @Step("Verification of application login details")
    @Test(dataProvider = "Данные для входа в приложение")
    public void loginToApplication(String username, String password, String errorText) throws InterruptedException {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        if (errorText.isEmpty()) {
            productsPage.displayLogo();
            menuPage.clickMenu();
            Thread.sleep(1000);
            menuPage.clickLogout();
        } else
            loginPage.checkingErrorText(errorText);
    }
}

