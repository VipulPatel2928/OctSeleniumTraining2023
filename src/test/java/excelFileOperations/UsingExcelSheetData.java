package excelFileOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingExcelSheetData {


	public static WebDriver driver;
	
	public static void waitForSeconds(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//This fucntion is used to launch the Chrome Browser
	public static WebDriver getChromeDriver() {
	      WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      return driver;
	  }
	
	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://www.facebook.com/");
		
		waitForSeconds(2);
		
		String dataString1 = ExcelFileOperationsClass.readDataFromExcelSheet(0, 1, 0);
		String dataString2 = ExcelFileOperationsClass.readDataFromExcelSheet(0, 2, 0);
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(dataString1);
		
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys(dataString2);
		
		email.clear();
		email.sendKeys("TestDataForEmail");
		waitForSeconds(1);
		ExcelFileOperationsClass.writeInToExcelSheet(0, 0, 0, email.getAttribute("value"));
		
		pass.clear();
		pass.sendKeys("TestDataForpass");
		waitForSeconds(1);
		ExcelFileOperationsClass.writeInToExcelSheet(0, 0, 1, pass.getAttribute("value"));
		
		waitForSeconds(5);
		driver.quit();
	}



}
