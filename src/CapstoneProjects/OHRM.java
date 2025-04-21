package CapstoneProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class OHRM {

	public static void main(String[] args) {
		
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://sampleapp.tricentis.com/101/#");
			
			driver.findElement(By.id("nav_truck")).click();
			
			//Enter Vehicle Data
			
			Select make = new Select(driver.findElement(By.id("make")));
			make.selectByVisibleText("Nissan");
			
			driver.findElement(By.id("engineperformance")).sendKeys("1000");
			driver.findElement(By.id("dateofmanufacture")).sendKeys("02/01/2025");

	}

}
