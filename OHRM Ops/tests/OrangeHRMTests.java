package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.AdminPage;

import java.time.Duration;

public class OrangeHRMTests {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.login("Admin", "admin123");
    }

    @Test(priority = 2)
    public void testGetMenuOptionsAndClickAdmin() {
        int count = adminPage.getMenuOptionsCount();
        System.out.println("Total menu options: " + count);
        assert count == 12 : "Menu options count mismatch!";
        adminPage.clickAdminMenu();
    }

    @Test(priority = 3)
    public void testSearchByUsername() throws InterruptedException {
        adminPage.searchByUsername("Admin");
        int resultCount = adminPage.getSearchResultCount();
        System.out.println("Total records found by Username: " + resultCount);
        adminPage.refreshPage();
    }

    @Test(priority = 4)
    public void testSearchByUserRole() throws InterruptedException {
        adminPage.searchByUserRole("Admin");
        int resultCount = adminPage.getSearchResultCount();
        System.out.println("Total records found by User Role: " + resultCount);
        adminPage.refreshPage();
    }

    @Test(priority = 5)
    public void testSearchByUserStatus() throws InterruptedException {
        adminPage.searchByUserStatus("Enabled");
        int resultCount = adminPage.getSearchResultCount();
        System.out.println("Total records found by Status: " + resultCount);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}