package pageObject;

import driver.CreateDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import properties.PropertyReader;

import java.util.Properties;

@Log4j2
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage(){
        this.driver = CreateDriver.getDriver();
        wait = new WebDriverWait(driver,20);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();

    }

    protected void open(){
        open(properties.getProperty("url"));
    }

    protected void open (String url){
        log.info("Open page :: " + url);
        driver.get(url);
    }

    protected void enter(By element, CharSequence... charSequences) {
        log.info("Enter in element :: " + element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        log.info("Click on element :: " + element);
        driver.findElement(element).click();
    }

    protected String checkingText(By element) {
        log.info("Checking text :: " + element);
        return driver.findElement(element).getText();
    }

    protected void displayElements(By element) {
        log.info("Display elements :: " + element);
        driver.findElements(element).forEach((data) -> {
            Assert.assertTrue(data.isDisplayed());
        });
    }

    protected void isDisplayed(By... elements) {
        log.info("Display elements :: " + elements);
        for (By element : elements) {
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + elements + " is not exist.");
        }
    }

    protected void notDisplay(By element) {
        log.info("Not display element :: " + element);
       Assert.assertTrue(driver.findElements(element).isEmpty());
    }

    protected void displayElement(By element) {
        log.info("Display element :: " + element);
        Assert.assertTrue(driver.findElement(element).isDisplayed());

    }

    public void pause(Integer seconds) {
        try {
            log.info("Sleep" + seconds * 1000);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
