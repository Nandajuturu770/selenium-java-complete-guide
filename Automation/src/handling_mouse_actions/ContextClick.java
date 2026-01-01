package handling_mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ContextClick {

    private static WebDriver driver;
    private static ChromeOptions options;
    private static Actions actions;
    private static String url = "https://www.selenium.dev/";

    static {
        options = new ChromeOptions();
        options.addArguments("--disable-notifiactions");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
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
        contextClickOnScreen();
        try{Thread.sleep(5000);}catch (Exception ignore){}
        WebElement element = driver.findElement(By.id("Layer_1"));
        contextClickOnElement(element);
        try{Thread.sleep(5000);}catch (Exception ignore){}
    }

    /**
     * This method is used to perform the context click on screen.
     */
    public static void contextClickOnScreen(){
        actions.contextClick().build().perform();
    }

    /**
     * This method is used to perform the context click on element.
     * @param element <code>{@link WebElement}</code>
     */
    public static void contextClickOnElement(WebElement element){
        actions.contextClick(element).build().perform();
    }
}