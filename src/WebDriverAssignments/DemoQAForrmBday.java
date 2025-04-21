package WebDriverAssignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoQAForrmBday {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://web.archive.org/web/20220126121054/https://demoqa.com/automation-practice-form/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		
		driver.findElement(By.id("firstName")).sendKeys("Rashmi");
		driver.findElement(By.id("lastName")).sendKeys("Kujur");
		driver.findElement(By.id("userEmail")).sendKeys("rashmi@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();
		driver.findElement(By.id("userNumber")).sendKeys("9898989898");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "A");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("31 Jul 1991");
		//driver.findElement(By.xpath("//*[@id=\"subjectsWrapper\"]/div[2]")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 200)", "");
		
		driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\\\"subjectsInput\\\"]")).sendKeys("e");
		driver.findElement(By.xpath("//*[@id=\"react-select-2-option-0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();
		js.executeScript("window.scrollBy(0, 400)", "");
		
		driver.findElement(By.xpath("//*[@id=\"state\"]/div[1]/div[2]/div")).click();
		driver.findElement(By.id("react-select-3-option-1")).click();

	}

}
