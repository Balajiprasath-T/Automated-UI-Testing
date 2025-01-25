package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

public class Validate_CPR_Links extends NavigateURL{
	 public void Loading_CPR_Section() {
		  WebElement CPR = driver.findElement(By.id("menu-item-467"));
		  Action hover =  action.moveToElement(CPR).build();
		  hover.perform();
	  }
	  @Test(priority = 1,groups = {"Homepage nav Links"})
	  private void Validating_Shop_Link() {
		  Loading_CPR_Section();
		  WebElement Shop = driver.findElement(By.partialLinkText("Shop"));
		  Shop.click();
		  //Title verification
		  assertTrue(driver.getTitle().contains("Shop"),"Not navigating to Shop page");
	  }
	  @Test(priority = 2, groups = {"Homepage nav Links"})
	  public void Validating_Books_Link() {
		  Loading_CPR_Section();
		  WebElement Books = driver.findElement(By.partialLinkText("Books"));
		  Books.click();
		  //Title verification
		  assertTrue(driver.getTitle().contains("Books"),"Not navigating to Books page");
	  }
	  @Test(priority = 3, groups = {"Homepage nav Links"})
	  public void Validating_Cards_Link() {
		  Loading_CPR_Section();
		  WebElement Cards = driver.findElement(By.partialLinkText("Cards"));
		  Cards.click();
		  //Title verification
		  assertTrue(driver.getTitle().contains("Cards"),"Not navigating to Cards page");
	  }
	  @Test(priority = 4,groups = {"Homepage nav Links"})
	  public void Validating_Rentals_Link() {
		  Loading_CPR_Section();
		  WebElement Rentals = driver.findElement(By.partialLinkText("Rentals"));
		  Rentals.click();
		  //Title verification
		  assertTrue(driver.getTitle().contains("Rentals"),"Not navigating to Rentals  page");
	  }
	  @Test(priority = 5,groups = {"Homepage nav Links"})
	  public void Validating_CPRClasses_Link() {
		  Loading_CPR_Section();
		  WebElement CPRClass = driver.findElement(By.partialLinkText("CPR Classes"));
		  CPRClass.click();
		  //Title verification
		  assertTrue(driver.getTitle().contains("CPR Classes"),"Not navigating to CPR Classes  page");
	  }
}
