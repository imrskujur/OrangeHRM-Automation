package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;

    By loginLink = By.id("login2");
    By signupLink = By.id("signin2");
    By logoutLink = By.id("logout2");
//    By cartLink = By.id("cartur");
//    By product = By.linkText("Samsung galaxy s6");
    By featuredSection = By.id("contcar");
    By phonesCategory = By.linkText("Phones");
    By laptopsCategory = By.linkText("Laptops");
    By monitorsCategory = By.linkText("Monitors");
    By homeLink = By.cssSelector("a.navbar-brand");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        
    }
//    public void waitForElementToBeVisible(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    
//    }
    
    

    public void clickSignup() {
        driver.findElement(signupLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }
    
    public boolean isFeaturedVisible() {
        return driver.findElement(featuredSection).isDisplayed();
    }

    public void selectPhonesCategory() {
        driver.findElement(phonesCategory).click();
    }
    
    public void selectLaptopsCategory() {
        driver.findElement(laptopsCategory).click();
    }

    public void selectMonitorsCategory() {
        driver.findElement(monitorsCategory).click();
    }
    
    public void clickHome() {
        waitForElement(homeLink).click();
    }
    
    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//    public void selectProduct() {
//        driver.findElement(product).click();
//    }
//
//    public void goToCart() {
//        driver.findElement(cartLink).click();
//    }
}