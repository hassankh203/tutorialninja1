package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.RegistrationPage;

public class ResisrationTest extends BaseClass {

	RegistrationPage rp;
	LandingPage lp;

//	@Test
//	public void cliclOnRegisterButton() throws InterruptedException {
//		lp = new LandingPage(driver);
//		lp.clickMyAccountLink();
//		lp.clickRegisterLink();
//		Thread.sleep(3000);
//
//	}

	@Test
	public void registarationTestWithValidCredentials()  {
		lp = new LandingPage(driver);
		lp.clickMyAccountLink();
		lp.clickRegisterLink();
		rp = new RegistrationPage(driver);
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomAlphaNumeric() + "@gmail.com");
		rp.setTelephone(randomNumber());
		rp.setPassword("Sam@123");
		rp.setConfirmPassword("Sam@123");
		rp.checkPolicy();
		rp.submit();

		Assert.assertEquals(rp.successRegistrationMessage(), "Your Account Has Been Created!");

	}

}
