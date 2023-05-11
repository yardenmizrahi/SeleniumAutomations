package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class WomenPage {
    WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }
    By womenBtn = By.id("menu-item-267");
    By itemInWomen = By.xpath("//*[@id=\"main\"]/div/ul/li[5]/div[1]/a/img");

    public void ClickOnWomenPage() {
        driver.findElement(womenBtn).click();
    }
    public void ClickOnIemInWomenPage() {
        driver.findElement(itemInWomen).click();
    }
}