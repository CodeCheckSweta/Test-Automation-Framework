package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners({com.ui.listeners.TestListeners.class})
public class AddNewFirstAddressTest extends TestBase{
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description = "Valid first time user logs into the application")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("teloj52073@bezill.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Verify that user is able to add a new address successfully", groups = { "sanity",
            "e2e" })
	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddNewAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
}
