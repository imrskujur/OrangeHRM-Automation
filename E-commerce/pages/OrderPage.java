package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class OrderPage {
    WebDriver driver;

    By name = By.id("name");
    By card = By.id("card");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fillDetailsAndSubmit(String customerName, String creditCard) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(name));

        driver.findElement(name).sendKeys(customerName);
        driver.findElement(card).sendKeys(creditCard);
        driver.findElement(purchaseBtn).click();
    }
}