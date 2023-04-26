package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyDashBoardPageUI;

public class MyDashBoardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean contactInforTextInDashBoardDisplay() {
		waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFOR_TEXT);
		return isElementDisplayed(driver, MyDashBoardPageUI.CONTACT_INFOR_TEXT);
	}

}
