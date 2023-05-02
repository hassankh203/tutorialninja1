package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;



public class LoginTest extends BaseClass {

	LandingPage lanp;
	LoginPage logp;

	@Test(priority = 1)
	public void loginTestWithValidCredntials() throws IOException {
		lanp = new LandingPage(driver);
		logp = new LoginPage(driver);

		lanp.clickMyAccountLink();
		lanp.clickLoginLink();
		logp.inputEmail(prop.getProperty("validEmail"));
		logp.inputPassword(prop.getProperty("validPassword"));
		logp.clickloginButton();
		Assert.assertTrue(logp.successfulLogin());
		
		

	}

	@Test(priority = 2)
	public void loginTestWithInvalidEmail() {
		lanp = new LandingPage(driver);
		logp = new LoginPage(driver);

		lanp.clickMyAccountLink();
		lanp.clickLoginLink();
		logp.inputEmail(randomNumber() +(prop.getProperty("invalidEmail")));
		logp.inputPassword(prop.getProperty("validPassword"));
		logp.clickloginButton();
		Assert.assertTrue(logp.invalidCredentialsWarningMessage());
		

	}

	@Test(priority = 3)
	public void loginTestWithInvalidPassword() {
		lanp = new LandingPage(driver);
		logp = new LoginPage(driver);

		lanp.clickMyAccountLink();
		lanp.clickLoginLink();
		logp.inputEmail(prop.getProperty("validEmail"));
		logp.inputPassword((prop.getProperty("invalidPassword") + randomNumber()));
		logp.clickloginButton();
		Assert.assertTrue(logp.invalidCredentialsWarningMessage());

	}

}
