package take_screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TakeScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// to open the browser
		WebDriver dr = new ChromeDriver();
		// to maximazime the browser
		dr.manage().window().maximize();
		// to syncronization
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to enter the url
		dr.get("https://www.instagram.com/");
		/* to take screenshot here we need to call a method to take screenshot that is takeScreenshotAs() 
		 * which is used to take screenshot and which is present in TakeScreenshot interface so we have to 
		 * do type caste the reference variable of browser into TakeScreenshot 
		 */
		// to wait
		Thread.sleep(2000);
		RemoteWebDriver rb = (RemoteWebDriver) dr;
		// it will return address
		File address = rb.getScreenshotAs(OutputType.FILE);
		// to save address
	    File save = new File("./Screenshot/nan.png");
	    // to save the file
	    FileUtils.copyFile(address, save);
	    dr.quit();
		}
	}