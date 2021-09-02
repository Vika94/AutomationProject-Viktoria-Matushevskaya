import Pages.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task10 extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    MenuPage menuPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        menuPage = new MenuPage();
        loginPage.openPage();
    }

    @Parameters({"username", "password", "errorText"})
    @Test
    public void loginToApplication_Test(@Optional("standard_user") String username,@Optional("secret_sauce") String password,@Optional("") String errorText) {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        if (errorText.isEmpty()) {
            productsPage.displayLogo();
        }else
            loginPage.checkingErrorText(errorText); //Fluent / Chain of Invocations
    }

    @Test
    public void testingMenuPage_Test5() throws InterruptedException {
        menuPage.clickMenu();
        Thread.sleep(5000);
        menuPage.displayAllItems()
                .displayAbout()
                .displayLogout()
                .displayResetAppState();
    }

}
