package Pages.Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

    public ProductsPage(WebDriver driver) {
        super(driver);
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
