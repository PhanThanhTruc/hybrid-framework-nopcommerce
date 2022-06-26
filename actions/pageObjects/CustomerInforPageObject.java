package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.BaseTest;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isCustomerInforDisplay() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplay(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	

}
