package Task12;

import Pages.Herokuapp.ContextMenu;
import Pages.Herokuapp.DynamicControls;
import Pages.Herokuapp.HomePage;
import Pages.Herokuapp.HomePageEnum;
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
                .verifyElementText("It's gone!")
                .notDisplayBtn()
                .checkingDisabledInput()
                .clickEnableBtn()
                .verifyEnableText("It's enabled!")
                .checkingEnableInput();
    }
}
