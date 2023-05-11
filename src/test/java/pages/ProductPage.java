package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By productBtn = By.cssSelector("a.ast-loop-product__link");
    By productBtn2 = By.xpath("//*[@id=\"main\"]/div/ul/li[2]/div[2]/a/h2");
    By productName = By.cssSelector("h1.product_title.entry-title");
    By outOfStockProductBtn = By.className("ast-shop-product-out-of-stock");
    By firstProduct = By.xpath("//*[@id=\"main\"]/div/ul/li[1]/div[2]/span[2]/ins/span/bdi");
    By productPrices = By.className("woocommerce-Price-amount amount");
    By classNameProducts = By.className("ast-loop-product__link");

    public void clickProductBtn() {
        driver.findElement(productBtn).click();
    }
    public void clickProductBtn2() {
        driver.findElement(productBtn2).click();
    }


    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickOuOfStockProductBtn() {
        driver.findElement(outOfStockProductBtn).click();
    }
    public String clickFirstProduct()
    {
        return driver.findElement(firstProduct).getText();
    }

    public List<WebElement> FindProductsPrices()
    {
        return driver.findElements(productPrices);
    }
    public List<WebElement> findAllProduct() {
        return driver.findElements(classNameProducts);
    }

}
