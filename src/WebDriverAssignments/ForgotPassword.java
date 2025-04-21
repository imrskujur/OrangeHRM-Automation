package WebDriverAssignments;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ForgotPassword {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dash.bling-center.com/platform/signIn.html");
		
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[2]/div/div/div[5]/button/p")).click();
		driver.findElement(By.id("email1")).sendKeys("test@gmail.com");
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[2]/button[2]/p")).click();
		
		Thread.sleep(7000);
		
		System.out.println("the password reset message is:" + driver.findElement(By.id("resetsuccess")).getText());
		

	}

}
