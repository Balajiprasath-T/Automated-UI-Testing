package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Validate_AccountLink extends NavigateURL{
	
  @DataProvider(name = "login data")
	  public Object[][] Data(){
		  return new Object[][] {{"Mohan","Fd@332"},{"POPOY","rty%$#$232"}};
	  }
  
  @Test(priority = 1,groups = {"Homepage nav Links"})
  public void Loading_AccountLink()  {
	  WebElement MyAccount = driver.findElement(By.linkText("MY ACCOUNT"));
	  MyAccount.click();
	  assertTrue(driver.getTitle().contains("My account"),"Given Link not navigating to SignUp page");

  }
  @Test(dependsOnMethods = "Loading_AccountLink",priority = 2)
  public void ForgetPasswordFeatureValidation() {
	  WebElement ForgotPass = driver.findElement(By.linkText("Lost your password?"));
	  ForgotPass.click();
	  WebElement userEmail = driver.findElement(By.id("user_login"));
	  userEmail.sendKeys("example@gmail.com");
	  WebElement resetPassBtw = driver.findElement(By.cssSelector("button[value = 'Reset password']"));
	  resetPassBtw.click();
	  
	  String ConfirmMess = driver.findElement(By.className("wc-block-components-notice-banner__content")).getText();
	  assertEquals(ConfirmMess, "Password reset email has been sent.");
	  Loading_AccountLink();
  }
  
  @Test(dependsOnMethods = {"Loading_AccountLink"},dataProvider = "login data",priority = 3)
  public void WrongLoginValidation(String userName,String Password) {
	  WebElement username = driver.findElement(By.id("username"));
	  WebElement password = driver.findElement(By.id("password"));
	  WebElement loginBtw = driver.findElement(By.cssSelector("button[name ='login']"));
	  username.clear();
	  username.sendKeys(userName);
	  password.clear();
	  password.sendKeys(Password);
	  loginBtw.click();
	  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  
	  WebElement error = driver.findElement(By.xpath("//div[@role = 'alert']/div"));
	  wait.until(ExpectedConditions.visibilityOf(error));
	  assertTrue(error.getText().contains("Error"));
  }
  
  @Test(dependsOnMethods = "WrongLoginValidation",priority = 4)
  public void CorrectLoginValidation() {
	  WebElement username = driver.findElement(By.id("username"));
	  WebElement password = driver.findElement(By.id("password"));
	  WebElement loginBtw = driver.findElement(By.cssSelector("button[name ='login']"));
	  username.clear();
	  username.sendKeys("askalmo");
	  password.clear();
	  password.sendKeys("Goatbrain@23");
	  loginBtw.click();
	  
	  WebElement dashboard = driver.findElement(By.tagName("h2"));
	  
	  assertEquals(dashboard.getText(), "DASHBOARD");

  }
  
  
}
