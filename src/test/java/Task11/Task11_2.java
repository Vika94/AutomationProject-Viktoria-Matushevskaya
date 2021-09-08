package Task11;

import Pages.Saucedemo.CartPage;
import Pages.Saucedemo.LoginPage;
import Pages.Saucedemo.ProductsPage;
import driver.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task11_2 extends BaseTest {
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


    @Step("Login to application for checking add and delete product from basket")
    @Test
    public void loginToApplication() {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Step("Checking: add and delete product from basket,availability product in basket")
    @Description("Add and delete product in basket")
    @Test(invocationCount = 5)
    public void addAndDeleteProductInBasket() {
        productsPage.clickAddToCart();
        productsPage.clickBasket();
        cartPage.displayProductInCartPage();
        cartPage.clickRemove();
        cartPage.notDisplayProductInCartPage();
        cartPage.clickContinueShopping();
    }
}

