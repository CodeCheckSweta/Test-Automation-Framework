package com.ui.tests;

import static com.constants.Size.L;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

@Listeners({com.ui.listeners.TestListeners.class})
public class ProductCheckoutTest extends TestBase{
	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "Valid first time user logs into the application")
	public void setUp() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("teloj52073@bezill.com", "password").searchForAProduct(SEARCH_TERM);

	}
	
	@Test(description = "Verify that the logged in user is not able to buy a dress due to no payment method available", groups = { "sanity", "e2e" })
	public void checkoutTest() {
		String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(L).addToCart().proceedToCheckout()
		.goToConfirmAddressPage().goToShippingPage().goToPaymentPage().makePaymentByWire();
		
		Assert.assertTrue(result.contains("No payment"));
	}
}
