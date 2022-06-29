package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void inputToUsernameTextbox(String emailAdress) {
		waitForAllElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}

	public void inputToPasswordTextbox(String Password) {
		waitForAllElementVisible(driver, AdminLoginPageUI.PASS_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.PASS_TEXTBOX, Password);
	}

	public AdminDashboardObject clickButtonLogin() {
		waitForAllElementVisible(driver, AdminLoginPageUI.BUTTON_LOGIN_LOGIN);
		clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN_LOGIN);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardObject loginAsAdmin(String emailAdress, String pasword) {
		inputToUsernameTextbox(emailAdress);
		inputToPasswordTextbox(pasword);
		return clickButtonLogin();
	}

}
