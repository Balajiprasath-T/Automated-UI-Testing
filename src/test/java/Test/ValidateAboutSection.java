package Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

public class ValidateAboutSection extends NavigateURL{
 
  public void LoadingAboutSections() {
	  
	  WebElement About = driver.findElement(By.id("menu-item-616"));
	  Action hover =  action.moveToElement(About).build();
	  hover.perform();
  }
  @Test(priority = 1,groups = {"Homepage nav Links"})
  private void Validating_Board_Of_Directors_Link() {
	  LoadingAboutSections();
	  WebElement BoardOfDirectors = driver.findElement(By.partialLinkText("Board"));
	  BoardOfDirectors.click();
	  //Title verification
	  assertTrue(driver.getTitle().contains("Board"),"Not navigating to correct page");
  }
  @Test(dependsOnMethods = { "Validating_Board_Of_Directors_Link" }, priority = 2)
	public void Validate_Post_Titles() {
		List<WebElement> PostTitles = driver
				.findElements(By.xpath("//div[@class = 'post-content']//div[starts-with(@class , 'col')]"));
		for (WebElement Post : PostTitles) {
			String postTitle = Post.findElement(By.xpath("./div[@class = 'content-container']")).getText()
					.split("\n")[0];
			String Name = Post.findElement(By.xpath(".//h2")).getText();

			switch (postTitle) {
			case "President":
				assertEquals(Name, "GEORGE SMITH, MD, FAAFP");
				break;
			case "Vice President":
				assertEquals(Name, "CHUCK HENDRIX, RT");
				break;
			case "Secretary/Treasurer":
				assertEquals(Name, "ROBERT WILSON, MD");
				break;
			case "Past President":
				assertEquals(Name, "MELINDA HENDERSON, PHD, ARNP, FAAN");
				break;
			case "Gulf Coast Physician Partners":
				assertEquals(Name, "DENNIS MAYEAUX, MD");
				break;
			case "Retired, Community Volunteer":
				assertEquals(Name, "GENNY CROCKER, RN, ARNP");
				break;
			case "FSU College of Medicine":
				assertEquals(Name, "KIM BERGGREN, DMSC, PA-C");
				break;
			case "University of West Florida":
				assertEquals(Name, "CHRISTOPHER WIRTH, MSESS, PHD");
				break;
			case "Community Health Northwest":
				assertEquals(Name, "WALTER ARRINGTON, MSW");
				break;
			}
		}
	}
  @Test(priority = 3,groups = {"Homepage nav Links"})
  public void Validating_Staff_Link() {
	  LoadingAboutSections();
	  WebElement StaffLink = driver.findElement(By.partialLinkText("Staff"));
	  StaffLink.click();
	  //Title verification
	  assertTrue(driver.getTitle().contains("Staff"),"Not navigating to correct page");
  }
  @Test(priority = 4,groups = {"Homepage nav Links"})
  public void Validating_Partners_Link() {
	  LoadingAboutSections();
	  WebElement PartnersLink = driver.findElement(By.partialLinkText("Partners"));
	  PartnersLink.click();
	  //Title verification
	  assertTrue(driver.getTitle().contains("Partners"),"Not navigating to correct page");
  }
  @Test(priority = 5,groups = {"Homepage nav Links"})
  public void Validating_Work_With_US_Link() {
	  LoadingAboutSections();
	  WebElement WorkWithUSLink = driver.findElement(By.partialLinkText("Work With"));
	  WorkWithUSLink.click();
	  //Title verification
	  assertTrue(driver.getTitle().contains("Work"),"Not navigating to correct page");
  }
 
  @Test(priority = 6,groups = {"Homepage nav Links"})
  public void Validating_History_Of_AHEC_Link() {
	  LoadingAboutSections();
	  WebElement HistoryLink = driver.findElement(By.partialLinkText("History"));
	  HistoryLink.click();
	  //Title verification
	  assertTrue(driver.getTitle().contains("History"),"Not navigating to correct page");
  }
}
