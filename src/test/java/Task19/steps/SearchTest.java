package Task19.steps;

import driver.BaseTestSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.booking.HomePage;
import pageObject.booking.SearchPage;
import properties.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;


public class SearchTest extends BaseTestSelenide {

    @Given("go to {string}")
    public void goToUrl(String url) {
         open(url);

    }

    @When("enter hotel name and click search button")
    public void enterHotelName() {
        get(HomePage.class)
                .enter("Плаза")
                .clickSearchBtn();
    }

    @Then("сheck that the hotel is displayed and its rating is 4 stars")
    public void checkRatingStars() {
        get(SearchPage.class)
                .hotelIsDisplayed()
                .verifyStars();
    }
}
