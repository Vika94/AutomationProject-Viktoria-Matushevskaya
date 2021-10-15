package pageObject.moodPanda;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    @FindBy(xpath = "//img[1]")
    SelenideElement imgPanda;

    @FindBy(css = ".scroll-down")
    SelenideElement scrollBtn;

    public HomePage clickScrollBtn(){
        scrollBtn.click();
        return this;
    }

    public HomePage imgPandaIsDisplayed(){
       Assert.assertTrue(imgPanda.isDisplayed());
        return this;
    }
}
