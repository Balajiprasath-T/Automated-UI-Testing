package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CrossBrowser_Compatibility {
	
	String url = "https://westfloridaahec.org/";

	@Test
	public void FirefoxTest() {
		WebDriver driver1 = new FirefoxDriver();
		driver1.get(url);
		assertTrue(driver1.getTitle().contains("Home"));
		driver1.quit();
	}

	@Test
	public void ChromeTest() {
		WebDriver driver2 = new ChromeDriver();
		driver2.get(url);
		assertTrue(driver2.getTitle().contains("Home"));
		driver2.quit();
	}

	@Test
	public void EdgeTest() {
		WebDriver driver3 = new EdgeDriver();
		driver3.get(url);
		assertTrue(driver3.getTitle().contains("Home"));
		driver3.quit();
	}

	
}
