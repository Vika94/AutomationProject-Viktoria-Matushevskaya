import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    WebDriver driver = null;

    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //тест №1 Ввод значения(обертка) и проверка результата( обертка)
    @Test
    public void test1() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
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
        checkByText("s_lam", "19.91 м2.");
        checkByText("l_count", "1020 шт.");
        checkByText("l_packs", "146 шт.");
        checkByText("l_price", "3127 руб.");
        checkByText("l_over", "2 шт.");
        checkByText("l_trash", "28 шт.");
    }

    //тест №2Ввод значения(обертка), проверка введенного результата (обертка) проверка результата(обертка)
    @Test
    public void test2() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
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
        checkByValue("calc_roomwidth", "7.000");
        checkByValue("calc_roomheight", "5.000");
        checkByValue("calc_lamwidth", "130");
        checkByValue("calc_lamheight", "150");
        checkByValue("calc_inpack", "5");
        checkByValue("calc_price", "200");
        checkByValue("calc_bias", "11");
        checkByValue("calc_walldist", "4");
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
        checkByText("s_lam", "34.90 м2.");
        checkByText("l_count", "1836 шт.");
        checkByText("l_packs", "368 шт.");
        checkByText("l_price", "7176 руб.");
        checkByText("l_over", "4 шт.");
        checkByText("l_trash", "32 шт.");
    }

    //тест №3 Ввод недопустимого значения(обертка), проверка введенного
    // результата(числа по умолчанию(обертка)) проверка результата(через Лист)

    @Test
    public void test3() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
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
        checkByValue("calc_roomwidth", "1.000");
        checkByValue("calc_roomheight", "1.000");
        checkByValue("calc_lamwidth", "100");
        checkByValue("calc_lamheight", "50");
        checkByValue("calc_inpack", "1");
        checkByValue("calc_price", "10");
        checkByValue("calc_bias", "");
        checkByValue("calc_walldist", "1");
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

    @Test
    public void test4() {
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Привет Мир", Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("(//*[@class='LC20lb DKV0Md'])[7]"));
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('LC20lb DKV0Md')[6].scrollIntoViewIfNeeded(true)", element);
        element.click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='wysiwig-header__title page-title']")).getText(),
                "Пополняйте вашу карту «Мир»\n" +
                        "с любой карты");
    }


    @Test
    public void test5() {
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("//", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='card-section']")).getText(),
                "По запросу // ничего не найдено. \n" +
                        "Рекомендации:\n" +
                        "Убедитесь, что все слова написаны без ошибок.\n" +
                        "Попробуйте использовать другие ключевые слова.\n" +
                        "Попробуйте использовать более популярные ключевые слова.");
    }

    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, -1, 10, 11, -20, 40);
        List<Integer> newList = list.stream().filter(number -> number > 0).collect(Collectors.toList());
        System.out.println(newList);
        List<Integer> newList1 = list.stream().filter(number -> number < 0).collect(Collectors.toList());
        System.out.println(newList1);
        List<Integer> newList2 = list.stream().filter(number -> number % 5 == 0 && number != 0).collect(Collectors.toList());
        System.out.println(newList2);
        List<Integer> newList3 = list.stream().filter(number -> number % 10 == 0 && number != 0).collect(Collectors.toList());
        System.out.println(newList3);
    }

    public void clearAndInput(String element, String data) {
        driver.findElement(By.name(element)).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), data, Keys.ENTER);
    }

    public void checkByText(String element, String data) {
        Assert.assertEquals(driver.findElement(By.id(element)).getText(), data);
    }

    public void checkByValue(String element, String data) {
        Assert.assertEquals(driver.findElement(By.name(element)).getAttribute("value"), data);
    }

    @AfterMethod
    public void postconditions() {
        driver.quit();
    }
}
