package pom;

import org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

/**
 * @author Admin
 *
 */
public class HomePageLogic {
	public static WebDriver driver;
	public HomePageLogic(WebDriver driver) {
	  this.driver = driver;
	}
	

	/**
	 * @param url
	 * @param timeout
	 */
	public void OpenUrl(String url, int timeout) 
	{
		driver.get(url);
		System.out.println("Cureent Open URL : "+driver.getCurrentUrl());
		HomePageTestCasesClass.waitForSeconds(timeout);
	}
	
	public void OpenUrl(String url) 
	{
		driver.get(url);
		HomePageTestCasesClass.waitForSeconds(5);
	}
	
public void ClickLoginBtn() 
{
	WebElement loginElement = driver.findElement(By.name("login"));
	loginElement.click();
	System.out.println("Click Login Button");
	HomePageTestCasesClass.waitForSeconds(5);
}

public void ClickForgotPasswordLink() 
{
	WebElement loginElement = driver.findElement(By.linkText("Forgotten password?"));
	loginElement.click();
}


public void ClickCreateNewAccountBtn() 
{
	WebElement loginElement = driver.findElement(By.linkText("Create new account"));
	loginElement.click();
	HomePageTestCasesClass.waitForSeconds(5);
}


public void EnterEmailorPhone() 
{
	WebElement loginElement = driver.findElement(By.id("email"));
	loginElement.click();
}


public void EnterPassword() 
{
	WebElement loginElement = driver.findElement(By.id("pass"));
	loginElement.click();
}

public boolean VerifyNotificationForBlankUsernamePass() 
{
	WebElement notificationElement = driver.findElement(By.xpath("//a[text()='Find your account and log in.']//.."));
	System.out.println(notificationElement.getText());
	String expectedString = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	if(notificationElement.getText().trim().equals(expectedString)) {
		return true;
	}
	else {
		return false;
	}
}

public boolean VerifySignup() 
{
	WebElement quickandeasyElement = driver.findElement(By.xpath("//div[text()=\"It's quick and easy.\"]"));
	System.out.println(quickandeasyElement.getText());
	String expectedString = "It's quick and easy.";
	WebElement signupbtnElement = driver.findElement(By.name("websubmit"));
	int flag=0;
	
	if(quickandeasyElement.getText().trim().equals(expectedString)) {
		System.out.println("It's quick and easy text is displayed");
	}
	else {
		System.out.println("It's quick and easy text is not displayed");
		flag++;
	}
	
	if(signupbtnElement.getText().trim().equals("Sign Up") && signupbtnElement.isDisplayed()) {
		System.out.println("Sign Up button is displayed");
	}
	else {
		System.out.println("Sign Up button is not displayed");
		flag++;
	}
	
	if(flag==0) {
		System.out.println("All assertions are passed");
		return true;
	}
	else {
		System.out.println("How many assertions failed : "+flag);
		return false;
	}
}

}
