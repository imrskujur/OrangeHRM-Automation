package WebDriverAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Checkbox {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://echoecho.com/htmlforms09.htm");
		
		WebElement milk = driver.findElement(By.cssSelector("input[name^=\"option1\"]"));
		
		System.out.println("Before clicking");
		System.out.println("Milk Checkbox Selected: " + milk.isSelected());
		System.out.println("Milk Checkbox Enabled: " + milk.isEnabled());
		System.out.println("Milk Checkbox Visible: " + milk.isDisplayed());

		if(milk.isSelected() == false)
			milk.click();
		
		System.out.println("\nAfter Clicking");
		System.out.println("Milk Checkbox Selected: " + milk.isSelected());
		System.out.println("Milk Checkbox Enabled: " + milk.isEnabled());
		System.out.println("Milk Checkbox Visible: " + milk.isDisplayed());
		
		WebElement butter = driver.findElement(By.cssSelector("input[name^=\"option2\"]"));
		
		System.out.println("Before clicking");
		System.out.println("butter Checkbox Selected: " + butter.isSelected());
		System.out.println("butter Checkbox Enabled: " + butter.isEnabled());
		System.out.println("butter Checkbox Visible: " + butter.isDisplayed());

		if(butter.isSelected() == false)
			butter.click();
		
		System.out.println("\nAfter Clicking");
		System.out.println("Butter Checkbox Selected: " + butter.isSelected());
		System.out.println("Butter Checkbox Enabled: " + butter.isEnabled());
		System.out.println("Butter Checkbox Visible: " + butter.isDisplayed());
		
		WebElement cheese = driver.findElement(By.cssSelector("input[name^=\"option3\"]"));
		
		System.out.println("Before clicking");
		System.out.println("Cheese Checkbox Selected: " + cheese.isSelected());
		System.out.println("Cheese Checkbox Enabled: " + cheese.isEnabled());
		System.out.println("Cheese Checkbox Visible: " + cheese.isDisplayed());

		if(cheese.isSelected() == false)
			cheese.click();
		
		System.out.println("\nAfter Clicking");
		System.out.println("Cheese Checkbox Selected: " + cheese.isSelected());
		System.out.println("Cheese Checkbox Enabled: " + cheese.isEnabled());
		System.out.println("Cheese Checkbox Visible: " + cheese.isDisplayed());
		
		List<WebElements> products = driver.findElement(By.cssSelector("input[name^=option]));"
				

	}

}
