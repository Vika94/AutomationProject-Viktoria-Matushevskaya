package task_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task8 {
    WebDriver driver = null;

    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Vika/Desktop/TestProject/AutomationProject-Viktoria-Matushevskaya/src/test/java/task_8/task8.html");
    }

    @Test
    public void test1() {
        List<String> textList = new ArrayList<>();
        driver.findElements(By.cssSelector(".brand")).forEach((data) -> {
            textList.add(data.getText());
        });
        for (String data1 : textList) {
            System.out.println(data1);
        }
        driver.findElement(By.id("fname")).sendKeys("Виктория");
        driver.findElement(By.id("b")).click();
        Select select = new Select(driver.findElement(By.name("cars")));
        select.selectByIndex(1);
        driver.findElement(By.tagName("button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='123.jpg']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(), "Select the desired car-brand below");
        driver.findElement(By.xpath("//a")).click();
        Assert.assertEquals(driver.findElement(By.id("navbtn_tutorials")).getText(), "Tutorials");
    }

    @AfterMethod
    public void postconditions() {
        driver.quit();
    }
}
