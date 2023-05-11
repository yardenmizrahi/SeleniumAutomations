package automationTests;
//Generated by Selenium IDE
import freemarker.template.TemplateException;
import io.github.sridharbandi.HtmlCsRunner;
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
import pages.AboutPage;
import pages.BaseTestClass;

import java.net.URISyntaxException;
import java.util.*;
import java.io.IOException;

public class linksInAbout {
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
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        logger = LogManager.getLogger(linksInAbout.class);
        logger.info("opening webiste");

    }
    @After
    public void tearDown() throws TemplateException, IOException, URISyntaxException {
        htmlCsRunner.execute();
        // driver.quit();
        htmlCsRunner.generateHtmlReport();
    }

    @Test
    public void quickLinks() {
        // Test: press on Home link under the tab "Quick Links" in the lower menu in About
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        //go to about
        logger.debug("go to about section");

        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.clickAboutBtn();
        //click on Home
        logger.debug("press on Home link under the tab \"Quick Links\" in the lower menu in About");
        aboutPage.clickHomeBtn();
        assertEquals("https://atid.store/", driver.getCurrentUrl());
        logger.debug("test fail");
    }

    @Test
    public void forHer() {
        // Test: press on Women Jeans link under the tab "For Her" in the lower menu in About
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        //go to about
        logger.debug("go to about section");
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.clickAboutBtn();
        //click on women
        logger.debug("press on Women Jeans link under the tab \"For Her\" in the lower menu in About");
        aboutPage.clickWomenBtn();
        assertEquals("https://atid.store/product-category/women/", driver.getCurrentUrl());
        logger.debug("test fail");
    }

    @Test
    public void forHim() {
        // Test: press on Men Jackets link under the tab "For Him" in the lower menu in About
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        //go to about
        logger.debug("go to about section");
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.clickAboutBtn();
        //click on Men Jackets
        logger.debug("press on Men Jackets link under the tab \"For Him\" in the lower menu in About");
        aboutPage.clickMenBtn();
        assertEquals("https://atid.store/product-category/men/", driver.getCurrentUrl());
        logger.debug("test fail");
    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(linksInAbout.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }

}