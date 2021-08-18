import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task6 {
    WebDriver driver = null;

    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/ ");
    }

    @Test
    public void test1() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.xpath("//a[@id='item_4_title_link']/div[@class='inventory_item_name']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'name')]")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='cart_contents_container']//descendant::div[@class='inventory_item_price']")).getText(), "$29.99");
    }

    @AfterMethod
    public void postconditions() {
        driver.quit();
    }
}

