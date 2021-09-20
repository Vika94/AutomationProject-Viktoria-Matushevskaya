package PageObject;

import driver.CreateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import properties.PropertyReader;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected PropertyReader appProperties;

    protected BasePage(WebDriver driver){
        this.driver = CreateDriver.getDriver();
        wait = new WebDriverWait(CreateDriver.getDriver(),20);
        actions = new Actions(CreateDriver.getDriver());
        appProperties = new PropertyReader("config.properties");

    }

    protected void open(){
        driver.get(appProperties.getProperties().getProperty("url"));
    }

    protected void open (String url){
        driver.get(url);
    }

    protected void enter(By element, CharSequence... charSequences) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected String checkingText(By element) {
        return driver.findElement(element).getText();
    }

    protected void displayElements(By element) {
        driver.findElements(element).forEach((data) -> {
            Assert.assertTrue(data.isDisplayed());
        });
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + elements + " is not exist.");
        }
    }

    protected void notDisplay(By element) {
       Assert.assertTrue(driver.findElements(element).isEmpty());
    }

    protected void displayElement(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());

    }

    public void pause(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
