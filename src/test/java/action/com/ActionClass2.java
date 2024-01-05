package action.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass2 {

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
		driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
		
		Actions actions = new Actions(driver);
		
		waitForSeconds(3);
		WebElement doubleClickElement = driver.findElement(By.xpath("//button[text()='Double-Click me to see Alert message']"));
		actions.doubleClick(doubleClickElement).build().perform();
		waitForSeconds(3);
	
		driver.switchTo().alert().accept();
			
		driver.get("https://selenium08.blogspot.com/2019/12/right-click.html");
		waitForSeconds(4);
		
		WebElement rightClickElement = driver.findElement(By.xpath("//div[contains(text(),'Context / Right click for Menu')]"));
		actions.contextClick(rightClickElement).build().perform();
		
		waitForSeconds(6);
		driver.quit();
	}

}
