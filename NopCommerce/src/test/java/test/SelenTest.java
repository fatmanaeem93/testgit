package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SelenTest {
	public static void main(String[] args) {
//      ------------navigate to nopcommerce-----------------
		WebDriver driver = new ChromeDriver();
		String baseUrl= "https://admin-demo.nopcommerce.com/";
		driver.manage().window().maximize();
		driver.get(baseUrl);
//      -----------assert url and title -------------------------------		
		Assert.assertTrue(driver.getCurrentUrl().contains(ConstantData.LOGIN_URL));
		String pageTitlElement = driver.getTitle();
		Assert.assertTrue(pageTitlElement.contains(ConstantData.LOGIN_TITLE));
//      -----------assert email and password------------------------
		WebElement emailElement = driver.findElement(By.id("Email"));
		Assert.assertEquals(emailElement.getAttribute("value"), "admin@yourstore.com");
		WebElement passElement =driver.findElement(By.id("Password"));
		Assert.assertTrue(passElement.getAttribute("value").contains("admin"));
//      ----------click on login button----------------------
		WebElement loginButtonElement =driver.findElement(By.className("login-button"));
		Actions actions =new Actions(driver);
		actions.moveToElement(loginButtonElement).build().perform();
//		Assert.assertEquals(loginButtonElement.getCssValue("background-color"),"rgba(36, 142, 206, 1)");
		loginButtonElement.click();
//      ----------Dashboard ------------------		
		Assert.assertTrue(driver.getCurrentUrl().contains(ConstantData.ADMIN_URL));
		Assert.assertTrue( driver.getTitle().contains("Dashboard / nopCommerce administration"));
		WebElement titleDashboard = driver.findElement(By.cssSelector(".content-header h1"));
		Assert.assertTrue(titleDashboard.getText().contains("Dashboard"));
		
		
		
		
		
		System.out.println("end");
	}
}
