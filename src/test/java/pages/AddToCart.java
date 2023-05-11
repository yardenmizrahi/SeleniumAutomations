package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {

    WebDriver driver;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    By addToCart = By.name("add-to-cart");
    By addToCartLocation = By.xpath("//*[@id=\"product-361\"]/div[2]/p[2]");
    public void clickAddToCartBtn() {
        driver.findElement(addToCart).click();
    }

    public void tryToFindAddToCartBtn() {
        driver.findElement(addToCartLocation);
    }
}
