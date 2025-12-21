package testingK;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Verify {
	
	@Test
    public void verify() {
    // to open the browset
	WebDriver dr = new ChromeDriver();
	// to maximize 
	dr.manage().window().maximize();
	// to synchronization
	dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	// to enter the url
	dr.get("https://www.meesho.com/");
	// to find the elements
	boolean l = dr.findElement(By.xpath("//div[@class=\"header-logo-container\"]")).isDisplayed();
	if(l==true ) {
		Reporter.log("Logo is displayed ",true);
	}
	boolean b = dr.findElement(By.xpath("//div[@placeholder=\"Try Saree, Kurti or Search by Product Code\"]")).isDisplayed();
	if(b==true ) {
		Reporter.log("text box is displayed ",true);
	}
	boolean c = dr.findElement(By.xpath("//span[text()=\"Download App\"]")).isDisplayed();
	if(c==true ) {
		Reporter.log("dowload box is displayed ",true);
	}
	dr.quit();
}
}
