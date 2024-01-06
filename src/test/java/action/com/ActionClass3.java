package action.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass3 {

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
		driver.get("https://jqueryui.com/draggable/");
		waitForSeconds(2);

		driver.switchTo().frame(0);

		WebElement draggable = driver.findElement(By.id("draggable"));

		draggable.getCssValue("background");

		Actions actions = new Actions(driver);

		actions.clickAndHold(draggable).moveByOffset(50, 75).build().perform();

		waitForSeconds(4);
		
		driver.navigate().refresh();

		driver.switchTo().frame(0);

		draggable = driver.findElement(By.id("draggable"));

		draggable.getCssValue("background");

		actions.clickAndHold(draggable).moveByOffset(50, 75).release().build().perform();

		waitForSeconds(4);

		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);

		draggable = driver.findElement(By.id("draggable"));

		WebElement droppable = driver.findElement(By.id("droppable"));

		actions.dragAndDrop(draggable, droppable).build().perform();

		driver.switchTo().defaultContent();

		waitForSeconds(4);

		driver.navigate().refresh();

		driver.switchTo().frame(0);

		draggable = driver.findElement(By.id("draggable"));

		droppable = driver.findElement(By.id("droppable"));

		actions.clickAndHold(draggable).release(droppable).build().perform();

		driver.switchTo().defaultContent();

		waitForSeconds(4);

		driver.quit();
	}

}
