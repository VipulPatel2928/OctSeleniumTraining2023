package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass {

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
		
		int width= driver.manage().window().getSize().getWidth();
		int height= driver.manage().window().getSize().getHeight();
		
		System.out.println(width);
		System.out.println(height);
		
		Actions actions = new Actions(driver);
		
		actions.keyDown(Keys.SHIFT).sendKeys("Username or email").build().perform();
	
		actions.keyUp(Keys.SHIFT).build().perform();
		//Shift, alt and control
		actions.keyDown(Keys.TAB).build().perform();
		actions.keyUp(Keys.TAB).build().perform();
		
		actions.sendKeys("password").keyDown(Keys.SHIFT).build().perform();
		actions.keyUp(Keys.SHIFT).build().perform();
		
		actions.keyDown(Keys.TAB).build().perform();
		actions.keyUp(Keys.TAB).build().perform();
		waitForSeconds(1);
		
		WebElement instaElement = driver.findElement(By.xpath("//a[text()='Instagram']"));
		
		actions.moveToElement(instaElement).click().build().perform();
		
//		
//		actions.keyDown(Keys.TAB).build().perform();
//		actions.keyUp(Keys.TAB).build().perform();
//		waitForSeconds(1);
		
//		WebElement login = driver.findElement(By.name("login"));
//		actions.click(login).build().perform();
		
		waitForSeconds(10);
		driver.quit();
	}

}
