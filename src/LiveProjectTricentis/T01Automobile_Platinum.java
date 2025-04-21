package LiveProjectTricentis;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class T01Automobile_Platinum {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sampleapp.tricentis.com/101/#");
		
		driver.findElement(By.id("nav_automobile")).click();
		
		//Enter Vehicle Data
		
		Select make = new Select(driver.findElement(By.id("make")));
		make.selectByVisibleText("Nissan");
		
		driver.findElement(By.id("engineperformance")).sendKeys("1000");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("02/01/2025");
		
		Select seats = new Select(driver.findElement(By.id("numberofseats")));
		seats.selectByVisibleText("2");
		
		Select fuel = new Select(driver.findElement(By.id("fuel")));
		fuel.selectByVisibleText("Petrol");
		
		driver.findElement(By.id("listprice")).sendKeys("1000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("UP16DH0637");
		driver.findElement(By.id("annualmileage")).sendKeys("1000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Enter Insurant Data
		
		driver.findElement(By.id("firstname")).sendKeys("Rashmi");
		driver.findElement(By.id("lastname")).sendKeys("Kujur");
		driver.findElement(By.id("birthdate")).sendKeys("07/31/1991");
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[2]/span")).click();
		
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");
		
		driver.findElement(By.id("zipcode")).sendKeys("201304");
		driver.findElement(By.id("city")).sendKeys("Noida");
		
		Select occupation = new Select(driver.findElement(By.id("occupation")));
		occupation.selectByVisibleText("Selfemployed");
		
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span")).click();
		driver.findElement(By.id("nextenterproductdata")).click();
		
		//Enter Product Data
		
		driver.findElement(By.id("startdate")).sendKeys("03/03/2025");
		
		Select sum = new Select(driver.findElement(By.id("insurancesum")));
		sum.selectByVisibleText("3.000.000,00");
		
		Select merit = new Select(driver.findElement(By.id("meritrating")));
		merit.selectByVisibleText("Bonus 4");
		
		Select damage = new Select(driver.findElement(By.id("damageinsurance")));
		damage.selectByVisibleText("No Coverage");
		
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")).click();
		
		Select courtesy = new Select(driver.findElement(By.id("courtesycar")));
		courtesy.selectByVisibleText("No");
		
		driver.findElement(By.id("nextselectpriceoption")).click();
		
		//Select Price Option
		
		String expPrice = "1,351.00", expClaim = "Submit", expDis = "5", expCover = "Limited", actPrice, actClaim, actDis, actCover;
		
		actPrice = driver.findElement(By.id("selectplatinum_price")).getText();
		actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[4]")).getText();
		actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[4]")).getText();
		actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[4]")).getText();
		
		System.out.println("Checking Automobile - Platinum Values");
		if(actPrice.equals(expPrice))
			System.out.println("Price Matching");
		else
			System.out.println("Price Not Matching");
		
		if(actClaim.equals(expClaim))
			System.out.println("Online Claim Matching");
		else
			System.out.println("Online Claim Not Matching");
		
		if(actDis.equals(expDis))
			System.out.println("Discount Matching");
		else
			System.out.println("Discount Not Matching");
		
		if(actCover.equals(expCover))
			System.out.println("Worldwide Cover Matching");
		else
			System.out.println("Worldwide Cover Not Matching");
		
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span")).click();
		driver.findElement(By.id("nextsendquote")).click();
		
		//Send Quote
		
		driver.findElement(By.id("email")).sendKeys("rashmi@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9717272134");
		driver.findElement(By.id("username")).sendKeys("Rashmi");
		driver.findElement(By.id("password")).sendKeys("Pass@123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Pass@123");
		driver.findElement(By.id("Comments")).sendKeys("No Comments");
		driver.findElement(By.id("sendemail")).click();
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[4]/h2")).getText());
		
		driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"backmain\"]/span/i")).click();


	}

}
