package Task12;


import Pages.Herokuapp.HomePage;
import Pages.Saucedemo.CartPage;
import Pages.Saucedemo.LoginPage;
import Pages.Saucedemo.ProductsPage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomePage_Test extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public void precondition() {
        homePage = new HomePage(driver);
    }

    @Test
    public void HomePageTest(){
        homePage.openPage()
                .verifyHomePage();
    }

}
