package pageObject.booking;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#ss")
    SelenideElement search;

    @FindBy(css = ".b-button__text")
    SelenideElement searchBtn;

    public HomePage enter(String text){
        search.setValue(text);
        return this;
    }

    public HomePage clickSearchBtn(){
        searchBtn.click();
        return this;
    }


}
