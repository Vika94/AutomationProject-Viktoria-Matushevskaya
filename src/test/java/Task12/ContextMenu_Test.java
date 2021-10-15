package Task12;

import pageObject.herokuapp.ContextMenu;
import pageObject.herokuapp.HomePage;
import pageObject.herokuapp.HomePageEnum;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenu_Test extends BaseTest {
    ContextMenu contextMenu;
    HomePage homePage;


    @BeforeClass
    public void precondition() {
        contextMenu = new ContextMenu();
        homePage = new HomePage();
        homePage.clickLink(HomePageEnum.CONTEXT_MENU);

    }

    @Test
    public void ContextMenu_Test(){
        contextMenu.verifyPageTitle()
                .verifyAlertText();
    }
}
