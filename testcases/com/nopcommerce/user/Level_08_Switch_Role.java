package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String userEmailAddress, userPassWord, adminEmailAdress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerPage;
	private AdminLoginPageObject adminLoginPagae;
	private AdminDashboardObject adminDashBoardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);

		userHomePage = PageGeneratorManager.getUserHomePageObject(driver);

		userEmailAddress = "Abc3182@gmail.com";
		userPassWord = "123456";
		adminEmailAdress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void Role_1_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassWord);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userCustomerPage = userHomePage.clickMyAccountLink();

		userHomePage = userCustomerPage.clickToLogoutLinkAtUser(driver);

		userHomePage.openURL(driver, GlobalConstants.ADMIN_URL);
		adminLoginPagae = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashBoardPage = adminLoginPagae.loginAsAdmin(adminEmailAdress, adminPassword);
		Assert.assertTrue(adminDashBoardPage.isDashBoardHeaderDisplay());
		// adminLoginPagae = adminDashBoardPage.clickToLogoutLinkAtAdmin(driver);
		// Check lại nguyên nhân sai hay do mạng
	}

	@Test
	public void Role_2_Admin_To_User() {
		adminLoginPagae.openURL(driver, GlobalConstants.USER_URL);
		userHomePage = PageGeneratorManager.getUserHomePageObject(driver);

		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassWord);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
