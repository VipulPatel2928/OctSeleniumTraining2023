package seleniumlocators.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LocatorsClass {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = LaunchBrowserClass.getChromeDriver();
		driver.get("https://techivp.com/");

		LaunchBrowserClass.waitForSeconds(5);

		// 1 Tag
		WebElement menuBtnElement = driver.findElement(By.tagName("button"));
		menuBtnElement.click();
		LaunchBrowserClass.waitForSeconds(1);

		//2 Xpath
		WebElement contactLinkElement = driver.findElement(By.xpath("//a[text()='Contact']"));
		contactLinkElement.click();
		LaunchBrowserClass.waitForSeconds(6);

		//3 ID
		WebElement enquiDropDownElement = driver.findElement(By.id("contact_inquiry_for"));
		enquiDropDownElement.click();
		LaunchBrowserClass.waitForSeconds(1);

		Select select = new Select(enquiDropDownElement);
		select.selectByIndex(0);

		//4 ID
		List<WebElement> firstNameElement = driver.findElements(By.id("contact_name"));
		firstNameElement.get(0).sendKeys("java");

		//5 Name
		WebElement mobilElement = driver.findElement(By.name("contact_mobile"));
		mobilElement.sendKeys("1234567899");
		
		//6 CSS
		WebElement emailElement = driver.findElement(By.cssSelector("input#contact_email"));
		mobilElement.sendKeys("test@gmail.com");
		
		//7 xpath
		WebElement messageElement = driver.findElement(By.xpath("//textarea[@placeholder='Share your message']"));
		messageElement.sendKeys("Hi I am interested in learning selenium");
		
		LaunchBrowserClass.waitForSeconds(5);
		
		driver.get("https://www.facebook.com/");
		LaunchBrowserClass.waitForSeconds(2);
		
		//LinkText
		driver.findElement(By.linkText("Forgotten password?")).click();
		LaunchBrowserClass.waitForSeconds(5);
		
		//Partial Link Text
		driver.findElement(By.partialLinkText("Forgotten account?")).click();
		LaunchBrowserClass.waitForSeconds(5);
		// Close the session
		driver.quit();
	}

}
