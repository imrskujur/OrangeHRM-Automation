package WebDriverAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ClassName {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement userName = driver.findElement(By.className("inputtext _55r1 inputtext _1kbt inputtext _1kbt"));
		userName.sendKeys("rashbaby11@yahoo.com");
		
		WebElement password = driver.findElement(By.className("inputtext _55r1 inputtext _9npi inputtext _9npi"));
		password.sendKeys("Apple.123");
		
		WebElement loginbtn = driver.findElement(By.className("_42ft _4jy0 _52e0 _4jy6 _4jy1 selected _51sy"));
		loginbtn.click();

	}

}
