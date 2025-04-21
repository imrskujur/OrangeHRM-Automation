package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class D18HandlingRadioButton {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement gnFemale = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]"));
		
		System.out.println("Before clicking");
		System.out.println("Selected: " + gnFemale.isSelected());
		System.out.println("Enabled: " + gnFemale.isEnabled());
		System.out.println("Visible: " + gnFemale.isDisplayed());
		
		gnFemale.click();
		
		System.out.println("After clicking");
		System.out.println("Selected: " + gnFemale.isSelected());
		System.out.println("Enabled: " + gnFemale.isEnabled());
		System.out.println("Visible: " + gnFemale.isDisplayed());
		

	}

}
