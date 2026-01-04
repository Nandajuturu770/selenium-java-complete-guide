package selenium_framework_design;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Testing {
	public static void main(String[] args) throws IOException {
		// to open the property
		FileLabrary fl = new FileLabrary();
		// to open the broser
		LoginAction la = new LoginAction();
		// tp open the browser
		WebDriver wd = la.toOpen(fl.getPropertyData("url"));
		// to login into application
		la.toLogin(wd, fl.getPropertyData("un"), fl.getPropertyData("pw"));
	}
}
