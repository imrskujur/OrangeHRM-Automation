package tests;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.*;
import utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.UUID;

public class EndToEndTest {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    String baseUrl = "https://demoblaze.com/";
    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {
    	System.out.println("Running on Browser: " + browser);
    	
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        
        browserName = browser;
        extent = ExtentManager.getInstance();
    }

    @Test
    public void completeFlowTest() throws Exception {
    	test = extent.createTest("Complete E2E Ecommerce Flow Test on " + browserName);

        driver.get(baseUrl);
        driver.manage().window().maximize();

      
        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        OrderPage order = new OrderPage(driver);
        ConfirmationPage confirm = new ConfirmationPage(driver);

        String user = "user" + UUID.randomUUID().toString().substring(0, 5);
        String pass = "password123";

        // Register
        home.clickSignup();
        Thread.sleep(1000);
        register.register(user, pass);
        ScreenshotUtil.takeScreenshot(driver, "registration");

        // Login
        home.clickLogin();
        Thread.sleep(1000);
        login.login(user, pass);
        ScreenshotUtil.takeScreenshot(driver, "login");

     // Home Page
        test.info("Landing on homepage...");
        ScreenshotUtil.takeScreenshot(driver, "home");
        assert home.isFeaturedVisible();
        home.selectPhonesCategory();

     // Browse Phones Category
        home.selectPhonesCategory();
        test.info("Browsing Phones category...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "phones-category");

        product.selectSamsungPhone();
        test.info("Selecting Samsung Galaxy S6...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "samsung-detail");
       
     // Add to cart and return home
        product.addToCart();
        ScreenshotUtil.takeScreenshot(driver, "samsung-added");
        home.clickHome(); 
        

         //Browse Laptops Category
        home.selectLaptopsCategory();
        test.info("Browsing Laptops category...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "laptops-category");

        product.selectMacbookLaptop();
        test.info("Selecting Macbook Air...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "macbook-detail");


     // Add to cart and return home
        product.addToCart();
        ScreenshotUtil.takeScreenshot(driver, "macbook-added");
        home.clickHome(); 
        
        Thread.sleep(2000);

        // Browse Monitors Category
        home.selectMonitorsCategory();
        test.info("Browsing Monitors category...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "monitors-category");

        product.selectMonitor();
        test.info("Selecting Apple Monitor 24...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "monitor-detail");

     // Add to cart and return home
        product.addToCart();
        ScreenshotUtil.takeScreenshot(driver, "monitor-added");
        home.clickHome(); 
        
     // Cart & Checkout
        cart.goToCart();
        test.info("Viewing cart...");
        Thread.sleep(1000);
        ScreenshotUtil.takeScreenshot(driver, "cart");
        cart.proceedToCheckout();
        test.info("Proceeding to checkout...");
        ScreenshotUtil.takeScreenshot(driver, "checkout");
        
     // Order Details
        order.fillDetailsAndSubmit("Test User", "1234 5678 9012 3456");
        ScreenshotUtil.takeScreenshot(driver, "order-submitted");
        
     // Confirmation
        Thread.sleep(1000);
        String confirmation = confirm.getConfirmationText();
        test.info("Order Confirmation: " + confirmation);
        ScreenshotUtil.takeScreenshot(driver, "order-confirmation");
        confirm.closeConfirmation();

        // Save Confirmation as PDF
        PDFUtil.saveOrderConfirmation(confirmation);
        

        test.pass("E-commerce flow completed successfully.");
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}