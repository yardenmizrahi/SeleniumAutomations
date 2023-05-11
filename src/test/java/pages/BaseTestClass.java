package pages;

import automationTests.addToCart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseTestClass {

    public static WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yarde\\OneDrive - Afeka College Of Engineering\\myChrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
