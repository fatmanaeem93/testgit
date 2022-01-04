package selenTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {

	public static void main(String[] args) {
//      -------------option headless----------------		
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1400,800");       
        options.addArguments("disable-gpu");

		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		
		
		// Locate the searchbox using its name		
      WebElement element = driver.findElement(By.name("q"));	
      
     // Enter a search query		
     element.sendKeys("QA training");	
    
     // Submit the query. Webdriver searches for the form using the text input element automatically		
     // No need to locate/find the submit button		
     element.submit();			
     
		// This code will print the page title		
     System.out.println("Page title is: " + driver.getTitle());		
     
     driver.quit();

	}

}
