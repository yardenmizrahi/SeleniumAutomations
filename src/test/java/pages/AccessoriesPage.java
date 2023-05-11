package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AccessoriesPage {
    WebDriver driver;

    public AccessoriesPage(WebDriver driver) {
        this.driver = driver;
    }
    By acsBtn = By.id("menu-item-671");
    By itemInAcs = By.xpath("//*[@id=\"main\"]/div/ul/li[4]/div[2]/a/h2");

    public void ClickOnAccessoriesPage() {
        driver.findElement(acsBtn).click();
    }
    public void ClickOnIemInAccessoriesPage() {
        driver.findElement(itemInAcs).click();
    }
}