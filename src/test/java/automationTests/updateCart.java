package automationTests;
//Generated by Selenium IDE
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pages.*;

public class updateCart {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private Logger logger;
    private JSONArray numbers;
    private JSONArray zero;
    private BaseTestClass baseTestClass;
    @Before
    public void setUp() throws IOException {
        driver = baseTestClass.initializeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        logger = LogManager.getLogger(updateCart.class);
        logger.info("opening webiste");

        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader;
            reader = new FileReader("updates.json");
            //Read JSON file
            numbers = (JSONArray)jsonParser.parse(reader);

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader;
            reader = new FileReader("updateToZero.json");
            //Read JSON file
            zero = (JSONArray)jsonParser.parse(reader);

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void UpdateFromOneItemToMore() {
        // Test: there is one item in cart and the user update the quantity to be 2
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        for (int i = 0; i < numbers.size(); i++) {
            JSONObject obj = (JSONObject) numbers.get(i);
            //go to store
            logger.debug("go to store");
            StorePage storePage = new StorePage(driver);
            storePage.clickStoreBtn();
            //click on item
            logger.debug("click on item");
            ProductPage productPage = new ProductPage(driver);
            productPage.clickProductBtn2();
            //add the item to cart
            logger.debug("add the item to cart");
            AddToCart addToCart = new AddToCart(driver);
            addToCart.clickAddToCartBtn();
            //go to cart
            logger.debug("go to cart");
            CartPage cartPage = new CartPage(driver);
            cartPage.clickOnCart();
            //go to quantity
            logger.debug("go to quantity");
            WebElement quantityElement = cartPage.getQuantityOfTheSameProductInCart();
            // Get the value of the quantity element
            logger.debug("Get the value of the quantity element");
            quantityElement.clear();
            quantityElement.sendKeys((String)obj.get("updateTo"));
            //update
            logger.debug("update cart");
            cartPage.clickOnUpdateCart();

            //check
            logger.debug("check if succeed");
            String current_amount = cartPage.getQuantityOfTheSameProductInCart().getAttribute("value");
            assertEquals((String)obj.get("updateTo"), current_amount);
            logger.debug("test pass");
        }
    }

    @Test
    public void UpdateFromOneItemToZero() {
        // Test: there is one item in cart and the user update the quantity to be 0
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        for (int i = 0; i < zero.size(); i++) {
            JSONObject obj = (JSONObject) zero.get(i);
            //go to store
            logger.debug("go to store");
            StorePage storePage = new StorePage(driver);
            storePage.clickStoreBtn();
            //click on item
            logger.debug("click on item");
            ProductPage productPage = new ProductPage(driver);
            productPage.clickProductBtn2();
            //add the item to cart
            logger.debug("add the item to cart");
            AddToCart addToCart = new AddToCart(driver);
            addToCart.clickAddToCartBtn();
            //go to cart
            logger.debug("go to cart");
            CartPage cartPage = new CartPage(driver);
            cartPage.clickOnCart();
            //go to quantity
            logger.debug("go to quantity");
            WebElement quantityElement = cartPage.getQuantityOfTheSameProductInCart();
            // Get the value of the quantity element
            logger.debug("Get the value of the quantity element");
            quantityElement.clear();
            quantityElement.sendKeys((String)obj.get("updateTo"));
            //update
            logger.debug("update cart");
            cartPage.clickOnUpdateCart();
            //check for items in the cart
            logger.debug("check for items in the cart");
            List<WebElement> products = productPage.findAllProduct();
            Iterator<WebElement> itr_products = products.iterator();
            int amount_of_products = 0;
            while (itr_products.hasNext()) {
                amount_of_products++;
            }
            assertEquals(Integer.parseInt((String)obj.get("updateTo")), amount_of_products);
            logger.debug("test pass");
        }
    }

    @Test
    public void UpdateByClickingOnX() {
        // Test: there is two items in cart (from the same item) and the user clicks on the X and delete them both
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://atid.store/");
        // 2 | setWindowSize | 1052x666 |
        driver.manage().window().setSize(new Dimension(1052, 666));
        //go to store
        logger.debug("go to store");
        StorePage storePage = new StorePage(driver);
        storePage.clickStoreBtn();
        //click on item
        logger.debug("click on item");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickProductBtn2();
        //add the item to cart twice
        logger.debug("add the item to cart twice");
        AddToCart addToCart = new AddToCart(driver);
        addToCart.clickAddToCartBtn();
        addToCart.clickAddToCartBtn();
        //go to cart
        logger.debug("go to cart");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCart();
        //click on the X
        logger.debug("click on the X button");
        cartPage.clickOnXBtn();;
        //check for items in the cart
        logger.debug("check for items in the cart");
        List<WebElement> products= productPage.findAllProduct();
        Iterator<WebElement> itr_products = products.iterator();
        int amount_of_products = 0;
        while (itr_products.hasNext()) {
            amount_of_products++;
        }
        assertEquals(0, amount_of_products);
        logger.debug("test pass");

    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(updateCart.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);
        }
    }
}