package Task14;

import lombok.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task14 extends BaseTest {
    CheckoutPageLombok checkoutPageLombok;
    LoginPageLombok loginPageLombok;
    ProductsPageLombok productsPageLombok;
    ValueObjectSaucedemo valueObjectSaucedemo;

    @BeforeClass
    public void precondition() {
        checkoutPageLombok = new CheckoutPageLombok(driver);
        loginPageLombok = new LoginPageLombok(driver);
        productsPageLombok = new ProductsPageLombok(driver);
        valueObjectSaucedemo = new ValueObjectSaucedemo();
    }

    @BeforeMethod
    public void register() {
        valueObjectSaucedemo.setUserName("standard_user");
        valueObjectSaucedemo.setPassword("secret_sauce");
        loginPageLombok.openPage()
                .enterUsername(valueObjectSaucedemo)
                .enterPassword(valueObjectSaucedemo)
                .clickLogin();
    }

    @Test
    public void loginToApplication_Test1() {
        valueObjectSaucedemo.setUserName("standard_user");
        valueObjectSaucedemo.setPassword("123");
        valueObjectSaucedemo.setErrorText("Epic sadface: Username and password do not match any user in this service");
        loginPageLombok.openPage()
                .enterUsername(valueObjectSaucedemo)
                .enterPassword(valueObjectSaucedemo)
                .clickLogin();
        if (valueObjectSaucedemo.getErrorText().isEmpty()) {
            productsPageLombok.displayLogo();
        } else
            loginPageLombok.checkingErrorText(valueObjectSaucedemo);
    }

    @Test
    public void testingProductPage_Test2() {
        productsPageLombok.displayThePrice()
                .displayDescriptions()
                .displayProductNames()
                .displayImage()
                .displayLogo();
    }

    @Test
    public void testingCheckoutPage_Test3() {
        BuilderSaucedemo builderSaucedemo = BuilderSaucedemo.builder()
                .firstName("Vika")
                .lastName("Ivanova")
                .zipCode("123")
                .build();
        productsPageLombok.clickAddToCart()
                .clickBasket();
        checkoutPageLombok.clickCheckout()
                .enterYourInformation(builderSaucedemo)
                .clickContinueButton()
                .clickFinish();
    }
}
