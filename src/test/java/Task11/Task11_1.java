package Task11;

import Pages.LoginPage;
import Pages.MenuPage;
import Pages.ProductsPage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class Task11_1 extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    MenuPage menuPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        menuPage = new MenuPage();
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

