package WebDriverAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Amazon {
	
	WebDriver driver;

	@Test(priority = 1, groups = "Sell")
	public void testSellLink() {
		driver.findElement(By.partialLinkText("Sell")).click();
	}
	@Test(priority = 2, groups = "Sell")
	public void testBestSellerLink() {
		driver.findElement(By.partialLinkText("Best")).click();
	}
	@Test(priority = 3, groups = "Gadgets")
	public void testMobileLink() {
		driver.findElement(By.partialLinkText("Mobile")).click();
	}
	@Test(priority = 4, groups = "Gadgets")
	public void testElectronicsLink() {
		driver.findElement(By.partialLinkText("Electronics")).click();
	}

	@BeforeMethod(alwaysRun = true)
	public void openAmaozn() {
		driver.get("https://www.amazon.in/");
		System.out.println("Title: " + driver.getTitle());
	}

	@AfterMethod(alwaysRun = true)
	public void printTitle() {
		System.out.println("Title: " + driver.getTitle());
	}

	@BeforeTest(alwaysRun = true)
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.close();

	}

}
