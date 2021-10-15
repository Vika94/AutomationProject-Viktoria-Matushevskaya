package pageObject.moodPanda;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;

public class FAQs {

    @FindBy(css = "a[href$='q.aspx']")
    SelenideElement faqsBtn;

    ElementsCollection titleText = $$(By.xpath("//h3"));

    public FAQs clickFaqsBtn() {
        faqsBtn.click();
        return this;
    }

    public FAQs verifyText() {
        Assert.assertEquals(titleText.get(0).getText(), "IS IT FREE TO JOIN?");
        return this;
    }
}
