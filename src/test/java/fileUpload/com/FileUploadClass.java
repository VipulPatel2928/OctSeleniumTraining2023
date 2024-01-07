package fileUpload.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadClass {

	public static ChromeDriver driver;

	public static void waitForSeconds(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This fucntion is used to launch the Chrome Browser
	public static ChromeDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		waitForSeconds(2);

		WebElement upfile = driver.findElement(By.name("upfile"));
		
		upfile.sendKeys("D:\\Users\\User\\eclipse-workspace\\OctSeleniumTraining2023\\Download\\myw3schoolsimage.jpg");
		waitForSeconds(2);
		
		String fileNameString = upfile.getAttribute("value");
		
		System.out.println(fileNameString);
		
		if(fileNameString.contains("myw3schoolsimage.jpg")) {
			System.out.println("file is uploaded");
		}
		else {
			System.out.println("file is not uploaded");
		}
		
		
		waitForSeconds(4);
		
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
