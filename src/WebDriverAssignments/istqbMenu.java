package WebDriverAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class istqbMenu {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://istqb.in/");
		
		/*Actions act = new Actions(driver);
		WebElement spMenu = driver.findElement(By.linkText("SPECIALIST"));
		act.moveToElement(spMenu).perform();
		
	    List<WebElement> subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[7]/div/div/ul/li/a"));
	   
	    for(WebElement s : subMenus)
	    System.out.println(s.getText());*/
	    
	    List<WebElement> Menu = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li"));
	    for(WebElement m : Menu) 
	    System.out.println(m.getText());
	    
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 400)", "");
		

	}

}
