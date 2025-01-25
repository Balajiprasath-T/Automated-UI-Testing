package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

public class CheckCartFeature extends NavigateURL {

	public void Loading_CPR_Section() {
		WebElement CPR = driver.findElement(By.id("menu-item-467"));
		Action hover = action.moveToElement(CPR).build();
		hover.perform();
	}

	@Test(priority = 1, dependsOnMethods = "TestURL")
	public void GotoShop() {
		Loading_CPR_Section();
		WebElement shop = driver.findElement(By.id("menu-item-693"));
		shop.click();
		String EntryTitle = driver.findElement(By.tagName("h1")).getText();
		assertTrue(EntryTitle.equals("SHOP"));
	}

	@Test(priority = 2, dependsOnMethods = "GotoShop")
	public void GotoBooks() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Books = driver.findElement(By.linkText("BOOKS"));
		Books.click();
		String EntryTitle = driver.findElement(By.tagName("h1")).getText();
		assertTrue(EntryTitle.equals("BOOKS"));
	}

	@Test(priority = 3, dependsOnMethods = "GotoBooks")
	public void VerifyBookdetails() {
		WebElement Book1 = driver.findElement(By.linkText("BLS Instructor Package with DVD Set"));
		Book1.click();
		String EntryTitle = driver.findElement(By.tagName("h1")).getText();
		assertTrue(EntryTitle.equals("BLS INSTRUCTOR PACKAGE WITH DVD SET"));
	}

	@Test(priority = 3, dependsOnMethods = "VerifyBookdetails")
	public void VerifyPlusButtonFunc() {
		WebElement plus = driver.findElement(By.cssSelector("input.plus"));
		plus.click();
		plus.click();
		plus.click();
		WebElement Qty = driver.findElement(By.cssSelector("input[name = 'quantity']"));
		String QtyStr = (String) (((JavascriptExecutor) driver).executeScript("return arguments[0].value", Qty));
		int quantity = Integer.parseInt(QtyStr);
		assertEquals(quantity, 4);

	}

	@Test(priority = 4, dependsOnMethods = "VerifyPlusButtonFunc")
	public void VerifyMinusButtonFunc() {
		WebElement minus = driver.findElement(By.cssSelector("input.minus"));
	
		minus.click();
		minus.click();
		WebElement Qty = driver.findElement(By.cssSelector("input[name = 'quantity']"));
		String QtyStr = (String) (((JavascriptExecutor) driver).executeScript("return arguments[0].value", Qty));
		int quantity = Integer.parseInt(QtyStr);
		assertEquals(quantity, 2);

	}

	@Test(priority = 5, dependsOnMethods = "VerifyMinusButtonFunc")
	public void Gotocart() {
		driver.findElement(By.name("add-to-cart")).click();
		WebElement cart = driver.findElement(By.linkText("View cart"));
		cart.click();
	}

	@Test(priority = 6, dependsOnMethods = "Gotocart")
	public void CheckCartItemCount() {
		String ItemCountDescrp = driver.findElement(By.tagName("h2")).getText();
		int TotalItemCount = Integer.parseInt(ItemCountDescrp.replaceAll("[^\\d]", ""));

		List<WebElement> allQty = driver.findElements(By.xpath("//*/tbody//td[@class = 'product-quantity']"));

		int ItemCount = 0;
		for (WebElement qty : allQty) {
			WebElement qtyValue = qty.findElement(By.xpath("//input[contains(@class ,'qty text')]"));
			ItemCount += Integer.parseInt(
					(String) (((JavascriptExecutor) driver).executeScript("return arguments[0].value", qtyValue)));

		}

		assertEquals(ItemCount, TotalItemCount);

	}

	@Test(priority = 7, dependsOnMethods = "CheckCartItemCount")
	public void CheckSubTotal() {
		List<WebElement> allQty = driver.findElements(By.xpath("//*/tbody//td[@class = 'product-quantity']"));

		double ActualCartTotal = 0;
		for (WebElement qty : allQty) {
			WebElement qtyValue = qty.findElement(By.xpath("//input[contains(@class ,'qty text')]"));

			String priceStr = qty.findElement(By.xpath("./preceding-sibling::td[1]")).getText();

			String subTotalStr = qty.findElement(By.xpath("./following-sibling::td[1]")).getText();

			double price = Double.parseDouble(priceStr.replaceAll("[^\\d.]", ""));
			double subtotal = Double.parseDouble(subTotalStr.replaceAll("[^\\d.]", ""));
			int ItemCount = Integer.parseInt(
					(String) (((JavascriptExecutor) driver).executeScript("return arguments[0].value", qtyValue)));

			double ActualSubtotal = price * ItemCount;
			ActualCartTotal += ActualSubtotal;
			assertEquals(ActualSubtotal, subtotal);
			
			

		}
		
		double expectedCartTotal = Double.parseDouble(driver.findElement(By.xpath("//td[@data-title = 'Subtotal']")).getText().replaceAll("[^\\d.]", ""));
		assertEquals(ActualCartTotal, expectedCartTotal);
	}

}
