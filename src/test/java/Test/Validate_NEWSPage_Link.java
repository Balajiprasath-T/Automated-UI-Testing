package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Validate_NEWSPage_Link extends NavigateURL{
  @Test(priority = 2,groups = {"Homepage nav Links"})
  public void Loading_NEWS_Section() {
	  WebElement NEWSLink = driver.findElement(By.linkText("NEWS"));
	  NEWSLink.click();
	  assertTrue(driver.getTitle().contains("NEWS"),"Given Link not navigating to NEWS page");

  }
}
