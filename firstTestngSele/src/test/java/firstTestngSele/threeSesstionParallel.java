package firstTestngSele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// we must add and edit xml file to make it parallel
public class threeSesstionParallel {
	@Test
	public void session1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		WebElement userIdInput = driver.findElement(By.cssSelector("input[name=\"uid\"]"));
		userIdInput.sendKeys("user1");
	}

	@Test
	public void session2() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		WebElement userIdInput = driver.findElement(By.cssSelector("input[name=\"uid\"]"));
		userIdInput.sendKeys("user2");
	}

	@Test
	public void session3() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		WebElement userIdInput = driver.findElement(By.cssSelector("input[name=\"uid\"]"));
		userIdInput.sendKeys("user3");
	}
}
