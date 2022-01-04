package selenTraining;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.awt.image.BufferedImage;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenshotTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.newegg.com/");
//		driver.manage().window().maximize();
		
//      -------------view screenshot----------
//		Screenshot screenshot =new AShot().takeScreenshot(driver);
//		File imageFile = new File("D:\\QA\\practice\\image1.png");
//		ImageIO.write(screenshot.getImage(),"png", imageFile);
//		driver.quit();
//		------------all view screenshot----------------
//		Screenshot fullPageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5000)).takeScreenshot(driver);
//		File imageFileFullPage = new File("D:\\QA\\practice\\imageFullPage.png");
//		ImageIO.write(fullPageScreenshot.getImage(),"png", imageFileFullPage);
//      ------------------element screenshot----------
		WebElement searchContainerElement =driver.findElement(By.className("header2021-search-inner"));
		Screenshot screenSearch = new AShot().takeScreenshot(driver, searchContainerElement);
		File ElementPath = new File("D:\\QA\\practice\\actualDesign.png"); 
		ImageIO.write(screenSearch.getImage(),"png", ElementPath);
		BufferedImage expectedImage = ImageIO.read(new File("D:\\QA\\practice\\expectedElementDesign.png"));
		BufferedImage actualImage = screenSearch.getImage();
        ImageDiffer result = new ImageDiffer(); 
        ImageDiff exectionResult = result.makeDiff(expectedImage, actualImage);
        Assert.assertFalse(exectionResult.hasDiff());

		
		
		
		
	}

}
