package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}


	By emailBox = By.id("input-email");
	By passwordBox = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By logoutButton = By.linkText("Logout");
	By successfulLogin = By.linkText("Edit your account information");
	By invalidLoginCredential = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	
	public void inputEmail (String email) {
		driver.findElement(emailBox).sendKeys(email);
	}
	
	public void inputPassword (String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}
	
	public void clickloginButton () {
		driver.findElement(loginButton).click();
	}
	
	public void clicklogoutButton () {
		driver.findElement(logoutButton).click();
	}
	
	public boolean successfulLogin () {
		return driver.findElement(successfulLogin).isDisplayed();
	
	}
	
	public boolean invalidCredentialsWarningMessage()
	{
		String actual = driver.findElement(invalidLoginCredential).getText();
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		//return actual.contentEquals(expected);
		
		return actual.equals(expected);
		
	}

}
