package Task12;


import pageObject.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomePage_Test extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public void precondition() {
        homePage = new HomePage();
    }

    @Test
    public void HomePageTest(){
        homePage.openPage()
                .verifyHomePage();
    }

}
