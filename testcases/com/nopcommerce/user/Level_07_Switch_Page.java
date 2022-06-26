package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AddressPageObject;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, validPass;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInforPageObject customerInforPage;
	private AddressPageObject addressPage;
	private RewardPointPageObject rewardPointPage;
	private MyProductReviewPageObject myProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);

		homePage = PageGeneratorManager.getHomePageObject(driver);

		firstName = "test";
		lastName = "tester";
		emailAddress = "Abc" + ranDom() + "@gmail.com";
		validPass = "123456";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPass);
		registerPage.inputToConfirmPasswordTextbox(validPass);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPass);
		homePage = loginPage.clickLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.clickMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforDisplay());
	}

	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInforPage.openAddressPage(driver);
		myProductPage = addressPage.openMyProductReview(driver);
		rewardPointPage = myProductPage.openRewardPointPage(driver);
		customerInforPage = rewardPointPage.openCustomerInforPage(driver);

	}

	@Test
	public void User_05_Switch_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
