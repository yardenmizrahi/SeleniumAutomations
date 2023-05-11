package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MenPage {
    WebDriver driver;

    public MenPage(WebDriver driver) {
        this.driver = driver;
    }
    By menBtn = By.id("menu-item-266");
    By itemInMen = By.xpath("//*[@id=\"main\"]/div/ul/li[1]/div[1]/a/img");

    public void ClickOnMenPage() {
        driver.findElement(menBtn).click();
    }
    public void ClickOnIemInMenPage() {
        driver.findElement(itemInMen).click();
    }
}