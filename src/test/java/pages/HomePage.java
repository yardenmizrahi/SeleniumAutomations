package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By itemInHome = By.xpath("//*[@id=\"post-2888\"]/div/div/section[3]/div/div/div/div[3]/div/div/div/ul/li[1]/div[2]/a/h2");

    public void ClickOnItemAtHomePage() {
        driver.findElement(itemInHome).click();
    }
}
