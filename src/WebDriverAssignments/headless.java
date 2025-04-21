package WebDriverAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headless {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless");
		//op.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://dash.bling-center.com/platform/signIn.html");
		
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[2]/div/div/div[5]/button")).click();
		driver.findElement(By.id("email1")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[2]/button[2]")).click();
		Thread.sleep(2000);
		System.out.println("Message: " + driver.findElement(By.id("resetsuccess")).getText());
		
		driver.close();


	}

}
