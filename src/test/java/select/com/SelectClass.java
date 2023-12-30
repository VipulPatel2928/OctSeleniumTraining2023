package select.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static WebDriver driver;

	public static void waitForSeconds(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This fucntion is used to launch the Chrome Browser
	public static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://www.facebook.com/");
		waitForSeconds(3);
		WebElement createNewAccountElement = driver.findElement(By.xpath("//a[text()='Create new account']"));
		
		//Remove the comment to see the "UnexpectedTagNameException"
		//Select selct1 = new Select(createNewAccountElement);
		//selct1.selectByIndex(0);
		
		createNewAccountElement.click();
		waitForSeconds(3);
		
		WebElement dayElement = driver.findElement(By.id("day"));
		Select select = new Select(dayElement);
		select.selectByIndex(10);
		waitForSeconds(1);
		
		WebElement monthElement = driver.findElement(By.id("month"));
		select = new Select(monthElement);
		select.selectByValue("9");
		waitForSeconds(1);
		

		WebElement yearElement = driver.findElement(By.id("year"));
		select = new Select(yearElement);
		select.selectByVisibleText("1986");

		waitForSeconds(3);
		driver.quit();
	}

}
