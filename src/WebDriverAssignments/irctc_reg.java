package WebDriverAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class irctc_reg {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		
		//Actions act = new Actions(driver);
		driver.findElement(By.id("userName")).sendKeys("imrskujr");
		driver.findElement(By.id("fullName")).sendKeys("Rashmi Kujur");
		driver.findElement(By.id("usrPwd")).sendKeys("idx611@123");
		driver.findElement(By.id("cnfUsrPwd")).sendKeys("idx611@123");
		driver.findElement(By.id("email")).sendKeys("imrskujr@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("8130108983");
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-signup/div/div/form/div/div[2]/div/div[2]/div[10]/div/button")).click();
		
	}

}
