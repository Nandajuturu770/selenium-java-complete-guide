package testingK;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllSuggestions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr  = new ChromeDriver();
		printAllSuggestions(dr);
	}

	public static void printAllSuggestions(WebDriver dr) throws InterruptedException {
		
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.get("https://www.amazon.in/");
		dr.findElement(By.id("twotabsearchtextbox")).sendKeys("shoes");
		Thread.sleep(4000);
		List<WebElement> we = dr.findElements(By.xpath("//div[text()='shoes']/.."));
	    System.out.println("length of list : "+we.size());
	    for (WebElement sug : we) {
			System.out.println(sug.getText());
		}
	    dr.close();
		
	}
}
