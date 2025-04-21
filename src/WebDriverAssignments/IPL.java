package WebDriverAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class IPL {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.iplt20.com/points-table/men/2024");
		
		List<WebElement>Teams = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr/td[3]/div/h2"));
		
		for(WebElement T : Teams) {
			System.out.print(T.getText() + " ");
		List<WebElement>Result = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr[1]/td[12]/div/span"));
		for(WebElement R : Result) {
			System.out.print(R.getText());
		}
		
		if
		    System.out.println();
		
		
		}
		

	}

}
