package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By clickOnCartPage = By.cssSelector("#ast-site-header-cart > div.ast-site-header-cart-li > a > div > span");
    By clickOnOtherCaryPage = By.xpath("//*[@id=\"main\"]/div/div[1]/div/a");
    By productInCart = By.cssSelector("#post-39 > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-4c824ebb.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-name > a");
    By quantityOfProductInCart = By.xpath("/html/body/div/div[1]/div/div/main/article/div/div/section[2]/div/div/div/div/div/div/div/form/table/tbody/tr[1]/td[5]/div/input");
    By updateCart = By.xpath("/html/body/div/div[1]/div/div/main/article/div/div/section[2]/div/div/div/div/div/div/div/form/table/tbody/tr[2]/td/button");
    By xBtn = By.xpath("/html/body/div/div[1]/div/div/main/article/div/div/section[2]/div/div/div/div/div/div/div/form/table/tbody/tr[1]/td[1]/a");
    public void clickOnCart() {
        driver.findElement(clickOnCartPage).click();
    }
    public void clickOnLowerCart() {
        driver.findElement(clickOnOtherCaryPage).click();
    }

    public String getProductInCart() {
        return driver.findElement(productInCart).getText();
    }

    public WebElement getQuantityOfTheSameProductInCart() {
        WebElement quantityElement = driver.findElement(quantityOfProductInCart);
        return quantityElement;
    }
    public void clickOnUpdateCart() {
        driver.findElement(updateCart).click();
    }
    public void clickOnXBtn() {
        driver.findElement(xBtn).click();
    }


}
