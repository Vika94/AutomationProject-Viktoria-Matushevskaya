package Pages;

import org.openqa.selenium.By;


public class CartPage extends BasePage {
    private By remove = By.id("remove-sauce-labs-backpack");
    private By checkout = By.name("checkout");
    private By continueShopping = By.id("continue-shopping");
    private By pageName = By.className("title");
    private By product = By.className("inventory_item_name");


    public CartPage displayPageName() {
        displayElement(this.pageName);
        return this;
    }

    public CartPage displayProductInCartPage() {
        displayElement(this.product);
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
