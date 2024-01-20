package pom;

import org.bouncycastle.util.test.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTestCasesClass extends HomePageLogic{

	public HomePageTestCasesClass(WebDriver driver) {
		super(driver);
	}

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
		// Test Case 1
	    // Open URL
		// Click on Login Button without entering any values
		// Verify the notification - The email address or mobile number you entered isn't connected to an account.
		HomePageLogic homePageLogic = new HomePageLogic(driver);
		String testcasetitleString = "Verify that user get the notifications - The email address or mobile number you entered isn't connected to an account. ";
		System.out.println("Title :"+testcasetitleString);
		homePageLogic.OpenUrl("https://www.facebook.com/", 5);
		homePageLogic.ClickLoginBtn();
		if(homePageLogic.VerifyNotificationForBlankUsernamePass()) {
			System.out.println("Test Case is passed");
		}
		else{
			System.out.println("Test Case is failed");
		}
		waitForSeconds(5);
		
		// Test Case 2
	    // Open URL
		// Click on the Create New Account
		// Verify It's quick and easy text value and SignUp button. 
		
		testcasetitleString = "Verify that user navigate to SignUp Page";
		homePageLogic.OpenUrl("https://www.facebook.com/", 5);
		homePageLogic.ClickCreateNewAccountBtn();
		if(homePageLogic.VerifySignup()) {
			System.out.println("Test Case is passed");
		}
		else{
			System.out.println("Test Case is failed");
		}
		
		waitForSeconds(5);
		driver.quit();
	}

}
