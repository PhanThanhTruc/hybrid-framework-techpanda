package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.HomePageUI;

public class HomPageObject extends BasePage {
	private WebDriver driver;

	public HomPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
