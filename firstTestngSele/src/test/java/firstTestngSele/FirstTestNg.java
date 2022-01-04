package firstTestngSele;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNg {

	
	WebDriver driver = new ChromeDriver();	
	@BeforeTest
	public void verifyHomePageTitle() {
	
      System.out.println("OpenBrowser");
      driver.get("http://www.google.com/");
      String expectedRes="Downloads | Selenuim";
      String actualRe=driver.getTitle();
      Assert.assertEquals(expectedRes, actualRe);
      driver.close();
	
	}
	@AfterTest
	public void exitBrowser() {
		driver.quit();
		System.out.println("exit Browser");
	}

	@Test()
	public void cTest() {
		System.out.println("Hello from C method");
	}

	@Test(priority = -1)
	public void bTest() {
		System.out.println("Hello from B method");
	}

	@Test(priority = 3)
	public void aTest() {
		System.out.println("Hello from A method");
	}

	@Test()
	public void dTest() {
		System.out.println("Hello from D method");
	}
	

}
