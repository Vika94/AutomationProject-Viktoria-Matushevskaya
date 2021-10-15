package pageObject.saucedemo;

import pageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ProductsPage extends BasePage {
    private By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartProduct1 = By.id("add-to-cart-sauce-labs-bike-light");
    private By addToCartProduct2 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By addToCartProduct3 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By basket = By.className("shopping_cart_link");
    private By productNames = By.className("inventory_item_name");
    private By prices = By.className("inventory_item_price");
    private By descriptions = By.className("inventory_item_desc");
    private By image = By.xpath("//*[@alt='Sauce Labs Backpack']");
    private By logo = By.className("app_logo");
    private By remove = By.id("remove-sauce-labs-backpack");
    private By sort = By.cssSelector(".product_sort_container");

    private By getLink(LinksEnum linksEnum) {
        return linksEnum.getElement();
    }

    public ProductsPage clickLink(LinksEnum linksEnum) {
        click(getLink(linksEnum));
        return this;
    }

    public ProductsPage sortProductsAToZ() {
        List<String> list = new ArrayList<>();
        driver.findElements(this.productNames).forEach(data -> list.add(data.getText()));
        Assert.assertEquals(list.stream().sorted().collect(Collectors.toList()),
                Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"));
        return this;
    }

    public ProductsPage sortProductsZToA() {
        List<String> list = new ArrayList<>();
        driver.findElements(this.productNames).forEach(data -> list.add(data.getText()));
        list.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack"));
        return this;
    }

    public ProductsPage sortProductsPriceLowToHigh() {
        List<String> list = new ArrayList<>();
        driver.findElements(this.prices).forEach(data -> list.add(data.getText()));
        list.stream()
                .map(el -> el.replace("$", ""))
                .map(Double::parseDouble)
                .sorted().collect(Collectors.toList());
        Assert.assertEquals(list, Arrays.asList("$7.99", "$9.99", "$15.99", "$15.99", "$29.99", "$49.99"));
        return this;
    }

    public ProductsPage sortProductsPriceHighToLow() {
        List<String> list = new ArrayList<>();
        driver.findElements(this.prices).forEach(data -> list.add(data.getText()));
        list.stream()
                .map(el -> el.replace("$", ""))
                .map(Double::parseDouble)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(list, Arrays.asList("$49.99", "$29.99", "$15.99", "$15.99", "$9.99", "$7.99"));
        return this;
    }

    public ProductsPage displayThePrice() {
        displayElements(this.prices);
        return this;
    }

    public ProductsPage displayDescriptions() {
        displayElements(this.descriptions);
        return this;
    }

    public ProductsPage displayProductNames() {
        displayElements(this.productNames);
        return this;
    }

    public ProductsPage clickAddToCart() {
        click(this.addToCart);
        return this;
    }

    public ProductsPage clickAddToCartProducts() {
        click(this.addToCart);
        click(this.addToCartProduct1);
        click(this.addToCartProduct2);
        click(this.addToCartProduct3);
        return this;
    }

    public ProductsPage clickRemove() {
        click(this.remove);
        return this;
    }

    public ProductsPage clickBasket() {
        click(this.basket);
        return this;
    }

    public ProductsPage displayImage() {
        displayElement(this.image);
        return this;
    }

    public ProductsPage displayLogo() {
        displayElement(this.logo);
        return this;
    }
}
