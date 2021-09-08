package Pages.Herokuapp;

import Pages.Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static driver.CreateDriver.getDriver;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver){
        super(driver);
    }

    private By title = By.tagName("h1");
    private By subTitle = By.tagName("h2");

    private By getLink(HomePageEnum homePageLinksEnum) {
        return By.linkText(homePageLinksEnum.getLinkText());
    }

    public HomePage openPage(){
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }

    public HomePage verifyHomePage() {
        isDisplayed(title, subTitle);
        Arrays.asList(HomePageEnum.values()).forEach(homePageLinksEnum -> isDisplayed(getLink(homePageLinksEnum)));
        return this;
    }

    public HomePage clickLink(HomePageEnum homePageEnum) {
        click(getLink(homePageEnum));
        return this;
    }


}
