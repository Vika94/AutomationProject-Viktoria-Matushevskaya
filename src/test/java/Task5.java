import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }
/*   //тест №1 Ввод значения(обертка) и проверка результата( обертка)
    @Test
    public void test1() {
        clearAndInput("calc_roomwidth", "5");
        clearAndInput("calc_roomheight", "4");
        clearAndInput("calc_lamwidth", "120");
        clearAndInput("calc_lamheight", "170");
        clearAndInput("calc_inpack", "7");
        clearAndInput("calc_price", "150");
        Select select = new Select(driver.findElement(By.name("calc_direct")));
        select.selectByIndex(1);
        clearAndInput("calc_bias", "2");
        clearAndInput("calc_walldist", "5");
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
        check("s_lam", "19.91 м2.");
        check("l_count", "1020 шт.");
        check("l_packs", "146 шт.");
        check("l_price", "3127 руб.");
        check("l_over", "2 шт.");
        check("l_trash", "28 шт.");
    }

     //тест №2Ввод значения(обертка), проверка введенного результата (обертка) проверка результата(обертка)
    @Test
    public void test2() {
        Select select = new Select(driver.findElement(By.name("calc_direct")));
        select.selectByIndex(0);
        clearAndInput("calc_roomwidth", "7");
        clearAndInput("calc_roomheight", "5");
        clearAndInput("calc_lamwidth", "130");
        clearAndInput("calc_lamheight", "150");
        clearAndInput("calc_inpack", "5");
        clearAndInput("calc_price", "200");
        clearAndInput("calc_bias", "11");
        clearAndInput("calc_walldist", "4");
        check1("calc_roomwidth", "7.000");
        check1("calc_roomheight", "5.000");
        check1("calc_lamwidth", "130");
        check1("calc_lamheight", "150");
        check1("calc_inpack", "5");
        check1("calc_price", "200");
        check1("calc_bias", "11");
        check1("calc_walldist", "4");
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
        check("s_lam", "34.90 м2.");
        check("l_count", "1836 шт.");
        check("l_packs", "368 шт.");
        check("l_price", "7176 руб.");
        check("l_over", "4 шт.");
        check("l_trash", "32 шт.");
    }
 */
    //тест №3 Ввод недопустимого значения(обертка), проверка введенного
    // результата(числа по умолчанию(обертка)) проверка результата(через Лист)

    @Test
    public void test3() {
        Select select = new Select(driver.findElement(By.name("calc_direct")));
        select.selectByIndex(0);
        clearAndInput("calc_roomwidth", "-");
        clearAndInput("calc_roomheight", "-");
        clearAndInput("calc_lamwidth", "-");
        clearAndInput("calc_lamheight", "-");
        clearAndInput("calc_inpack", "-");
        clearAndInput("calc_price", "-");
        clearAndInput("calc_bias", "-");
        clearAndInput("calc_walldist", "-");
        check1("calc_roomwidth", "1.000");
        check1("calc_roomheight", "1.000");
        check1("calc_lamwidth", "100");
        check1("calc_lamheight", "50");
        check1("calc_inpack", "1");
        check1("calc_price", "10");
        check1("calc_bias", "");
        check1("calc_walldist", "1");
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
        List<String> textList = new ArrayList<>();
        driver.findElements(By.xpath("//*[@class='col-xs-12 col-sm-12 whiteback']//div")).forEach(data -> textList.add(data.getText()));
        Assert.assertTrue(textList.contains("Площадь укладки: 1.00 м2."));
        Assert.assertTrue(textList.contains("Кол-во панелей: 200 шт."));
        Assert.assertTrue(textList.contains("Кол-во упаковок: 200 шт."));
        Assert.assertTrue(textList.contains("Стоимость: 10 руб."));
        Assert.assertTrue(textList.contains("Остатки: 0 шт."));
        Assert.assertTrue(textList.contains("Отрезки: 18 шт."));
    }

    public void clearAndInput(String element, String data) {
        driver.findElement(By.name(element)).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), data, Keys.ENTER);
    }

    public void check(String element, String data) {
        Assert.assertEquals(driver.findElement(By.id(element)).getText(), data);
    }

    public void check1(String element, String data) {
        Assert.assertEquals(driver.findElement(By.name(element)).getAttribute("value"), data);
    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
