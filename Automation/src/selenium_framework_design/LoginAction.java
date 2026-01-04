package selenium_framework_design;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginAction {
	
	public WebDriver toOpen(String url ) {
		// to read the data from the user
		Scanner sc = new Scanner(System.in);
		// to display the proper msg to user
		System.out.println("please enter your number according which browser do you want open :");
		System.out.println("chrome : 1 \nfire fox : 2 \nedge : 3");
		// to open the browser
		WebDriver dr = null ;
		// to open the spefic browser
		for(int i = 1 ; i > 0 ;i++) {
			int n = sc.nextInt();
			if(n==1) {
				dr = new ChromeDriver();
				break ;
			}
			else if(n==2) {
				dr = new FirefoxDriver();
				break ;
			}
			else if (n==3) {
				dr = new EdgeDriver();
				break ;
			}
			else {
				System.out.println("please enter correct value either 1 or 2 0r 3  ");
			}
		}
		// to maxaxize the browser
		dr.manage().window().maximize();
		// to sysntronization
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to enter the url
		dr.get(url);
		// to get the title 
		System.out.println(dr.getTitle());
		// to return the webdribver
		return dr;
	}
	public void toLogin(WebDriver dr , String un, String pw) {
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to find the element and enter the data into it 
		dr.findElement(By.name("username")).sendKeys(un);
		// to find the element and enter the data into it 
		dr.findElement(By.name("pwd")).sendKeys(pw);
		// to find the element and click on the element
		dr.findElement(By.xpath("//div[text()='Login ']")).click();
		// to find the element and checking 
		boolean check = dr.findElement(By.xpath("//span[.='Username or Password is invalid. Please try again.']")).isDisplayed();
		if(check == true)
			System.out.println(un+ " or "+ pw +" are wrong please enter valid data :");
		else
			System.out.println(un+" and "+pw+" are the right you loged in successfully ");
		dr.quit();	
	}		
}
