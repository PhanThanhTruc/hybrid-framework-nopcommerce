package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, validPass;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);

		homePage = PageGeneratorManager.getUserHomePageObject(driver);

		firstName = "test";
		lastName = "tester";
		emailAddress = "Abc" + ranDom() + "@gmail.com";
		validPass = "123456";

	}

	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPass);
		registerPage.inputToConfirmPasswordTextbox(validPass);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPass);
		homePage = loginPage.clickLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforDisplay());
	}



	@Test
	public void User_02_Switch_Page() {
		addressPage = customerInforPage.openAddressPage(driver);
		myProductPage = addressPage.openMyProductReview(driver);
		rewardPointPage = myProductPage.openRewardPointPage(driver);
		customerInforPage = rewardPointPage.openCustomerInforPage(driver);

	}
	@Test
	public void User_03_Dynamic_Page_01() {
		addressPage =(UserAddressPageObject) customerInforPage.openPageAtMyAccountByName(driver, "Addresses");
		myProductPage = (UserMyProductReviewPageObject) addressPage.openPageAtMyAccountByName(driver, "My product reviews");
		rewardPointPage = (UserRewardPointPageObject) myProductPage.openPageAtMyAccountByName(driver, "Reward points");
		customerInforPage = (UserCustomerInforPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Customer info");

	}
	@Test
	public void User_03_Dynamic_Page_02() {
		customerInforPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductPage=PageGeneratorManager.getUserMyProductReviewPage(driver);
		myProductPage.openPageAtMyAccountByName(driver, "Reward points");
		rewardPointPage=PageGeneratorManager.getUserRewardPointPage(driver);
		rewardPointPage.openPageAtMyAccountByName(driver, "Customer info");
		customerInforPage= PageGeneratorManager.getUserCustometInforPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
