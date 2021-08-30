package Pages;

import org.openqa.selenium.By;


public class MenuPage extends BasePage {
    private By menu = By.id("react-burger-menu-btn");
    private By allItems = By.id("inventory_sidebar_link");
    private By about = By.id("about_sidebar_link");
    private By logout = By.id("logout_sidebar_link");
    private By resetAppState = By.id("reset_sidebar_link");


    public MenuPage clickMenu() {
        click(this.menu);
        return this;
    }

    public MenuPage displayAllItems() {
        displayElement(this.allItems);
        return this;
    }

    public MenuPage displayAbout() {
        displayElement(this.about);
        return this;
    }

    public MenuPage displayLogout() {
        displayElement(this.logout);
        return this;
    }

    public MenuPage displayResetAppState() {
        displayElement(this.resetAppState);
        return this;
    }
}
