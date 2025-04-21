package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class asertionDemo {
	
String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",actUrl;
		WebDriver driver;
		@Test(dataProvider = "getLoginDetails")
		public void loginToOHRM(String un, String ps) {
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			actUrl = driver.getCurrentUrl();
			//Assert.assertEquals(actUrl, expUrl);
			Assert.assertTrue(actUrl.contains("dashboard"), "invalid username/password");
		}
		@DataProvider
		public Object[][] getLoginDetails() {
			return new Object[][] {
				new Object[] { "admin", "admin123" },
				new Object[] { "tajavathi", "tejawathi123" },
				new Object[] { "admin", "admin123" },
				new Object[] { "vinod", "vinod123" },
			};
		}
		
		@AfterMethod
		public void logout() {
			if (driver.getCurrentUrl().contains("dashboard")) {
				System.out.println("Test case pass");
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
				driver.findElement(By.linkText("Logout")).click();
			} 
			else {
				System.out.println("Test case fail");
			}
		}
		@BeforeTest
		public void beforeTest() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}

		@AfterTest
		public void afterTest() {
			driver.close();

	}

}
