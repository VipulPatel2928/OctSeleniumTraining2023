package findElementAndElements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementAndElementsException {



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
		waitForSeconds(1);
		
		WebElement usernamElement = driver.findElement(By.id("email"));
		usernamElement.sendKeys("Java and Selenium");
		
		waitForSeconds(3);		
		usernamElement.clear();
	
		List<WebElement> textfields = driver.findElements(By.xpath("//input123"));
		
		System.out.println("Total Elements with this locator : "+textfields.size());
		//textfields.get(2).sendKeys("Used FindElements user name");
		
		waitForSeconds(3);	
		driver.quit();
	}
}
