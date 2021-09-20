package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
        Assert.assertEquals(alert.getText(), appProperties.getProperties().getProperty("verifyAlertText"));
        alert.accept();
        return this;
    }

  /*  public ContextMenu verifyAlertText(){
        actions.contextClick(driver.findElement(hotSpot)).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        return this;
    }

   */
}
