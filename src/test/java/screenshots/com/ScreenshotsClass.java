package screenshots.com;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotsClass {
	public static WebDriver driver;

	public static void waitForSeconds(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This fucntion is used to launch the Chrome Browser
	public static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void takeAScreenshot(WebDriver driver,String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File scorceFile =takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		System.out.println(System.getProperty("user.dir"));
		
		File destinationFile = new File("D:\\Users\\User\\eclipse-workspace\\OctSeleniumTraining2023\\ScreenshotsFolder\\"+fileName);
		try {
			FileUtils.copyFile(scorceFile, destinationFile);
		} catch (IOException e) {
			System.out.println("Failed to copy the screenshot");
			e.printStackTrace();
		}
	}
	
	public static void takeAScreenshotOfElement(WebElement ele,String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) ele;
		File scorceFile =takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		System.out.println(System.getProperty("user.dir"));
		
		File destinationFile = new File("D:\\Users\\User\\eclipse-workspace\\OctSeleniumTraining2023\\ScreenshotsFolder\\"+fileName);
		try {
			FileUtils.copyFile(scorceFile, destinationFile);
		} catch (IOException e) {
			System.out.println("Failed to copy the screenshot");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("URL :"+driver.getCurrentUrl());
		waitForSeconds(3);
		
		if(driver.getCurrentUrl().equals("https://www.facebook.com/")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
			takeAScreenshot(driver, "homepage.png");
		}
		
		
		WebElement createNewAElement = driver.findElement(By.linkText("Create new account"));
		createNewAElement.click();
		System.out.println("Clicked :"+createNewAElement.getText());
		waitForSeconds(3);
		takeAScreenshot(driver, "createNewAccount.png");
		
		driver.navigate().to("https://www.facebook.com/");
		System.out.println("URL :"+driver.getCurrentUrl());
		waitForSeconds(3);
		
		
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement emailElement = driver.findElement(with(By.id("email")).above(pass));
		emailElement.sendKeys("This is email text field");
		System.out.println("Email :"+emailElement.getAttribute("value"));
		waitForSeconds(2);
		takeAScreenshotOfElement(emailElement, "emailTextField.png");
		
		
		WebElement forgotPassElement = driver.findElement(with(By.linkText("Forgotten password?")).below(pass));
		System.out.println("Clicked :"+forgotPassElement.getText());
		forgotPassElement.click();
		waitForSeconds(2);
		
	
		waitForSeconds(2);
		driver.quit();
	}



}
