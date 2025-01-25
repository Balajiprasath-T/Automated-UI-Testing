package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

public class Validate_Service_Links extends NavigateURL {
	public void Loading_Services_Section() {
		WebElement Services = driver.findElement(By.id("menu-item-331"));
		Action hover = action.moveToElement(Services).build();
		hover.perform();
	}

	@Test(priority = 1,groups = {"Homepage nav Links"})
	private void Validating_CommunityEducation_Link() {
		Loading_Services_Section();
		WebElement CommunityEducation = driver.findElement(By.partialLinkText("Community"));
		CommunityEducation.click();
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Community"), "Not navigating to Community page");
		// Content verification

		assertTrue(content.contentEquals("COMMUNITY BASED STUDENT EDUCATION AND TRAINING"),
				"Not navigating to Community page");
	}

	@Test(priority = 2,groups = {"Homepage nav Links"})
	public void Validating_ContinuingEducation_Link() {
		Loading_Services_Section();
		WebElement ContinuingEducation = driver.findElement(By.partialLinkText("Continuing"));
		ContinuingEducation.click();
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Continuing"), "Not navigating to Continuing Education page");
		// Content verification

		assertTrue(content.contentEquals("CONTINUING EDUCATION SERVICES"),
				"Not navigating to Community page");

	}
}
