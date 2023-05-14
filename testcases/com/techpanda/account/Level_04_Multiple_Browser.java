package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.user.LoginPageObject;
import pageObjects.user.HomPageObject;
import pageObjects.user.MyDashBoardPageObject;
import commons.BasePage;
import commons.BaseTest;

public class Level_04_Multiple_Browser extends BaseTest {
	WebDriver driver;
	HomPageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashBoardPage;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass( String browserName) {
		driver = getBrowserName(browserName);
		homePage = new HomPageObject(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToPassWordTextbox("");
		loginPage.inputsenKeyToEmailTextBox("");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressEmptyErrorMessage(), "This is a required field.");
		assertEquals(loginPage.passwordEmptyErrorMessage(), "This is a required field.");
		System.out.println("Success");
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputsenKeyToEmailTextBox("123@456.789");
		loginPage.inputToPassWordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressInvalidErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void TC_03_LoginWithIncorrectEmail() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputsenKeyToEmailTextBox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPassWordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailAddressIncorrectErrorMessage(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_LoginWithInvalidPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputsenKeyToEmailTextBox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPassWordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordInvalidErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputsenKeyToEmailTextBox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPassWordTextbox(String.valueOf(randomNumber()));
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getPasswordIncorrectErrorMessage(), "Invalid login or password.");
		
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputsenKeyToEmailTextBox("automationfc+123.vn@gmail.com");
		loginPage.inputToPassWordTextbox("123123"); 
		loginPage.clickToLoginButton();
		
		myDashBoardPage= new MyDashBoardPageObject(driver);

		assertTrue(myDashBoardPage.contactInforTextInDashBoardDisplay());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}