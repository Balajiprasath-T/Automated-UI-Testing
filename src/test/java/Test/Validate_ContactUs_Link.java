package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Validate_ContactUs_Link extends NavigateURL{
  @Test(priority = 2,groups = {"Homepage nav Links"})
  public void Loading_ContactUS_Section() {
	  WebElement ContactUs = driver.findElement(By.id("menu-item-209"));
	  ContactUs.click();
	  assertTrue(driver.getTitle().contains("CONTACT US"),"Given Link not navigating to Contact us page");

  }
}
