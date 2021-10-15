import pageObject.saucedemo.*;
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
    public void loginToApplication_Test(@Optional("standard_user") String username, @Optional("secret_sauce") String password, @Optional("") String errorText) {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        if (errorText.isEmpty()) {
            productsPage.displayLogo();
        } else
            loginPage.checkingErrorText(errorText); //Fluent / Chain of Invocations
    }

    @Parameters({"username", "password"})
    @Test
    public void testingMenuPage_Test5(String username, String password) throws InterruptedException {
        menuPage.clickMenu();
        Thread.sleep(5000);
        menuPage.displayAllItems()
                .displayAbout()
                .displayLogout()
                .displayResetAppState();
    }

    @Parameters({"username", "password"})
    @Test
    public void testingProductPage_Test3(String username, String password) {
        productsPage.displayThePrice()
                .displayDescriptions()
                .displayProductNames()
                .displayImage()
                .displayLogo()
                .clickAddToCart()
                .clickBasket();
    }

    @Parameters({"username", "password"})
    @Test
    public void testingCartPage_Test4(String username, String password) {
        productsPage.clickAddToCart();
        productsPage.clickBasket();
        cartPage.displayProductInCartPage()
                .displayPageName()
                .clickRemove()
                .clickContinueShopping();
        productsPage.clickAddToCart().clickBasket();
        cartPage.clickCheckout();
    }

    @Parameters({"username", "password", "firstname", "lastname", "zipCode", "text"})
    @Test
    public void testingCheckoutPage_Test5(String username, String password, String firstname, String lastname, String zipCode, String text) {
        productsPage.clickAddToCart();
        productsPage.clickBasket();
        cartPage.clickCheckout();
        checkoutPage.displayCancelButton()
                .displayPageName()
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enterZipCode(zipCode)
                .clickContinueButton()
                .clickFinish()
                .checkingTextAfterOrder(text)
                .clickBackHome();
        productsPage.displayProductNames();
    }
}
