import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {
    @Test
    public void test1() throws InterruptedException {
      WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Привет МИР", Keys.ENTER);
        driver.findElements(By.tagName("h3")).forEach(el ->{
            System.out.println(el.getText());
        } );
        //Assert.assertEquals(driver.findElement(By.xpath("(//h3)[8]")).getText(),"Приложения в Google Play – Привет, Мир! — акции и кешбэк");
        driver.quit();

    }
}
