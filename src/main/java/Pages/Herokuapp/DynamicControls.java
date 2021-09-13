package Pages.Herokuapp;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControls extends BasePage {
    private By removeBtn = By.xpath("//*[text()='Remove']");
    private By textBack = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");
    private By input = By.cssSelector("#input-example>input");
    private By enableBtn = By.xpath("//*[text()='Enable']");
    private By enableText = By.xpath("//form/p");


    public DynamicControls(WebDriver driver) {
        super(driver);
    }

    public DynamicControls verifyPageTitle() {
        Assert.assertEquals(checkingText(title), HomePageEnum.DYNAMIC_CONTROLS.getLinkText());
        return this;
    }

    public DynamicControls clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControls verifyElementText() {
        wait.until(ExpectedConditions.textToBe(textBack, appProperties.getProperties().getProperty("verifyElementText")));
        return this;
    }

    public DynamicControls verifyEnableText() {
        wait.until(ExpectedConditions.textToBe(enableText, appProperties.getProperties().getProperty("verifyEnableText")));
        return this;
    }

   /* public DynamicControls verifyElementText(String text) {
        wait.until(ExpectedConditions.textToBe(textBack, text));
        return this;
    }



    public DynamicControls verifyEnableText(String text) {
        wait.until(ExpectedConditions.textToBe(enableText, text));
        return this;
    }

    */

    public DynamicControls notDisplayBtn () {
       notDisplay(removeBtn);
        return this;
    }

    public DynamicControls checkingDisabledInput () {
      Assert.assertFalse(driver.findElement(input).isEnabled());
        return this;
    }

    public DynamicControls checkingEnableInput () {
        Assert.assertTrue(driver.findElement(input).isEnabled());
        return this;
    }

    public DynamicControls clickEnableBtn() {
        click(enableBtn);
        return this;
    }
}
