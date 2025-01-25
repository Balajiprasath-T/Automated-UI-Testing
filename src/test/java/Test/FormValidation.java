package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormValidation extends NavigateURL {
	public void Loading_Program_Section() {
		WebElement Program = driver.findElement(By.id("menu-item-264"));
		Action hover = action.moveToElement(Program).build();
		hover.perform();
	}
	@DataProvider(name = "formData")
	public Object[][] data(){
		return new Object[][] {{"Rofial","Busan","5486584785","fpsj23@gmail.com"}};
	}
	@Test(priority = 1)
	public void Validating_Healthy_Aging_Link() {
		Loading_Program_Section();
		WebElement HealthyAging = driver.findElement(By.linkText("Healthy Aging"));
		HealthyAging.click();
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Healthy Aging"), "Not navigating to Healthy Aging page");
		// Content verification

		assertTrue(content.contentEquals("HEALTHY AGING"), "Not navigating to Healthy aging page");
	}

	
	@Test(dependsOnMethods = "Validating_Healthy_Aging_Link",dataProvider = "formData",priority = 2)
	public void ValidateFormFeature(String fname,String lname,String ph,String email) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement firstNameEl = driver.findElement(By.cssSelector("input[title = 'First']"));
		WebElement lastNameEl = driver.findElement(By.cssSelector("input[title = 'Last']"));
		WebElement PhoneEl = driver.findElement(By.id("cog-1"));
		WebElement EmailEl = driver.findElement(By.id("cog-2"));

		firstNameEl.sendKeys(fname);
		lastNameEl.sendKeys(lname);
		PhoneEl.sendKeys(ph);
		EmailEl.sendKeys(email);

		WebElement country = driver.findElement(By.xpath("//div[@class = 'el-radio-group']//label[4]"));
		country.click();
		
		WebElement submitform = driver.findElement(By.className("cog-button__text"));
	    submitform.click();

	    WebElement formSubMessage = driver.findElement(By.className("cog-confirmation-message"));
	    assertEquals(formSubMessage.getText(), "Thank you for filling out the form. Your response has been recorded.","Form not submitted successfully");
	}
}
