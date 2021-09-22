package Task12;

import pageObject.herokuapp.DynamicControls;
import pageObject.herokuapp.HomePage;
import pageObject.herokuapp.HomePageEnum;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicControls_Test extends BaseTest {
    DynamicControls dynamicControls;
    HomePage homePage;


    @BeforeClass
    public void precondition() {
        dynamicControls = new DynamicControls();
        homePage = new HomePage();
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
