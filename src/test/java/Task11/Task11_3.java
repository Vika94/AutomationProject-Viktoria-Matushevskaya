package Task11;

import Pages.CartPage;
import Pages.LinksEnum;
import Pages.LoginPage;
import Pages.ProductsPage;
import driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task11_3 extends BaseTest {
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

    @Test
    public void loginToApplication() throws InterruptedException {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
        productsPage.clickAddToCartProducts();
        productsPage.clickBasket();
    }

    @Test
    public void sortProducts() {
        cartPage.sortProductsInBasket();
    }
}
