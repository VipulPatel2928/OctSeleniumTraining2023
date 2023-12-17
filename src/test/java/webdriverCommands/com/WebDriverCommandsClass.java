package webdriverCommands.com;

import org.checkerframework.common.value.qual.IntRange;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverCommandsClass {
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

		// 1. Get method is used to Open URL in the focused window
		driver.get("https://www.facebook.com/");
		waitForSeconds(1);

		// 2. Get Current URL from the browser window
		String currentURLString = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentURLString);

		if (currentURLString.equals("https://www.facebook.com/")) {
			System.out.println("Current URL is matched with the Open URL");
		} else {
			System.out.println("Current URL is not matched with the Open URL");
		}

		// 3. Get title used to get the title of the page, Focused.
		String getTitleString = driver.getTitle();
		System.out.println("Page title : " + getTitleString);

		if (getTitleString.equals("Facebook – log in or sign up")) {
			System.out.println("Page title is matched with the Open URL");
		} else {
			System.out.println("Page title is not matched with the Open URL");
		}
		
		
		// 4. Get page Source Code
		String getSourceCodeString = driver.getPageSource();
		System.out.println("Page Source Code : " + getSourceCodeString);

		// 5. Get Text of the Element
		WebElement h2 = driver.findElement(By.xpath("//h2"));
		String getTextString = h2.getText();
		if(getTextString.equals("Facebook helps you connect and share with the people in your life.")) {
			System.out.println("Text is verifierd : "+getTextString);
		}
		else {
			System.out.println("Text is not verifierd");
			System.out.println("Expected Text : "+"Facebook helps you connect and share with the people in your life");
			System.out.println("Actual Text : "+getTextString);
		}
		
		// 6. Get tag of the Element
		System.out.println(h2.getTagName());
		
		
		// 7. Get CSS Value of the Element
		System.out.println("font-family : "+h2.getCssValue("font-family"));
		System.out.println("font-size : "+h2.getCssValue("font-size"));
		System.out.println("line-height : "+h2.getCssValue("line-height"));
		System.out.println("width : "+h2.getCssValue("width"));
		
		// 8. Get Attributes of the Element
		
		System.out.println("baseURI : "+h2.getAttribute("baseURI"));
		System.out.println("className : "+h2.getAttribute("className"));
		System.out.println("outerText : "+h2.getAttribute("outerText"));
		System.out.println("scrollHeight : "+h2.getAttribute("scrollHeight"));
		System.out.println("scrollWidth : "+h2.getAttribute("scrollWidth"));
		
		
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys("Java Programming");
		waitForSeconds(1);
		System.out.println("Entered Value : "+emailElement.getAttribute("value"));
		
		//9 Get Size
		int height = h2.getSize().height;
		System.out.println("Height : "+height);
		int width = h2.getSize().width;
		System.out.println("Width : "+width);
		
		waitForSeconds(1);
		driver.quit();
	}

}
