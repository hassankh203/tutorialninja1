package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	
	

	By firstname = By.id("input-firstname");
	By lastname = By.id("input-lastname");
	By myemail = By.id("input-email");
	By telephone = By.id("input-telephone");
	By mypassword = By.id("input-password");
	By mypasswordConfirm = By.id("input-confirm");
	By checkedPolicy = By.name("agree");
	By submit = By.cssSelector(".btn.btn-primary");
	By successMessage = By.xpath("//div[@id='content']/h1");

	public void setFirstName(String fname) {
		driver.findElement(firstname).sendKeys(fname);

	}

	public void setLastName(String lname) {
		driver.findElement(lastname).sendKeys(lname);

	}

	public void setEmail(String email) {
		driver.findElement(myemail).sendKeys(email);

	}

	public void setTelephone(String tel) {
		driver.findElement(telephone).sendKeys(tel);

	}

	public void setPassword(String password) {
		driver.findElement(mypassword).sendKeys(password);

	}

	public void setConfirmPassword(String confpassword) {
		driver.findElement(mypasswordConfirm).sendKeys(confpassword);

	}

	public void checkPolicy() {
		driver.findElement(checkedPolicy).click();

	}

	public void submit() {
		driver.findElement(submit).click();

	}

	public String successRegistrationMessage() {
		return driver.findElement(successMessage).getText();

	}

}
