package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Validate_SearchBox extends NavigateURL{
  @Test(priority = 2)
  public void SearchBoxFunc() {
	  WebElement SearchBox = driver.findElement(By.className("s"));
	  WebElement searchBtw = driver.findElement(By.xpath("//input[contains(@class,'searchsubmit')]"));
	  SearchBox.sendKeys("Health");
	  searchBtw.click();
	  
	  String firstSearchResult = driver.findElement(By.xpath("//div[@class=\"fusion-post-content-wrapper\"]//h2")).getText();
	  assertTrue(firstSearchResult.contains("Health"));
	 
   }
}
