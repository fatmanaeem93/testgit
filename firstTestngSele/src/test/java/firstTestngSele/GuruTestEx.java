package firstTestngSele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuruTestEx {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void checkTitle() {
		driver.get("http://demo.guru99.com/test/newtours/");
		String pageTitlElement = driver.getTitle();
		Assert.assertTrue(pageTitlElement.contains("Welcome: Mercury Tours"));
	}

	@AfterTest
	public void exitBrowser() {
		driver.quit();
		System.out.println("exit Browser");
	}

	@AfterMethod
	public void verifyHomePageTitle() {
		driver.navigate().back();
		String pageTitlElement = driver.getTitle();
		Assert.assertTrue(pageTitlElement.contains("Welcome: Mercury Tours"));
	}

	@Test(priority = 0)
	public void clickRegister() {
		WebElement registerButton = driver.findElement(By.linkText("REGISTER"));
		registerButton.click();
		String pageTitlRegister = driver.getTitle();
		Assert.assertTrue(pageTitlRegister.contains("Register: Mercury Tours"));
	}

	@Test(priority = 1)
	public void clickSupport() {
		WebElement supportLink = driver.findElement(By.linkText("SUPPORT"));
		supportLink.click();
//		WebElement closeButton = driver.findElement(By.id("dismiss-button"));
//		closeButton.click();
		String pageTitlSupport = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(pageTitlSupport));
		System.out.println(pageTitlSupport);
		Assert.assertTrue(pageTitlSupport.contains("Under Construction: Mercury Tours"));
	}

}
