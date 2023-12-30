package relativelocator.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativelocatorClass {
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
		System.out.println("URL :"+driver.getCurrentUrl());
		
		WebElement createNewAElement = driver.findElement(By.linkText("Create new account"));
		createNewAElement.click();
		waitForSeconds(2);
		System.out.println("Clicked :"+createNewAElement.getText());
		
		WebElement maleElement = driver.findElement(By.xpath("//label[text()='Male']"));
		
		WebElement feMaleElement = driver.findElement(with(By.tagName("input")).toLeftOf(maleElement));
		feMaleElement.click();
		waitForSeconds(2);
		System.out.println("Clicked Female Radio button");
		
		WebElement costomElement = driver.findElement(with(By.tagName("input")).toRightOf(maleElement));
		costomElement.click();
		waitForSeconds(2);
		System.out.println("Clicked Custom Radio button");
		
		driver.navigate().to("https://www.facebook.com/");
		waitForSeconds(3);
		System.out.println("URL :"+driver.getCurrentUrl());
		
		WebElement pass = driver.findElement(By.id("pass"));
		
		WebElement emailElement = driver.findElement(with(By.id("email")).above(pass));
		emailElement.sendKeys("This is email text field");
		waitForSeconds(2);
		System.out.println("Email :"+emailElement.getAttribute("value"));
		
		WebElement forgotPassElement = driver.findElement(with(By.linkText("Forgotten password?")).below(pass));
		System.out.println("Clicked :"+forgotPassElement.getText());
		forgotPassElement.click();

		
		driver.navigate().back();
		waitForSeconds(5);
		pass = driver.findElement(By.id("pass"));
		System.out.println("Navigating to previous page");
		
		WebElement loginElement = driver.findElement(with(By.tagName("button")).near(pass));
		System.out.println("Clicked :"+loginElement.getText());
		loginElement.click();
		
		
		waitForSeconds(5);
		driver.quit();
	}

}
