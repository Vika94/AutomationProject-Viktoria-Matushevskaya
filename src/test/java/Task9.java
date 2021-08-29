import Pages.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task9 extends BaseTest {
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

    @Test(priority = 1)
    public void loginToApplication_Test() {
        loginPage.enterUsername("123")
                .enterPassword("secret_sauce")
                .clickLogin()
                .checkingErrorText("Epic sadface: Username and password do not match any user in this service"); //Fluent / Chain of Invocations
    }

    @Test(priority = 2)
    public void loginToApplication_Test1() {
        loginPage.enterUsername("locked_out_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .checkingErrorText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 3)
    public void loginToApplication_Test2() {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Test(priority = 4)
    public void testingMenuPage_Test5() throws InterruptedException {
        menuPage.clickMenu();
        Thread.sleep(5000);
        menuPage.displayAllItems()
                .displayAbout()
                .displayLogout()
                .displayResetAppState();
    }

    @Test(priority = 5)
    public void testingProductPage_Test3() {
        productsPage.displayThePrice()
                .displayDescriptions()
                .displayProductNames()
                .displayImage()
                .displayLogo()
                .clickAddToCart()
                .clickBasket();
    }

    @Test(priority = 6)
    public void testingCartPage_Test4() {
        cartPage.displayProductInCartPage()
                .displayPageName()
                .clickRemove()
                .clickContinueShopping();
        productsPage.clickAddToCart().clickBasket();
        cartPage.clickCheckout();
    }

    @Test(priority = 7)
    public void testingCheckoutPage_Test5() {
        checkoutPage.displayCancelButton()
                .displayPageName()
                .enterFirstName("Viktoria")
                .enterLastName("Ivanova")
                .enterZipCode("1235")
                .clickContinueButton()
                .clickFinish()
                .checkingTextAfterOrder("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
                .clickBackHome();
        productsPage.displayProductNames();
    }
}


