package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashBoardPageUI;

public class AdminDashboardObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isDashBoardHeaderDisplay() {
		waitForAllElementVisible(driver, AdminDashBoardPageUI.HEADER_DASHBOARD);
		return isElementDisplay(driver, AdminDashBoardPageUI.HEADER_DASHBOARD);
	}
}
