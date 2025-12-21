package testingK;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinks {

	public static void main(String[] args) throws InterruptedException {
      WebDriver driver= new ChromeDriver();
      driver.get("https://www.amazon.in/");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
       int count=allLinks.size();
       System.out.println(count);
//	  System.out.println(allLinks);
       for(int i=0;i<count;i++) {
//    	   Thread.sleep(1000);
    	  String text = allLinks.get(i).getText();
    	  System.out.println(text);
//    	  driver.quit();
       }
       driver.quit();
	}

}
