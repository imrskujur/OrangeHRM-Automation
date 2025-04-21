package WebDriverAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorById {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		WebElement userName = driver.findElement(By.id("txtCustomerID"));
		userName.sendKeys("Rashmi");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Rashmi_123");
		
		WebElement loginbtn = driver.findElement(By.id("Butsub"));
		loginbtn.click();

	}

}
