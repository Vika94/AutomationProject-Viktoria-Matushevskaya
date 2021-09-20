package PageFactory.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;


public class ProductsPageFactory extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCart;

    @FindBy(className = "shopping_cart_link")
    WebElement basket;

    @FindBys({@FindBy(className = "inventory_item_name")})
    private List<WebElement> productNames;

    @FindBys({@FindBy(className = "inventory_item_price")})
    private List<WebElement> prices;

    @FindBys({@FindBy(className = "inventory_item_desc")})
    private List<WebElement> descriptions;

    @FindBy(xpath = "//*[@alt='Sauce Labs Backpack']")
    WebElement image;

    @FindBy(className = "app_logo")
    WebElement logo;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement remove;

    public ProductsPageFactory(WebDriver driver) {
        super(driver);
        initElements(driver,this);
    }

    public ProductsPageFactory displayThePrice() {
        prices.forEach((data) -> {
            Assert.assertTrue(data.isDisplayed());
        });
        return this;
    }

    public ProductsPageFactory displayDescriptions() {
       descriptions.forEach((data) -> {
           Assert.assertTrue(data.isDisplayed());
       });
        return this;
    }

    public ProductsPageFactory displayProductNames() {
       productNames.forEach((data) -> {
          Assert.assertTrue(data.isDisplayed());
       });
        return this;
    }

    public ProductsPageFactory clickAddToCart() {
       addToCart.click();
        return this;
    }

    public ProductsPageFactory clickRemove() {
        remove.click();
        return this;
    }

    public ProductsPageFactory clickBasket() {
        basket.click();
        return this;
    }

    public ProductsPageFactory displayImage() {
        image.isDisplayed();
        return this;
    }

    public ProductsPageFactory displayLogo() {
        logo.isDisplayed();
        return this;
    }
}
