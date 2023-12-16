package waits.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitClass {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
	
		WebElement createNewAccountElement = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createNewAccountElement.click();
		
		driver.findElement(By.name("firstname")).sendKeys("Abhishek");
		long start = System.currentTimeMillis();
		try {
		WebElement lastname = driver.findElement(By.name("lastname"));
		}
		catch(Exception e) {
		System.out.println("<---------- Exception Generated ---------->");
		}
		long end = System.currentTimeMillis();
		
		long totalWaitTime = end - start;
		
		System.out.println("Total Waiting Time : "+totalWaitTime);
		
		waitForSeconds(3);
		
		driver.quit();
	}

}
