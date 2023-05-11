package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StorePage {
    WebDriver driver;
    public StorePage(WebDriver driver) {
        this.driver = driver;
    }

    By storeBtn = By.id("menu-item-45");
    By enterBtn = By.className("wc-block-product-search__button");
    By textBox = By.xpath("//*[@id=\"wc-block-search__input-1\"]");
    By accessories = By.xpath("//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]/a");
    By dropdown = By.xpath("//*[@id=\"main\"]/div/form/select");
    By lowToHigh = By.xpath("//*[@id=\"main\"]/div/form/select/option[5]");

    public void clickStoreBtn() {
        driver.findElement(storeBtn).click();
    }
    public void clickEnterBtn()
    {
        driver.findElement(enterBtn).click();
    }
    public WebElement getTextBox()
    {
        return driver.findElement(textBox);
    }

    public void clickAccessoriesBtn()
    {
        driver.findElement(accessories).click();
    }

    public void clickSortingMethod()
    {
        WebElement drop = driver.findElement(dropdown);
        drop.findElement(lowToHigh).click();
    }

}

