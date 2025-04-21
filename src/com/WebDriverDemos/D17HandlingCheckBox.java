package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class D17HandlingCheckBox {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement altEmail = driver.findElement(By.cssSelector("input[name^=\"chk_altemail\"]"));
		
		System.out.println("Before clivking");
		System.out.println("Checkbox Selected: " + altEmail.isSelected());
		
		if(altEmail.isSelected() == false)
			altEmail.click();
		
		System.out.println("\nAfter Clicking");
		System.out.println("Checkbox Selected: " + altEmail.isSelected());
		

	}


	}


