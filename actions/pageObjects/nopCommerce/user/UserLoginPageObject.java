package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserHomePageObject clickLoginButton() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePageObject(driver);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MSG);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public String getErrorMessageUnSuccessfull() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESS_MSG);
		return getElementText(driver, LoginPageUI.UNSUCCESS_MSG);
	}

	public void inputToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, LoginPageUI.PASS_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASS_TEXTBOX, passWord);

	}
	public UserHomePageObject loginAsUser(String emailAddress, String passWord) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(passWord);
		return clickLoginButton();
	}

	

}
