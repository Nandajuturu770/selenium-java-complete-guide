package take_screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;

public class ScreenshotOfElement {

    public ChromeOptions options;
    public WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor js;
    TakesScreenshot takeScreenshot;
    public String url = "https://www.selenium.dev/";
    public String screenshotPath = "./Automation/Screenshot/";

    {
        options = new ChromeOptions();
        options.addArguments("--disable-notifcations");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        takeScreenshot =(TakesScreenshot) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void browserSetup() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        try {
            driver.get(url);
        } catch (Exception exception) {
            throw new RuntimeException("application is not loaded with 30 seconds " + exception.getMessage());
        }
        WebElement seleniumImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Layer_1")));
        takeScreenshotOfElement(seleniumImg);
        WebElement seleniumWebDriverImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selenium_webdriver")));
        js.executeScript("arguments[0].scrollIntoView({block:'center', behaviour:'smooth'});", seleniumWebDriverImg);
        try {Thread.sleep(2000);} catch (InterruptedException interruptedException) {}
        takeScreenshotOfElement(seleniumWebDriverImg);
        takeScreenshot();
        driver.quit();
    }

    /**
     * This method is used to take screenshot of element.
     * @param element <code>{@link WebElement}</code>
     */
    public void takeScreenshotOfElement(WebElement element) {
        File source = element.getScreenshotAs(OutputType.FILE);
        Calendar calendar = Calendar.getInstance();
        File destination = new File(screenshotPath + calendar.getTimeInMillis() + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to take screenshot of window.
     */
    public void takeScreenshot(){
        File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
        Calendar calendar = Calendar.getInstance();
        File destination = new File(screenshotPath + calendar.getTimeInMillis() + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}