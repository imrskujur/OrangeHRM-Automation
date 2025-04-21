package WebDriverAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RadioButton {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://echoecho.com/htmlforms10.htm");
		
		WebElement milk = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[1]"));
		WebElement butter = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[2]"));
		WebElement cheese = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[3]"));
		WebElement water = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[4]"));
		WebElement beer = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[5]"));
		WebElement wine = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[6]"));
		
		
		System.out.println("Before clicking");
		System.out.println("Visible: " + milk.isSelected());
		System.out.println("Visible: " + butter.isSelected());
		System.out.println("Visible: " + cheese.isSelected());
		System.out.println("Visible: " + water.isSelected());
		System.out.println("Visible: " + beer.isSelected());
		System.out.println("Visible: " + wine.isSelected());
		
		milk.click();
		butter.click();
		cheese.click();
		water.click();
		beer.click();
		wine.click();
		
		System.out.println("After clicking");
		System.out.println("Visible: " + milk.isSelected());
		System.out.println("Visible: " + butter.isSelected());
		System.out.println("Visible: " + cheese.isSelected());
		System.out.println("Visible: " + water.isSelected());
		System.out.println("Visible: " + beer.isSelected());
		System.out.println("Visible: " + wine.isSelected());
		

	}

}
