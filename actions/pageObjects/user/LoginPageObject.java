package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputsenKeyToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPassWordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmailAddressEmptyErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MESSAGE);
	}

	public String passwordEmptyErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
	}

	public String getEmailAddressInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MESSAGE);
	}

	public String getEmailAddressIncorrectErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
	}

	public String getPasswordInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE);
	}

	public String getPasswordIncorrectErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MESSAGE);
	}

}
