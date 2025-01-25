package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	 static WebDriver driver;
	 static Actions action;
	 static WebDriverWait wait;
	  @BeforeSuite(groups = {"Homepage"})
	  public void setup() {
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  action = new Actions(driver);
	  }
	  @AfterSuite(groups = {"Homepage"})
		 public void tearDown() {
			 driver.quit();
		 }
}
