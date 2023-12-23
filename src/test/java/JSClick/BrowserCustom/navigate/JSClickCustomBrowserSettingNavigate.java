package JSClick.BrowserCustom.navigate;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSClickCustomBrowserSettingNavigate {

public static WebDriver driver;
	
	public static void waitForSeconds(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//This fucntion is used to launch the Chrome Browser
	public static WebDriver getChromeDriver() {
	      WebDriverManager.chromedriver().setup();
	      
	      Map<String, Object> prefsMap = new HashMap<String, Object>();
	      prefsMap.put("download.default_directory", "D:\\Users\\User\\eclipse-workspace\\OctSeleniumTraining2023\\Download");
	      
	      ChromeOptions options = new ChromeOptions();
	      
	      options.addArguments("disable-extensions");
	      options.addArguments("--start-maximized");
	      options.addArguments("headless");
	      options.addArguments("incognito");
	      options.addArguments("--disable-popup-blocking");
	      options.addArguments("--disable-notifications");
	      
	      options.setExperimentalOption("prefs", prefsMap);
	    
	      driver = new ChromeDriver(options);
	      return driver;
	  }
	
	
	public static void JSClick(WebDriver driver, WebElement ele, int timeout) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:4px solid green; backgroung:red')", ele);
		jsExecutor.executeScript("arguments[0].click()", ele);
		waitForSeconds(timeout);
	}
	
	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("Open faceboook.com");
		
		WebElement loginBtnElement = driver.findElement(By.name("login"));
		loginBtnElement.click();
		System.out.println("click login");
		waitForSeconds(3);
		
		driver.navigate().back();
		System.out.println("click back, Browser button");
		waitForSeconds(2);
		
		loginBtnElement = driver.findElement(By.name("login"));
	    JSClick(driver, loginBtnElement, 2);	
	    System.out.println("Click login");
	    
	    waitForSeconds(2);
	    driver.navigate().to("https://www.google.com/");
	    System.out.println("Open google.com");
	    waitForSeconds(1);
	    driver.navigate().refresh();
	    waitForSeconds(1);
	    driver.navigate().back();
	    waitForSeconds(1);
	    driver.navigate().forward();
		
		waitForSeconds(3);
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
		waitForSeconds(3);
		
		driver.quit();
	}
}
