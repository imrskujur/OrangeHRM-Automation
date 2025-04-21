package com.WebDriverDemos;

		import java.time.Duration;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;

		public class D23Synchronization_ExplicitWait {

			public static void main(String[] args) {
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();

				driver.get("https://www.redbus.in/");
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				//Source City
				driver.findElement(By.id("src")).sendKeys("Kolh");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text"))).click();
				//driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text")).click();
				
				//Target City
				driver.findElement(By.id("dest")).sendKeys("Nash");
				driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[3]/div[1]/ul/li[1]/div/text")).click();
				
				//Calender
				driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/i")).click();
				driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[6]/span[1]/div[5]/span[1]")).click();
				
				//Search Buses
				driver.findElement(By.id("search_button")).click();
				
				//Display Result
				//System.out.println(driver.findElement(By.xpath("//*[@id=\"8331995\"]/div[1]/div/div[1]/div[1]/div[1]/div[1]")).getText());
				String bus = driver.findElement(By.xpath("/html/body/section/div[2]/div[4]/div/div[2]/div/div[2]/div[2]/div/ul/div[1]/li/div[1]/div/div[1]/div[1]/div[1]/div[1]")).getText();
				System.out.println(bus);
				
				driver.close();
			}

		}

	


