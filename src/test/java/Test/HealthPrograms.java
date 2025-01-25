package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class HealthPrograms extends NavigateURL {
	@Test(groups = "HealthPrograms", priority = 1)
	public void QuitTobacco() {
		WebElement QuitTobaccoProg = driver.findElement(By.linkText("QUIT TOBACCO"));
		QuitTobaccoProg.click();
		assertEquals(driver.getTitle(), "Quit Tobacco - West Florida Area Health Education Center, Inc");
		driver.navigate().back();
		
	}

	@Test(groups = "HealthPrograms", priority = 2)
	public void HEALTHY_AGING_PROGRAMS() {
		WebElement HelathAgingProg = driver.findElement(By.linkText("HEALTHY AGING PROGRAMS"));
		HelathAgingProg.click();
		assertEquals(driver.getTitle(), "Healthy Aging - West Florida Area Health Education Center, Inc");
		driver.navigate().back();

	}

	@Test(groups = "HealthPrograms", priority = 3)
	public void HEALTH_INSURANCE() {
		WebElement HealthInsuranceProg = driver.findElement(By.linkText("HEALTH INSURANCE NAVIGATION"));
		HealthInsuranceProg.click();
		assertEquals(driver.getTitle(), "Navigators - West Florida Area Health Education Center, Inc");
		driver.navigate().back();

	}

	@Test(groups = "HealthPrograms", priority = 4)
	public void AHEC_SCHOLARS() {
		WebElement AHECProg = driver.findElement(By.linkText("AHEC SCHOLARS"));
		// cookies
		driver.findElement(By.linkText("Agree")).click();
		AHECProg.click();
		assertEquals(driver.getTitle(), "AHEC Scholars - West Florida Area Health Education Center, Inc");
		driver.navigate().back();

	}
}
