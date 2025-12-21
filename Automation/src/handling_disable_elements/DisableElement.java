package handling_disable_elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisableElement{
	public static void main(String[] args) throws InterruptedException {
		// to open the browser
		WebDriver dr = new ChromeDriver();
		// to maximize the broser
		dr.manage().window().maximize();
		// to syncronization
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to enter the url
		dr.get("https://demoapps.qspiders.com/ui?scenario=1");
		// to wail
		Thread.sleep(2000);
		// to find the element 
		dr.findElement(By.xpath("//li[text()='Disabled']")).click();
		// to get title of the browser
		System.out.println(dr.getTitle());
		// to casting 
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		// to execute the java Script we hava method enter the data into the disable element 
		Thread.sleep(2000);
		jse.executeScript("document.getElementById('name').value='NANDAKIRAN'");
		jse.executeScript("document.getElementById('email').value='nandajuturu@gmail.com'");
		jse.executeScript("document.getElementById('password').value='Nandajuturu#770'");
		// to click on the element
		dr.findElement(By.xpath("//button[text()='Register']")).submit();
		// to wait 
		Thread.sleep(2000);
		// to close 
		dr.quit();
	}
}