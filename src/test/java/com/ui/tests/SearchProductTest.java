package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListeners.class})
public class SearchProductTest extends TestBase{
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	@BeforeMethod
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("teloj52073@bezill.com", "password");
	}
	
	@Test(description = "Verify if the logged in user is able to search for a product and correct searchproducts are displayed",
			groups = {"sanity", "e2e", "smoke"})
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchtermPresentInProductList(SEARCH_TERM);
		Assert.assertTrue(actualResult, "The searched product is not displayed in the search results");
	}
}
