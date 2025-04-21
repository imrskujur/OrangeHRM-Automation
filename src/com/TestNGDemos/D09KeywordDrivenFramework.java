package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class D09KeywordDrivenFramework {
	File file;
	FileInputStream fis;
	Properties prop;
	WebDriver driver;
  @Test
  public void createAccount() throws InterruptedException {
	  driver.findElement(By.xpath(prop.getProperty("fullNameXP"))).sendKeys("Rashmi");
	  driver.findElement(By.cssSelector(prop.getProperty("rediffIdCss"))).sendKeys("Rashmi");
	  driver.findElement(By.className(prop.getProperty("checkBtnClass"))).click();
	  
	  Thread.sleep(5000);
	  
	  System.out.println(driver.findElement(By.xpath(prop.getProperty("errMsgXP"))).getText());
	  
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file = new File("src/com/TestNGDemos/RediffSignIn.properties");
	  fis = new FileInputStream(file);
	  prop = new Properties();
	  prop.load(fis);
	  
	  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("URL"));
  }

  @AfterTest
  public void afterTest() {

}
}
