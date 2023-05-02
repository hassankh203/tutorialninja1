package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class SearchTest extends BaseClass{
	
	LandingPage lp;
	
	@Test
	public void VerifyingSearchFunction () {
		lp = new LandingPage(driver);
		lp.inputInSearchBox("Iphone");
		lp.clickOnSearchButton();
		Assert.assertTrue(lp.iphonelink());
	}

}
