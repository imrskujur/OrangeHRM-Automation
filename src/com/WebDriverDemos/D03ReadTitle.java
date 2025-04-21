package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class D03ReadTitle {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/");
		
		String title = driver.getTitle();
		System.out.println("Title " + title);
		
		if(title.equals("Selenium"))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail");
		
		driver.close();

	}

}

