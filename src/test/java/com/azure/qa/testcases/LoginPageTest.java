package com.azure.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.azure.qa.base.TestBase;
import com.azure.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyLoginPageTitleTest() {
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, "Jabatalks");
	}

	@Test
	public void verifyFlightSearchTest() {
		List<String> listOfLanguagesStr = new ArrayList<String>();
		String name = "AzureTest";
		String orgName = "OrgAzureTest";
		String email = "Azure@gmail.com";

		loginPage.clickLanguageDropdown();
		for (WebElement webElement : loginPage.getListOfLanguages()) {
			listOfLanguagesStr.add(webElement.getText());
		}
		if (listOfLanguagesStr.contains("English") && listOfLanguagesStr.contains("Dutch")) {
			Assert.assertTrue(true, "English and Dutch are present in the dropdown");
		} else {
			Assert.assertFalse(false, "English and Dutch are not present in the dropdown");
		}

		loginPage.setName(name);
		loginPage.setOrgName(orgName);
		loginPage.setEmail(email);
		loginPage.clickIAgreeCheckbox();
		loginPage.clickGetStartedButton();
		String actualEmailSentMessage = loginPage.getEmailSentMessage();
		Assert.assertEquals(actualEmailSentMessage, "A welcome email has been sent. Please check your email.");
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
