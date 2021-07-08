package com.azure.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.azure.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Object repository
	@FindBy(xpath = "//div[@id='language']")
	WebElement LanguageDropdown;

	@FindBy(xpath = "//div[@ng-bind-html='language']")
	private List<WebElement> listOflanguages;

	@FindBy(id = "name")
	private WebElement nameInputField;

	@FindBy(id = "orgName")
	private WebElement orgNameInputField;

	@FindBy(id = "singUpEmail")
	private WebElement emailInputField;

	@FindBy(xpath = "//span[contains(text(),'I agree to the')]")
	private WebElement iAgreeCheckbox;

	@FindBy(xpath = "//button[text() = 'Get Started']")
	private WebElement getStartedButton;

	@FindBy(xpath = "//div[@ng-show='errorMessage']/span")
	private WebElement emailSentMessage;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void clickLanguageDropdown() {
		LanguageDropdown.click();
	}

	public List<WebElement> getListOfLanguages() {
		return listOflanguages;
	}

	public void setName(String name) {
		nameInputField.sendKeys(name);
	}

	public void setOrgName(String orgName) {
		orgNameInputField.sendKeys(orgName);
	}

	public void setEmail(String email) {
		emailInputField.sendKeys(email);
	}

	public void clickIAgreeCheckbox() {
		iAgreeCheckbox.click();
	}

	public void clickGetStartedButton() {
		getStartedButton.click();
	}

	public String getEmailSentMessage() {
		emailSentMessage = expilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-show='errorMessage']/span")));
		return emailSentMessage.getText();
	}

}
