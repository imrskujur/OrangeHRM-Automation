package com.TestNGDemos;

import com.aventstack.extentreports.*;
import java.io.File;
import java.nio.file.Files;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.poi.xssf.usermodel.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.io.*;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OHRMLogin {

    String fPath = "ExcelFiles\\LoginData.xlsx";
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    int rows, i, j;

    WebDriver driver;

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void beforeTest() throws IOException {
        // Excel setup
        file = new File(fPath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);

        // Create ExtentReport folder
        new File("ExtentReport").mkdirs(); // Ensures folder exists

        // Extent Report setup
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/OHRM_Login_Report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // WebDriver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(dataProvider = "getLoginData")
    public void loginToOHROM(String un, String ps) {
        test = extent.createTest("Login Test - Username: " + un + ", Password: " + ps);
        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            Thread.sleep(3000);

            if (driver.getCurrentUrl().contains("dashboard")) {
                String screenshotPath = captureScreenshot(un);
                test.pass("Login successful").addScreenCaptureFromPath(screenshotPath);
                System.out.println("Test case pass");

                // Logout
                driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
                driver.findElement(By.linkText("Logout")).click();
                test.info("Logout successful");

            } else {
                String screenshotPath = captureScreenshot(un);
                test.fail("Login failed").addScreenCaptureFromPath(screenshotPath);
                System.out.println("Test case fail");
            }

        } catch (Exception e) {
            String errorScreenshot = captureScreenshot("error_" + un);
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(errorScreenshot);
            e.printStackTrace();
        }
    }
    
    @DataProvider
    public Object[][] getLoginData() {
        rows = sheet.getPhysicalNumberOfRows();
        String[][] loginData = new String[rows - 1][2];

        for (i = 0; i < rows - 1; i++) {
            row = sheet.getRow(i + 1);
            for (j = 0; j < 2; j++) {
                cell = row.getCell(j);
                loginData[i][j] = cell.getStringCellValue();
            }
        }
        return loginData;
    }

    public String captureScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String folderPath = "Screenshots";
            String fullPath = folderPath + File.separator + name + "_" + timestamp + ".png";

            File dest = new File(fullPath);
            new File(folderPath).mkdirs(); // Ensure the Screenshots folder exists

            Files.copy(src.toPath(), dest.toPath());

            return fullPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @AfterTest
    public void afterTest() throws IOException {
        wb.close();
        fis.close();
        driver.quit();
        extent.flush();
    }
}