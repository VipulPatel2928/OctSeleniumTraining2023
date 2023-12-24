package isdisplayedisEnabledisSelected.com;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodsClass {
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
	      //options.addArguments("headless");
	      //options.addArguments("incognito");
	      options.addArguments("--disable-popup-blocking");
	      options.addArguments("--disable-notifications");
	      
	      options.setExperimentalOption("prefs", prefsMap);
	    
	      driver = new ChromeDriver(options);
	      
	      Capabilities capsCapabilities =((RemoteWebDriver)driver).getCapabilities();
	      
	      String browserNameString = capsCapabilities.getBrowserName();
	      String browserVersionString = capsCapabilities.getBrowserVersion();
	      String oSNameString = capsCapabilities.getPlatformName().name();
	      String osNameString2 = System.getProperty("os.name");
	      System.out.println("Browser Name : "+browserNameString);
	      System.out.println("Browser Version : "+browserVersionString);
	      System.out.println("OS Name : "+oSNameString);
	      System.out.println("OS Name : "+osNameString2);
	      
	      return driver;
	  }
	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://www.facebook.com/");
		waitForSeconds(3);
		WebElement createNewAccountElement = driver.findElement(By.xpath("//a[text()='Create new account']"));
		
        System.out.println(createNewAccountElement.isDisplayed());
        createNewAccountElement.click();
        waitForSeconds(3);
        
        WebElement genderElement = driver.findElement(By.xpath("//label[text()='Female']//..//input"));
        
        System.out.println(genderElement.isSelected());
        System.out.println(genderElement.isEnabled());
        
        System.out.println(genderElement.getAttribute("checked"));
        
        genderElement.click();
        
        System.out.println(genderElement.isSelected());
        System.out.println(genderElement.isEnabled());
        System.out.println(genderElement.getAttribute("checked"));
        waitForSeconds(1);
        
        driver.quit();
	}

}
