package WebDriverAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A04RegistrationForm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		
		driver.findElement(By.name("firstname")).sendKeys("Rashmi");
		driver.findElement(By.name("lastname")).sendKeys("Kujur");
		
		WebElement day = driver.findElement(By.name("birthday_day"));
		Select birthday = new Select(day);
		birthday.selectByVisibleText("31");
		
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select birthmonth = new Select(month);
		birthmonth.selectByVisibleText("Jul");
		
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select birthyear = new Select(year);
		birthyear.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("//*[@id=\"sex\"]")).click();
		driver.findElement(By.name("reg_email__")).sendKeys("9198504467");
		driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("apple.123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		
		driver.findElement(By.xpath("//*[@id=\"u_0_n_xX\"]")).click();
		
		//System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());;
		

	}

}
