package Pages.Saucedemo;

import org.openqa.selenium.By;

public enum LinksEnum {
    SauceLabsBackpack(By.xpath("(//*[@class='inventory_item_name'])[1]")),
    SauceLabsBikeLight( By.xpath("(//*[@class='inventory_item_name'])[2]")),
    SauceLabsBoltTShirt(By.xpath("(//*[@class='inventory_item_name'])[3]")),
    SauceLabsFleeceJacket(By.xpath("(//*[@class='inventory_item_name'])[4]"));


    private By element;

    LinksEnum(By element) {
        this.element = element;
    }

    public By getElement() {
        return element;
    }

}
