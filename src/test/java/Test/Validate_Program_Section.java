package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

public class Validate_Program_Section extends NavigateURL {

	public void Loading_Program_Section() {
		WebElement Program = driver.findElement(By.id("menu-item-264"));
		Action hover = action.moveToElement(Program).build();
		hover.perform();
	}

	@Test(priority = 1,groups = {"Homepage nav Links"})
	private void Validating_Tobacco_Link() {

		Loading_Program_Section();
		WebElement Tobacco = driver.findElement(By.partialLinkText("Tobacco"));
		Tobacco.click();
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Tobacco"), "Not navigating to Tobacco page");
		// Content verification

		assertTrue(content.contentEquals("TOBACCO"), "Not navigating to Tobacco page");

	}

	@Test(priority = 2,groups = {"Homepage nav Links"})
	public void Validating_AHECScholars_Link() {
		Loading_Program_Section();
		WebElement AHECScholars = driver.findElement(By.partialLinkText("AHEC Scholars"));
		AHECScholars.click();
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("AHEC Scholars"), "Not navigating to AHEC Scholars page");
		// Content verification

		assertTrue(content.contentEquals("AHEC SCHOLARS"), "Not navigating to AHEC Scholars page");
	}

	@Test(priority = 3,groups = {"Homepage nav Links"})
	public void Validating_Healthy_Aging_Link() {
		Loading_Program_Section();
		WebElement HealthyAging = driver.findElement(By.partialLinkText("Healthy Aging"));
		HealthyAging.click();
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Healthy Aging"), "Not navigating to Healthy Aging page");
		// Content verification

		assertTrue(content.contentEquals("HEALTHY AGING"), "Not navigating to Healthy aging page");
	}

	@Test(priority = 4,groups = {"Homepage nav Links"})
	public void Validating_Navigators_Link() {
		Loading_Program_Section();
		WebElement Navigators = driver.findElement(By.partialLinkText("Covering "));
		Navigators.click();
		String content = driver.findElement(By.tagName("h2")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Navigators"), "Not navigating to Navigators  page");
		// Content verification

		assertTrue(content.contentEquals("EDUCATING TOWARDS A HEALTHIER COMMUNITY"), "Not navigating to Tobacco page");
	}

}
