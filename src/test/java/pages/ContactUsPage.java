package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    By cuBtn = By.id("menu-item-829");

    public void ClickOnContactUsPage() {
        driver.findElement(cuBtn).click();
    }
}