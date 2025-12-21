package handling_disable_elements;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDisableElements {

	public static void main(String[] args) throws InterruptedException {
		// to open the browser
		WebDriver dr = new ChromeDriver();
		// to call the method
		handlingDisableElements(dr);
	}

	public static void handlingDisableElements(WebDriver dr) throws InterruptedException {
		// to maximize the browser
		dr.manage().window().maximize();
		// to syncronization
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to enter the url 
		dr.get("https://demoapps.qspiders.com/ui?scenario=1");
		// to click on the element 
		dr.findElement(By.xpath("//li[text()='Disabled']")).click();
		// to type casting 
		JavascriptExecutor je = (JavascriptExecutor) dr;
		// to find the element in the web page and the value 
		Thread.sleep(2000);
		je.executeScript("document.getElementById('name').value='NANDAKIRAN'");
		Thread.sleep(2000);
		je.executeScript("document.getElementById('email').value='nadnajuturu@gmail.com'");
		Thread.sleep(2000);
		je.executeScript("document.getElementById('password').value='Nandajuturu#770'");
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[text()=\"Register\"]")).click();
		dr.close();
	}
}