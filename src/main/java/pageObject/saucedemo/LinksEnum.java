package pageObject.saucedemo;

import org.openqa.selenium.By;

public enum LinksEnum {
    ATOZ(By.xpath("//*[text()='Name (A to Z)']")),
    ZTOA(By.xpath("//*[text()='Name (Z to A)']")),
    PRICELOWTOHIGH(By.xpath("//*[text()='Price (low to high)']")),
    PRICEHIGHTOLOW(By.xpath("//*[text()='Price (high to low)']"));


    protected By element;

    LinksEnum(By element) {
        this.element = element;
    }

    public By getElement() {
        return element;
    }

}
