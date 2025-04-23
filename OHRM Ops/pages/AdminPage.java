package pages;

import org.openqa.selenium.*;
import java.util.List;

public class AdminPage {
    WebDriver driver;

    private By sideMenuOptions = By.cssSelector(".oxd-sidepanel-body ul li");
    private By adminMenu = By.linkText("Admin");

    private By usernameInput = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By userRoleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/i");
    private By userStatusDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i");
    private By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    private By searchResults = By.cssSelector(".orangehrm-container .oxd-table-body div.oxd-table-card");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getMenuOptionsCount() {
        List<WebElement> options = driver.findElements(sideMenuOptions);
        return options.size();
    }

    public void clickAdminMenu() {
        driver.findElement(adminMenu).click();
    }

    public void searchByUsername(String username) throws InterruptedException {
        driver.findElement(usernameInput).sendKeys("Admin");
        Thread.sleep(3000);
        driver.findElement(searchButton).click();
    }

    public void searchByUserRole(String roleText) throws InterruptedException {
        driver.findElement(userRoleDropdown).click();
        WebElement dropdownOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + "Admin" + "']"));
        dropdownOption.click();
        Thread.sleep(3000);
        driver.findElement(searchButton).click();
    }

    public void searchByUserStatus(String statusText) throws InterruptedException {
        driver.findElement(userStatusDropdown).click();
        WebElement dropdownOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + "Enabled" + "']"));
        dropdownOption.click();
        Thread.sleep(3000);
        driver.findElement(searchButton).click();
    }

    public int getSearchResultCount() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
