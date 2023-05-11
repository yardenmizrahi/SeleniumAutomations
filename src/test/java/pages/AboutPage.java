package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {
    WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }
    By about = By.id("menu-item-828");
    By homeInAbout = By.id("menu-item-423");
    By womenInAbout = By.id("menu-item-665");
    By menInAbout = By.id("menu-item-663");

    public void clickAboutBtn() {
        driver.findElement(about).click();
    }
    public void clickHomeBtn() {
        driver.findElement(homeInAbout).click();
    }
    public void clickWomenBtn() {
        driver.findElement(womenInAbout).click();
    }
    public void clickMenBtn() {
        driver.findElement(menInAbout).click();
    }
}
