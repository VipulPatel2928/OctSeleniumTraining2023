package scroll.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollClass {

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

	
	public static void scrollVertical(WebDriver driver, int pixels) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0," + pixels + ")", "");
		waitForSeconds(4);
	}
	
	public static void scrollHorizontal(WebDriver driver, int pixels) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(" + pixels + ",0)", "");
		waitForSeconds(4);
	}
	
	public static void main(String[] args) {
		driver = getChromeDriver();
		driver.get("https://www.jiomart.com/");
		waitForSeconds(2);

		for (int i = 100; i <= 5000; i = i + 300) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0," + i + ")", "");
			waitForSeconds(4);
		}

		waitForSeconds(4);

		for (int i = 5000; i > 0; i = i - 300) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0," + (-i) + ")", "");
			waitForSeconds(4);
		}
		
		waitForSeconds(4);
		
		scrollVertical(driver, 5000);	
		waitForSeconds(4);
		scrollVertical(driver, -5000);	
		
		driver.get("https://magicrealism.net/");
		waitForSeconds(4);
		
		scrollHorizontal(driver, 5000);
		scrollHorizontal(driver, 5000);
		scrollHorizontal(driver, 5000);
		
		scrollHorizontal(driver, -5000);
		scrollHorizontal(driver, -5000);
		scrollHorizontal(driver, -5000);
		
		driver.quit();
	}

}
