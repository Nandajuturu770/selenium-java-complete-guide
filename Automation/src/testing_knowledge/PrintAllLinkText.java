package testingK;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllLinkText {
	public static void main(String[] args) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER YOUR URL TO GET ALL LINK TEXT ");
		String url = s.nextLine();
		Thread.sleep(3000);
		WebDriver dr = new ChromeDriver();
		printAllLinkText(dr,url);
	}

	public static void printAllLinkText(WebDriver dr , String url) throws InterruptedException {
		dr.manage().window().maximize();
		dr.get(url);
		List<WebElement> links = dr.findElements(By.xpath("//a"));
		System.out.println("total no of links : "+links.size());
		for(int i = 0 ; i < links.size() ; i++) {
			System.out.println(links.get(i).getText());
		}
		dr.quit();
	}
}
