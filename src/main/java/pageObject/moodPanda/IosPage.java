package pageObject.moodPanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IosPage {

    @FindBy(xpath = "//*[text()='iOS']")
    SelenideElement iOSBtn;

    @FindBy(css = "picture[id$='106']")
    SelenideElement appStore;

    public IosPage clickIosBtn() {
        iOSBtn.click();
        return this;
    }

    public IosPage verifyAppStorePage() {
        Assert.assertTrue(appStore.shouldBe(Condition.enabled).isDisplayed());
        return this;
    }
}
