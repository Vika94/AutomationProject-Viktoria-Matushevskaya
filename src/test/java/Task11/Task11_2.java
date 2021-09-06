package Task11;

import Pages.*;
import driver.BaseTest;
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

    @Test
    public void loginToApplication() {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Test(invocationCount = 5)
    public void addAndDeleteProductInBasket(){
        productsPage.clickAddToCart();
        productsPage.clickRemove();
    }
}

