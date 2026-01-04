package testing_knowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class GetAllLinks {

    public static String url;
    public static WebDriver driver;
    public static ChromeOptions options;
    private static Scanner scanner;

    static {
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        scanner = new Scanner(System.in);
        System.out.print("Please enter the link to get all links :: ");
        url = scanner.nextLine();
    }

    public static void main(String[] args) {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        }catch (Exception exception){
            throw new RuntimeException("Browser failed to load with in 60 seconds", exception);
        }
        driver.get(url);
        getAllLinksTexts();
        getAllLinks();
        driver.quit();
    }

    /**
     * This Method is used to get all text of links.
     */
    public static void getAllLinksTexts(){
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links :: "+allLinks.size());
        int number = 1;
        for (WebElement link : allLinks) {
            System.out.println((number++)+" : "+link.getText());
        }
    }

    /**
     * This Method is used to get all urls of links.
     */
    public static void getAllLinks(){
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links :: "+allLinks.size());
        int number = 1;
        for (WebElement link : allLinks) {
            System.out.println((number++)+" : "+link.getAttribute("href"));
        }
    }
}
