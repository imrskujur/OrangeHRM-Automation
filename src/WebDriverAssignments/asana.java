package WebDriverAssignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class asana {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://asana.com/");
		Thread.sleep(10000);
JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Alert alt;
		
		//driver.findElement(By.id("alertButton")).click();
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/span/div/div[2]/div[4]/div/div/div/div[2]/button[2]")));
		alt = driver.switchTo().alert();
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/div/div[3]/button/svg/use")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/header/nav/div/div[2]/div/div[1]/a[2]/span[1]")).click();

	}

}
