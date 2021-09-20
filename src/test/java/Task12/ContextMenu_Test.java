package Task12;

import PageObject.Herokuapp.ContextMenu;
import PageObject.Herokuapp.HomePage;
import PageObject.Herokuapp.HomePageEnum;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenu_Test extends BaseTest {
    ContextMenu contextMenu;
    HomePage homePage;


    @BeforeClass
    public void precondition() {
        contextMenu = new ContextMenu(driver);
        homePage = new HomePage(driver);
        homePage.clickLink(HomePageEnum.CONTEXT_MENU);

    }

    @Test
    public void ContextMenu_Test(){
        contextMenu.verifyPageTitle()
                .verifyAlertText();
    }
}
