package Task11;

import pageObject.saucedemo.CartPage;
import pageObject.saucedemo.LinksEnum;
import pageObject.saucedemo.LoginPage;
import pageObject.saucedemo.ProductsPage;
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
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
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

    @Test
    public void sortProducts()  {
        productsPage.sortProductsAToZ()
                .clickLink(LinksEnum.ZTOA)
                .sortProductsZToA()
                .clickLink(LinksEnum.PRICELOWTOHIGH)
                .sortProductsPriceLowToHigh()
                .clickLink(LinksEnum.PRICEHIGHTOLOW)
                .sortProductsPriceHighToLow();
    }
}

