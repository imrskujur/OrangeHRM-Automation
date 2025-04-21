package WebDriverAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class jotForm {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jotform.com/form-templates/exam-registration-form");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"formPreviewArea\"]")));
		
		driver.findElement(By.id("first_9")).sendKeys("Rashmi");
		driver.findElement(By.id("last_9")).sendKeys("Kujur");
		driver.findElement(By.id("input_10")).sendKeys("123456");
		driver.findElement(By.id("input_3")).sendKeys("automation");
		driver.findElement(By.id("lite_mode_11")).sendKeys("03-04-2025");
		driver.findElement(By.id("lite_mode_12")).sendKeys("03-10-2025");
		driver.findElement(By.id("input_8")).sendKeys("no comments");
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"20866583426562\"]/div/ul")));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 500)", "");
		
		//Thread.sleep(5000);
		
		js.executeScript("arguments[0].click()", driver.findElement(By.id("input_16")));
		

	}

}
