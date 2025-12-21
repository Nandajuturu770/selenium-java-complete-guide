package testingK;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemo {

	@Test
	public static void display() {
		System.out.println("hi");
		Reporter.log("nanda");
		Reporter.log("kiran",true);
		Reporter.log("juturu",false);
	}
}
