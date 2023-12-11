package tabandWindows;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes.FaasTriggerValues;

public class TabsAndWindow {



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
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		waitForSeconds(1);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.jiomart.com/");
		
		ArrayList<String> arrayGetHandles = new ArrayList<String>();
		
		Set<String> handles = driver.getWindowHandles();
		int count = 1;
		for(String handle : handles) {
			System.out.println("Handele  : "+count+" : "+handle);
			arrayGetHandles.add(handle);
			driver.switchTo().window(handle);
			waitForSeconds(1);
			count++;
		}
		
		ArrayList<String> arrayListHandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arrayListHandle.get(1));
		waitForSeconds(3);
		driver.switchTo().window(arrayGetHandles.get(0));
		waitForSeconds(3);
		System.out.println("How many windows or Tabs open : "+arrayListHandle.size());
		
		driver.quit();
	}
}
