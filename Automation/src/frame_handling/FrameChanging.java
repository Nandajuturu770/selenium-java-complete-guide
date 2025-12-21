package frame_handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameChanging {
	
	public static void main(String[] args) throws InterruptedException {
		// to open the browser
		WebDriver dr = new ChromeDriver();
		// to call the method
		automativeDisableElements(dr);
	}

	public static void automativeDisableElements(WebDriver dr) throws InterruptedException {
		// to maximize the browser
		dr.manage().window().maximize();
		// to enter the url
		dr.get("https://demoapps.qspiders.com/");
		// to syncronizitation 
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to find the element 
		WebElement pw = dr.findElement(By.xpath("(//section)[2]"));
		dr.switchTo().frame(pw);
		// to find the element 
		WebElement we = dr.findElement(By.xpath("(//section[contains(@class , 'border')])[2]"));
		dr.switchTo().frame(we);
		// to find the element 
		dr.findElement(By.xpath("//li[text()='Disabled']")).click();
		// to wait upto displayed 
		WebDriverWait wb = new WebDriverWait(dr, Duration.ofSeconds(10));
		//wb.until(ExpectedConditions.visibilityOf())
		// to close the browser
		//dr.quit();
	}
}