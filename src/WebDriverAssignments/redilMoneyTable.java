package WebDriverAssignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class redilMoneyTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		List<WebElement>headers = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		for(WebElement h : headers)
			System.out.println(h.getText());
		
		List<WebElement>rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		System.out.println("number of rows:" + rows.size());
		
		    Random rnd = new Random();
			int i = rnd.nextInt(rows.size());
			
			System.out.println(rows.get(i).getText());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[" + (i+1) + "]")).getText());
			
			List<WebElement>company = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
			for(WebElement c : company)
			System.out.println(c.getText());
				
				List<WebElement>currentPriceList = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
				double[]cpArray = new double[currentPriceList.size()];
				
				for(int a = 0; a < cpArray.length; a++)
				{
					cpArray[a] = Double.parseDouble(currentPriceList.get(a).getText().replace(",", ""));
				}
				
				Arrays.sort(cpArray);
				System.out.println("Heighest Price: " + cpArray[cpArray.length-1]);
			
			
		
		driver.close();
		

	}

}
