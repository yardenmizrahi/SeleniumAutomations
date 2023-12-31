package automationTests;

//Generated by Selenium IDE
import freemarker.template.TemplateException;
import io.github.sridharbandi.HtmlCsRunner;
import io.github.sridharbandi.a11y.HTMLCS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;

import java.net.URISyntaxException;
import java.util.*;
import java.io.IOException;

public class switchTopMenu {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private Logger logger;
    private BaseTestClass baseTestClass;
    private static HtmlCsRunner htmlCsRunner;

    @Before
    public void setUp() throws IOException {
        driver = baseTestClass.initializeDriver();
        htmlCsRunner = new HtmlCsRunner(driver);
        htmlCsRunner.setStandard(HTMLCS.WCAG2A);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        logger = LogManager.getLogger(switchTopMenu.class);
        logger.info("opening webiste");

    }
    @After
    public void tearDown() throws TemplateException, IOException, URISyntaxException {
        htmlCsRunner.execute();
        // driver.quit();
        htmlCsRunner.generateHtmlReport();
    }

    @Test
    public void switchFromHomeToWomen() {
        // Test: switch from home to women
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 3 | switch to women section
        logger.debug("switch to women section");
        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnWomenPage();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/product-category/women/");
        logger.debug("test pass");
    }

    @Test
    public void switchFromHomeToAbout() {
        // Test: switch from home to about
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 3 | switch to about section
        logger.debug("switch to about section");
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.clickAboutBtn();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/about/");
        logger.debug("test pass");
    }

    @Test
    public void switchFromHomeToContactUs() {
        // Test: switch from home to contact-us
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 3 | switch to contact-us section
        logger.debug("switch to contact-us section");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.ClickOnContactUsPage();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/contact-us/");
        logger.debug("test pass");
    }

    @Test
    public void switchFromHomeToStore() {
        // Test: switch from home to store
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 3 | switch to store section
        logger.debug("switch to store section");
        StorePage storePage = new StorePage(driver);
        storePage.clickStoreBtn();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/store/");
        logger.debug("test pass");
    }

    @Test
    public void switchFromStoreToStore() {
        // Test: switch from home to store
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 3 | switch to store section
        logger.debug("switch to store section");
        StorePage storePage = new StorePage(driver);
        storePage.clickStoreBtn();
        //go to store
        logger.debug("switch to store section again");
        storePage.clickStoreBtn();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/store/");
        logger.debug("test pass");
    }

    @Test
    public void switchFromWomenToStore() {
        // Test: switch from women to store
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 3 | switch to women section
        logger.debug("switch to women section");
        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnWomenPage();
        //go to store
        logger.debug("switch to store section");
        StorePage storePage = new StorePage(driver);
        storePage.clickStoreBtn();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/store/");
        logger.debug("test pass");
    }

    @Test
    public void switchFromMenToWomen() {
        // Test: switch from men to women
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        //go to men
        logger.debug("switch to men section");
        MenPage menPage = new MenPage(driver);
        menPage.ClickOnMenPage();
        //switch to women section
        logger.debug("switch to women section");
        WomenPage womenPage = new WomenPage(driver);
        womenPage.ClickOnWomenPage();
        assertEquals(driver.getCurrentUrl(), "https://atid.store/product-category/women/");
        logger.debug("test pass");
    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(switchTopMenu.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }
}
