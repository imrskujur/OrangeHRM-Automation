package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    By samsungPhone = By.linkText("Samsung galaxy s6");
    By laptopsCategory = By.linkText("Laptops");
    By monitorsCategory = By.linkText("Monitors");
    
    By macbookLaptop = By.linkText("MacBook air");       
    By monitor = By.linkText("Apple monitor 24");        
    
    By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void selectSamsungPhone() {
        driver.findElement(samsungPhone).click();
    }
    
    public void selectMacbookLaptop() throws InterruptedException {
    	
    	driver.findElement(laptopsCategory).click();
    	Thread.sleep(2000);
        driver.findElement(macbookLaptop).click();
    }

    public void selectMonitor() throws InterruptedException {
    	
    	driver.findElement(monitorsCategory).click();
    	Thread.sleep(2000);
        driver.findElement(monitor).click();
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(1000); // Wait for page load
        driver.findElement(addToCartButton).click();
        Thread.sleep(2000); // Handle alert
        driver.switchTo().alert().accept();
    }
}