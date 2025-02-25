package dailyGrub.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dailyGrub.baseClass.BaseClassDailyGrub;
import dailyGrub.locators.loginPageLocators;

public class loginTestCase extends BaseClassDailyGrub {
	public loginPageLocators LoginPageLocators;
	public WebDriverWait wait;

	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
		LoginPageLocators = new loginPageLocators();
	}

	@Test(priority = 1)
	public void logo() {
		Assert.assertTrue((LoginPageLocators.CompanyLogo).isDisplayed());
		System.out.println("Logo is displayed in the Web Page");
	}
//	@Test(priority = 2)
//	public void getButtonColor() {
//	    // Get the background color
//	    String rgbaColor = LoginPageLocators.LoginBtn.getCssValue("background-color");
//	    System.out.println("Button background color (RGBA): " + rgbaColor);
//
//	    // Convert to HEX
//	    String hexColor = rgbaToHex(rgbaColor);
//	    System.out.println("Button background color (HEX): " + hexColor);
//	}
//	private String rgbaToHex(String rgbaColor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	  @Test (priority = 2)
	  public void invalidCredentials() {
	  LoginPageLocators.ClickLoginBtn();
	  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
	  Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
	  System.out.println("Alert message for no UserName and no Password: "+(LoginPageLocators.AlertMessage).getText());
	  driver.navigate().refresh();
	  //No User Name 
	  LoginPageLocators.EnterUserName("");
	  LoginPageLocators.EnterPwd("Testing@123"); LoginPageLocators.ClickLoginBtn();
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
	  Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
	  System.out.println("Alert message for no UserName: "+(LoginPageLocators.AlertMessage).getText());
	  // No Password driver.navigate().refresh();
	  LoginPageLocators.EnterUserName("vikaspk@skadits.com");
	  LoginPageLocators.EnterPwd(""); LoginPageLocators.ClickLoginBtn();
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
	  Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
	  System.out.println("Alert message for no Password: "+(LoginPageLocators.AlertMessage).getText());
	  driver.navigate().refresh();
	  //Invalid Password
	  LoginPageLocators.EnterUserName("vikaspk@skadits.com");
	  LoginPageLocators.EnterPwd("Testing@1234");
	  LoginPageLocators.ClickLoginBtn();
	  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
	  Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
	  System.out.println("Alert message for invalid Password: "+(LoginPageLocators.AlertMessage).getText());
	  //Invalid Username driver.navigate().refresh();
	  LoginPageLocators.EnterUserName("vikaspk1@skadits.com");
	  LoginPageLocators.EnterPwd("Testing@123"); LoginPageLocators.ClickLoginBtn();
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
	  Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
	  System.out.println("Alert message for invalid UserName: "+(LoginPageLocators.AlertMessage).getText());
	  }
	  
	  @Test (priority = 3)
	  public void ShowPasswordToggle() throws InterruptedException { 
	  LoginPageLocators.clearFields();
	  LoginPageLocators.EnterUserName("vikaspk@skadits.com");
	  LoginPageLocators.EnterPwd("Testing@123");
	  LoginPageLocators.clickShowPasswordToggle(); 
	  String initialType =LoginPageLocators.PassWord.getAttribute("type");
	  System.out.println("Initial type of the Password field is: " + initialType);
	  LoginPageLocators.clickShowPasswordToggle();
	  Thread.sleep(3000); 
	  String toggledType = LoginPageLocators.PassWord.getAttribute("type");
	  System.out.println("Toggled type of the Password field is: " + toggledType); 
	  if(toggledType.equals("text")) {
	  System.out.println("Password visibility is enabled.");
	  }
	  else {
	  System.out.println("Password visibility is disabled."); 
	  } 
	  
	 }
	  
	  @Test(priority = 4)
	  public void ForgotPwdPage() {
	  LoginPageLocators.clickForgotPwd();
	  Assert.assertTrue((LoginPageLocators.ResetPwdPageTitle).isDisplayed());
	  System.out.println("Reset Password page Title: "+(LoginPageLocators.ResetPwdPageTitle).getText());
	  }
	  
	  @Test(priority = 5)
	  public void EnterInvalidMailIDforResetPwd() throws InterruptedException {
	  LoginPageLocators.EnterMailIDforResetPwd("vikaspk1@skadits.com");
	  LoginPageLocators.clickResetBtn();
	  Thread.sleep(1000);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.ResetPwdPageAlertMsg)));
	  Assert.assertTrue((LoginPageLocators.ResetPwdPageAlertMsg).isDisplayed());
	  String alertTextForInvalidMailID = LoginPageLocators.ResetPwdPageAlertMsg.getText();
	  System.out.println("Alert message for Invalid Mail ID: " + alertTextForInvalidMailID);
	  }
	  
	  @Test(priority = 6)
	  public void SendMailNotificationforRecoverPwd() throws InterruptedException { 
	  LoginPageLocators.clearEmaiID();
	  LoginPageLocators.EnterMailIDforResetPwd("vikaspk@skadits.com");
	  LoginPageLocators.clickResetBtn();
	  Thread.sleep(2000);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.ResetPwdPageAlertMsg)));
	  Assert.assertTrue((LoginPageLocators.ResetPwdPageAlertMsg).isDisplayed());
	  String alertText = LoginPageLocators.ResetPwdPageAlertMsg.getText();
	  System.out.println("Alert message for Valid Mail ID: " +alertText);
	  LoginPageLocators.clearEmaiID();
	  LoginPageLocators.clickRedirectToLoginPage(); }
	  
	  @Test (priority = 7)
	  public void Login() throws InterruptedException {
	  LoginPageLocators.clearFields();
	  LoginPageLocators.EnterUserName("vikaspk@skadits.com");
	  LoginPageLocators.EnterPwd("Testing@123"); 
	  LoginPageLocators.ClickLoginBtn();
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf((LoginPageLocators.AlertMessage)));
	  Assert.assertTrue((LoginPageLocators.AlertMessage).isDisplayed());
	  String AlertMessageForLogIn = LoginPageLocators.AlertMessage.getText();
	  System.out.println("Alert Message For LogIn: "+ AlertMessageForLogIn);
	  Thread.sleep(3000);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.urlToBe("https://dev.dailygrub.store/dashboard"));
	  String actualResult = driver.getCurrentUrl(); 
	  String expectedResult = "https://dev.dailygrub.store/dashboard";
	  Assert.assertEquals(actualResult,expectedResult);
	  System.out.println("Logged in successfully and redirected to the Dashboard");
	  }
	  
	 
	@AfterClass
	public void closeBrowser() {
		closeApp();
	}
}
