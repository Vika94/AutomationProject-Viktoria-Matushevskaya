package Pages.Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CartPage extends BasePage {
    private By remove = By.id("remove-sauce-labs-backpack");
    private By checkout = By.name("checkout");
    private By continueShopping = By.id("continue-shopping");
    private By pageName = By.className("title");
    private By product = By.className("inventory_item_name");
    private By productsInBasket = By.className("inventory_item_name");
    private By sauceLabsBackpack = By.xpath("(//*[@class='inventory_item_name'])[1]");
    private By sauceLabsBikeLight = By.xpath("(//*[@class='inventory_item_name'])[2]");
    private By sauceLabsBoltTShirt = By.xpath("(//*[@class='inventory_item_name'])[3]");
    private By sauceLabsFleeceJacket = By.xpath("(//*[@class='inventory_item_name'])[4]");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public CartPage displayPageName() {
        displayElement(this.pageName);
        return this;
    }

    public CartPage sortProductsInBasket(){
        List<String> list = new ArrayList<>();
        driver.findElements(this.productsInBasket).forEach(data -> list.add(data.getText()));
        Assert.assertEquals(list.stream().sorted().collect(Collectors.toList()), Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"));
        return this;
    }

    public CartPage displayProductInCartPage() {
        displayElement(this.product);
        return this;
    }

    public CartPage notDisplayProductInCartPage() {
        notDisplay(this.product);
        return this;
    }

    public CartPage clickRemove() {
        click(this.remove);
        return this;
    }

    public CartPage clickCheckout() {
        click(this.checkout);
        return this;
    }

    public CartPage clickContinueShopping() {
        click(this.continueShopping);
        return this;
    }
}
