package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    WebDriver driver;

    By signupUsername = By.id("sign-username");
    By signupPassword = By.id("sign-password");
    By signupButton = By.xpath("//button[text()='Sign up']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void register(String username, String password) throws InterruptedException {
    	waitForElementToBeVisible(signupUsername);
        driver.findElement(signupUsername).sendKeys(username);
        driver.findElement(signupPassword).sendKeys(password);
        driver.findElement(signupButton).click();
        Thread.sleep(2000); // Handle alert
        driver.switchTo().alert().accept();
    }
}