package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeTestUtilityClass {
	WebDriver driver;
	JavascriptExecutor js;
	//PageFactory
	@FindBy (name="username") WebElement userName;
	@FindBy (name="password") WebElement passWord;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement loginBtn;
	
	public PracticeTestUtilityClass(WebDriver d)
	{
		driver = d;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		userName.sendKeys(un);
	}
	public void setPassword(String ps)
	{
		passWord.sendKeys(ps);
	}
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}

	public void logout()
	{
		if(driver.getCurrentUrl().contains("dashboard")) {
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
		else
		{
			System.out.println("Invalid user name/password");
		}
	}
}