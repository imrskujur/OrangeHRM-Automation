package WebDriverAssignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class A05Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");
		
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot, new File("screenshot.jpeg"));
		System.out.println("Screenshot captured!!!");
		
		File file = new File("screenshot.jpeg");
		
		if(file.exists())
			System.out.println("File Created!!!");
		else
			System.out.println("File not created!!!");
		
		driver.close();
	}
}

