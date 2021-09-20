package Task12;

import PageObject.Herokuapp.DynamicControls;
import PageObject.Herokuapp.HomePage;
import PageObject.Herokuapp.HomePageEnum;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicControls_Test extends BaseTest {
    DynamicControls dynamicControls;
    HomePage homePage;


    @BeforeClass
    public void precondition() {
        dynamicControls = new DynamicControls(driver);
        homePage = new HomePage(driver);
        homePage.clickLink(HomePageEnum.DYNAMIC_CONTROLS);

    }

    @Test
    public void DynamicControls_Test(){
        dynamicControls.verifyPageTitle()
                .clickRemoveBtn()
                .verifyElementText()
                .notDisplayBtn()
                .checkingDisabledInput()
                .clickEnableBtn()
                .verifyEnableText()
                .checkingEnableInput();
    }
}
