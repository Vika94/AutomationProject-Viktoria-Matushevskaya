package driver;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import testng.Listener;

import static driver.CreateDriver.getDriver;
import static driver.CreateDriver.quitDriver;
@Listeners(Listener.class)
public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) {
        driver = getDriver();
    }
}
