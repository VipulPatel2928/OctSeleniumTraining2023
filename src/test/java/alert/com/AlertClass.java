package alert.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClass {

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
		driver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
		waitForSeconds(3);
		WebElement simple = driver.findElement(By.id("simple"));
		simple.click();
		waitForSeconds(5);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		waitForSeconds(5);
		
		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.click();
		alert.accept();
		waitForSeconds(5);
		
		WebElement confirmAcceptmsgElement= driver.findElement(By.xpath("//div[text()='You Accepted Alert!']"));
		
		if(confirmAcceptmsgElement.getText().equals("You Accepted Alert!")) {
			System.out.println("Alert is Accepted ");
		}
		else {
			System.out.println("Alert is not Accepted ");
		}
		
		confirm = driver.findElement(By.id("confirm"));
		confirm.click();
		alert.dismiss();
		waitForSeconds(5);
		
		
		String msgString = "Selenium";
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		alert.sendKeys(msgString);
		alert.accept();
		waitForSeconds(5);
		
		WebElement promtAlertMsgElement = driver.findElement(By.xpath("//div[text()='Hello "+msgString+"! How are you today?']"));
		String textMsgString = "Hello "+msgString+"! How are you today?";
		if(promtAlertMsgElement.getText().equals(textMsgString)) {
			System.out.println("Prompt Alert message is display");
		}
		prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		alert.dismiss();
		
		waitForSeconds(3);
		driver.quit();
	}

}
