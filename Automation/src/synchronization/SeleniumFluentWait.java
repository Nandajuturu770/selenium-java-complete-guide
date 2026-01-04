package synchronization;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SeleniumFluentWait {

    private static WebDriver driver;
    private static ChromeOptions options;
    private static Actions actions;
    private static String url = "https://www.selenium.dev/";
    private static FluentWait<WebDriver> fluentWait;
    private static JavascriptExecutor jse;

    static {
        options = new ChromeOptions();
        options.addArguments("--disable-notifiactions");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        fluentWait = new FluentWait<>(driver);
        jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void main(String[] args) {
        try{
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }catch (Exception ignore){
            throw new RuntimeException(ignore.getMessage());
        }
        driver.get(url);
        WebElement browserStackImg = driver.findElement(By.cssSelector("img[title='BrowserStack']"));
        scrollElementTobeMiddle(browserStackImg);
        waitForElementVisible(browserStackImg);
        driver.quit();
    }

    /**
     * This method is used to wait till element is visible.
     * @param element <code>{@link WebElement}</code>
     */
    public static void waitForElementVisible(WebElement element){
        fluentWait.withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method is used to scroll the page till element is middle
     * @param element <code>{@link WebElement}</code>
     */
    public static void scrollElementTobeMiddle(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView({block:'center'})", element);
    }
}