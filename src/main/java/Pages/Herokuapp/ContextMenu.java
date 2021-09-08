package Pages.Herokuapp;

import Pages.Saucedemo.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static driver.CreateDriver.getDriver;

public class ContextMenu extends BasePage {

    public ContextMenu(WebDriver driver){
        super(driver);
    }

    private By title = By.tagName("h3");
    private By hotSpot = By.id("hot-spot");

    public ContextMenu verifyPageTitle(){
        Assert.assertEquals(checkingText(title),HomePageEnum.CONTEXT_MENU.getLinkText());
        return this;
    }

    public ContextMenu verifyAlertText(){
        actions.contextClick(driver.findElement(hotSpot)).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        return this;
    }
}
