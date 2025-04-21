package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class D10PracticeTest_Client {
	WebDriver driver;
	PracticeTestUtilityClass p1;
	@Test
	public void loginLogout() {
		p1.setUserName("Admin");
		p1.setPassword("admin123");
		p1.clickOnLoginBtn();
		p1.logout();
				
	}

	@BeforeTest
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		p1 = new PracticeTestUtilityClass(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
