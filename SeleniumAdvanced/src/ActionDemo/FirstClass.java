package ActionDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FirstClass {
	
	static WebDriver driver;
	static WebElement search;
	static WebElement element;
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		
		System.out.println(driver.getTitle());
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		search = driver.findElement(By.cssSelector("input#small-searchterms"));
				
		Actions action = new Actions(driver);
		action.keyDown(search, Keys.SHIFT).sendKeys("Computer").keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input.button-1")).submit();
		System.out.println("Pass1");
		
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
				
		//Hover Computer Menu option
		element = driver.findElement(By.linkText("Computers"));		
		action.moveToElement(element).perform();
		
		Thread.sleep(6000);
		
		
		//Click Computer > Desktop option in Menu		
		element = driver.findElement(By.linkText("Desktops"));
		action.moveToElement(element).click().perform();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		

	}

}
