package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);

	}

	// locators
	
	By myAccountLink = By.linkText("My Account");
	By registerLink = By.linkText("Register");
	By loginLink = By.linkText("Login");
	By searchBox = By.name("search");
	By searchButton = By.xpath("//Button[@class = 'btn btn-default btn-lg']");
	By iphoneLink = By.linkText("iPhone");
	
	

	

	// actions
	public void clickMyAccountLink() {
		driver.findElement(myAccountLink).click();
	
		
	}

	public void clickRegisterLink() {
		driver.findElement(registerLink).click();
	}

	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}
	

	public void inputInSearchBox(String product) {
		driver.findElement(searchBox).sendKeys(product);
	}
	

	public void clickOnSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public boolean iphonelink() {
	return driver.findElement(iphoneLink).isDisplayed();
	}
	
	
	

}
