package waits.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitClass {
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
	
	public static void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public static void enterDataTofield(WebElement ele, String value) {
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}
	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		waitForSeconds(1);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement loginElement = driver.findElement(By.name("login"));
		
		long start = System.currentTimeMillis();
		
		try {
		wait.until(ExpectedConditions.textToBePresentInElement(loginElement, "Login"));
		}
		catch(Exception e) {
			System.out.println("<---------- Exception Generated ---------->");
		}
		
        long end = System.currentTimeMillis();
		
		long totalWaitTime = end - start;
		
		System.out.println("Total Waiting Time : "+totalWaitTime);
		
		WebElement createNewAccountElement = driver.findElement(By.xpath("//a[text()='Create new account']"));
		clickOnElement(createNewAccountElement);
		
		WebElement firstNamElement = driver.findElement(By.name("firstname"));
		enterDataTofield(firstNamElement, "Vipul");
		//loginElement.click();
		
		
		
		waitForSeconds(5);
		driver.quit();
	}

}
