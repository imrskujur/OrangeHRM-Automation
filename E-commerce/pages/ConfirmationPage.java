package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConfirmationPage {
    WebDriver driver;

    By confirmationText = By.cssSelector(".sweet-alert > h2");
    By okButton = By.xpath("//button[text()='OK']");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationText).getText();
    }

    public void closeConfirmation() {
        driver.findElement(okButton).click();
    }
}
