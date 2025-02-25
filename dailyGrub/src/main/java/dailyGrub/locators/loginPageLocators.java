package dailyGrub.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dailyGrub.baseClass.BaseClassDailyGrub;

public class loginPageLocators extends BaseClassDailyGrub{
	public WebDriverWait wait;
//	String Username = "hello@bodybybree.com";
//	String Password = "BBB@321";
	
	public loginPageLocators() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/section/div/div/form[1]/div[1]/img")
	public WebElement CompanyLogo;
	@FindBy(xpath = "//*[@id=\"loginform\"]/h3")
	public WebElement PageName;
	@FindBy(name = "username")
	public WebElement UserName;
	@FindBy(name = "password")
	public WebElement PassWord;
	@FindBy(xpath = "//span[@toggle='#user_password' and contains(@class, 'toggle-password')]")
	public WebElement ShowPwdToggle;
	@FindBy(id = "user-login")
	public WebElement LoginBtn;
	@FindBy(id = "err-msg")
	public WebElement AlertMessage;
	@FindBy(id = "to-recover")
	public WebElement ForgotPwd;
	@FindBy(xpath = "//*[@id=\"recoverform\"]/div[1]/div[1]/h3")
	public WebElement ResetPwdPageTitle;
	@FindBy(id = "user_email")
	public WebElement MailIDforResetPwd;
	@FindBy(id = "reset_send")
	public WebElement ResetBtn;
	@FindBy(id = "succ_msg")
	public WebElement ResetPwdPageAlertMsg;
	@FindBy(xpath = "//*[@id=\"recoverform\"]/div[3]/div/a")
	public WebElement RedirectToLoginPage;
	public Object LoginButton;
	
	public void EnterUserName(String Username) {
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		UserName.click();
		UserName.sendKeys(Username);
	}
	public void EnterPwd(String Password) {
		wait.until(ExpectedConditions.elementToBeClickable(PassWord));
		PassWord.click();
		PassWord.sendKeys(Password);
	}
	public void ClickLoginBtn() {
		LoginBtn.click();
	}
	public void clearFields() {
		UserName.clear();
		PassWord.clear();
	}
	public void clickShowPasswordToggle()throws InterruptedException{
		//wait.until(ExpectedConditions.elementToBeClickable(ShowPwdToggle));
		ShowPwdToggle.click();
	}
	public void clickForgotPwd() {
		ForgotPwd.click();
	}
	public void EnterMailIDforResetPwd(String MailID) {
		MailIDforResetPwd.sendKeys(MailID);
	}
	public void clickResetBtn() {
		ResetBtn.click();
	}
	public void clickRedirectToLoginPage() {
		RedirectToLoginPage.click();
	}
	public void clearEmaiID() {
		MailIDforResetPwd.clear();
	}
}
