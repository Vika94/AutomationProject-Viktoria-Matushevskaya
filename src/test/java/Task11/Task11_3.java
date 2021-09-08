package Task11;

import Pages.Saucedemo.CartPage;
import Pages.Saucedemo.LoginPage;
import Pages.Saucedemo.ProductsPage;
import driver.BaseTest;
import driver.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Task11_3 extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPage.openPage();
    }

    @Step("Login to application and add products in basket for checking sort products")
    @Test
    public void loginToApplication() throws InterruptedException {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
        productsPage.clickAddToCartProducts();
        productsPage.clickBasket();
    }

    @Step("Checking sort alphabet products in basket")
    @Description("Sort products in basket")
    @Test
    public void sortProducts() {
        cartPage.sortProductsInBasket();
    }

    @Step("Checking screenshot fail test")
    @Test
    public void failTest() {
        productsPage.clickAddToCart();
    }
}
