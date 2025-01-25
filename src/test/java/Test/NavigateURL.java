package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavigateURL extends BaseClass {
	@Test(groups = { "URL", "Homepage" })
	public void TestURL() {
		driver.get("https://westfloridaahec.org/");
		assertTrue(driver.getTitle().equals("Home - West Florida Area Health Education Center, Inc"));
		// cookies
		driver.findElement(By.linkText("Agree")).click();
	}
}
