package handling_mouse_actions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {

	public static WebDriver driver;
	public static Actions actions;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String parentId = driver.getWindowHandle();
		driver.get("https://demoapps.qspiders.com/ui/dragDrop?sublist=0");
		WebElement dragElement = driver.findElement(By.cssSelector("div[class*='draggable-column']>div[class*='cursor-move']"));
		clickAndHoldAndMove(dragElement);
		moveElementInRectangular(dragElement);
		openNewTab();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.navigate().to("https://www.vtiger.com/");
		WebElement we = driver.findElement(By.id("companyDropdown"));
		actions.moveToElement(we).perform();
		driver.close();
		try {Thread.sleep(5000);}catch (InterruptedException ignored){}
		driver.switchTo().window(parentId);
		driver.close();
	}

	public static void moveElementInRectangular(WebElement element) {
		actions.moveToElement(element, 100, 0)
				.pause(500)
				.moveToElement(element,0, 100)
				.pause(500)
				.moveToElement(element,-100,0)
				.pause(500)
				.moveToElement(element,0,-100)
				.build().perform();
	}

	public static void clickAndHoldAndMove(WebElement element) {
		actions.clickAndHold(element)
				.moveByOffset(100,0)
				.pause(500)
				.moveByOffset(0,100)
				.pause(500)
				.moveByOffset(-100,0)
				.pause(500)
				.moveByOffset(0,-100)
				.build().perform();
	}

	public static String openNewTab(){
		String parentId = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowIds = driver.getWindowHandles();
		for(String id : windowIds)
			if(!id.equals(parentId))
				return id;
		return parentId;
	}
}