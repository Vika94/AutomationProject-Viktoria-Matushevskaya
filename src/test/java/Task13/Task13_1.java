package Task13;

import PageFactory.Builder.PersonBuilder;
import PageFactory.CheckoutPageFactory;
import PageFactory.LoginPageFactory;
import PageFactory.ValueObject.LoginValueObject;
import PageFactory.ProductsPageFactory;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task13_1 extends BaseTest {
    LoginPageFactory loginPageFactory;
    ProductsPageFactory productsPageFactory;
    LoginValueObject loginValueObject;
    CheckoutPageFactory checkoutPageFactory;
    PersonBuilder personBuilder;

    @BeforeClass
    public void precondition() {
        loginPageFactory = new LoginPageFactory(driver);
        productsPageFactory = new ProductsPageFactory(driver);
        loginValueObject = new LoginValueObject();
        checkoutPageFactory = new CheckoutPageFactory(driver);
    }

    @BeforeMethod
    public void register() {
        loginValueObject.setUserName("standard_user");
        loginValueObject.setPassword("secret_sauce");
        loginPageFactory.openPage()
                .enterUsername(loginValueObject)
                .enterPassword(loginValueObject)
                .clickLogin();
    }

    @Test
    public void loginToApplication_Test1() {
        loginValueObject.setUserName("standard_user");
        loginValueObject.setPassword("123");
        loginValueObject.setErrorText("Epic sadface: Username and password do not match any user in this service");
        loginPageFactory.openPage()
                .enterUsername(loginValueObject)
                .enterPassword(loginValueObject)
                .clickLogin();
        if (loginValueObject.getErrorText().isEmpty()) {
            productsPageFactory.displayLogo();
        } else
            loginPageFactory.checkingErrorText(loginValueObject);
    }

    @Test
    public void testingProductPage_Test2() {
        productsPageFactory.displayThePrice()
                .displayDescriptions()
                .displayProductNames()
                .displayImage()
                .displayLogo();
    }

    @Test
    public void testingCheckoutPage_Test3() {
        personBuilder = new PersonBuilder.Builder().withFirstName("Vika").withLastName("sdges").withZipCode("123").build();
        productsPageFactory.clickAddToCart()
                .clickBasket();
        checkoutPageFactory.clickCheckout()
                .enterYourInformation(personBuilder)
                .clickContinueButton()
                .clickFinish();
    }
}
