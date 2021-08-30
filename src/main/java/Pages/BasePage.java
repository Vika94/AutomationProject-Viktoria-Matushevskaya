package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static driver.CreateDriver.getDriver;

public class BasePage {
    WebDriver driver = getDriver();

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
        List<WebElement> elements = new ArrayList<>();
        driver.findElements(element).forEach((data) -> {
            elements.add(data);
            Assert.assertTrue(data.isDisplayed());
        });
    }

    protected void displayElement(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());

    }
}
