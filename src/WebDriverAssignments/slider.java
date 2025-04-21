package WebDriverAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class slider {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.fitpeo.com/revenue-calculator");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		
		Actions act = new Actions(driver);
		WebElement slider = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div/div/span[1]/span[2]"));
		act.dragAndDropBy(slider, slider.getLocation().x+500, slider.getLocation().y).perform();
		
	   

	}

}
