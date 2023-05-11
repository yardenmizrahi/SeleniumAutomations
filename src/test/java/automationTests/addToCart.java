package automationTests;

import freemarker.template.TemplateException;
import io.github.sridharbandi.HtmlCsRunner;
import io.github.sridharbandi.a11y.HTMLCS;
import org.apache.logging.log4j.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.NoSuchElementException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pages.*;

import static org.junit.Assert.assertEquals;


public class addToCart {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private Logger logger;
    private JSONArray values;
    private BaseTestClass baseTestClass;
    private static HtmlCsRunner htmlCsRunner;

    @Before
    public void setUp() throws IOException {
        driver = baseTestClass.initializeDriver();
        htmlCsRunner = new HtmlCsRunner(driver);
        htmlCsRunner.setStandard(HTMLCS.WCAG2A);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        logger = LogManager.getLogger(addToCart.class);
        logger.info("opening webiste");
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader;
            reader = new FileReader("quantity.json");
            //Read JSON file
            values = (JSONArray)jsonParser.parse(reader);

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

    }
    @After
    public void tearDown() throws TemplateException, IOException, URISyntaxException {
        htmlCsRunner.execute();
        // driver.quit();
        htmlCsRunner.generateHtmlReport();
    }


    public void checkProductAddedToCart(String productnName) {
        logger.debug("check product added to cart");
        driver.get("https://atid.store/");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCart();
        String productInCart = cartPage.getProductInCart();
        assertEquals(productnName, productInCart);
        logger.debug("test pass");
    }

    @Test
    public void addWhenProductExistsInInventory() {
        // Test: add item to cart when product exists in inventory
        // Step # | name | target | value

        driver.get("https://atid.store/");                                              // 1 | open | / |
        driver.manage().window().setSize(new Dimension(1052, 666));         // 2 | setWindowSize | 1052x666 |
        StorePage storePage = new StorePage(driver);
        storePage.clickStoreBtn();                             // enter the store
        logger.debug("go to store");
        ProductPage product = new ProductPage(driver);
        product.clickProductBtn(); // go to product
        logger.debug("click on product");
        AddToCart addToCart = new AddToCart(driver);
        addToCart.clickAddToCartBtn(); // add product to cart
        logger.debug("add product to cart");
        String productName = product.getProductName(); //get product name
        logger.debug("get product name");
        checkProductAddedToCart(productName); // check correct name
    }

    @Test
    public void addWhenProductDoesNotExistsInInventory() {
        // Test: do not add item to cart when product does not exist in inventory
        // Step # | name | target | value
        boolean flag = false;

        driver.get("https://atid.store/");                                              // 1 | open | / |
        driver.manage().window().setSize(new Dimension(1052, 666));         // 2 | setWindowSize | 1052x666 |
        StorePage storePage = new StorePage(driver);
        storePage.clickStoreBtn();         // enter the store
        logger.debug("go to store");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOuOfStockProductBtn(); // go to out-of-stock product
        try {
            logger.debug("go to out-of-stock product");
            AddToCart addToCart = new AddToCart(driver);
            addToCart.tryToFindAddToCartBtn();
        } catch (NoSuchElementException e) {
            fail();
            logger.debug("test fail");
        }
        logger.debug("test pass");
    }

    @Test
    public void addWhenProductAlreadyExistsInCart() {
        // Test: add item to cart when product already exists in cart
        // Step # | name | target | value

        driver.get("https://atid.store/");
        // 1 | open | / |
        driver.manage().window().setSize(new Dimension(1052, 666));
        // 2 | setWindowSize | 1052x666 |
        for (int i = 0; i < values.size(); i++) {
            JSONObject obj = (JSONObject) values.get(i);
            logger.debug("go to store");
            StorePage storePage = new StorePage(driver);
            storePage.clickStoreBtn();         // enter the store
            logger.debug("go to product");
            ProductPage product = new ProductPage(driver);
            product.clickProductBtn(); // go to product
            logger.debug("add product to cart twice");
            AddToCart addToCart = new AddToCart(driver);
            addToCart.clickAddToCartBtn(); // add product to cart
            addToCart.clickAddToCartBtn(); // add product to cart again
            logger.debug("go to cart");
            CartPage cartPage = new CartPage(driver);
            cartPage.clickOnCart(); //go to cart
            logger.debug("Get the value of the quantity element");
            WebElement quantityElement = cartPage.getQuantityOfTheSameProductInCart();
            // Get the value of the quantity element
            String quantityValue = quantityElement.getAttribute((String)obj.get("field"));
            assertEquals((String)obj.get("quantity"), quantityValue);
            logger.debug("test pass");
        }
    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(addToCart.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }



}
