package pageObject.booking;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObject.moodPanda.FAQs;
import pageObject.moodPanda.HomePage;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    @FindBy(css = "[data-testid~=title]")
    SelenideElement hotel;

    ElementsCollection stars = $$(By.xpath("(//div[@data-testid='rating-stars'])[1]/span"));

    public SearchPage hotelIsDisplayed(){
        Assert.assertTrue(hotel.isDisplayed());
        return this;
    }

    public SearchPage verifyStars() {
        Assert.assertEquals(stars.size(), 4);
        return this;
    }


}
