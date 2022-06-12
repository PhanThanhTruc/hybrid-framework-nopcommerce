package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passTextbox;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMsg;

	@FindBy(xpath = "//div[contains(@class, 'validation-summary-errors')]")
	private WebElement unSuccessMsg;

	@FindBy(xpath = "//button[contains(@class, 'login-button')]")
	private WebElement loginButton;

	public void clickLoginButton() {
		waitForElementClickAble(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(driver, emailErrorMsg);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, invalidEmail);

	}

	public String getErrorMessageUnSuccessfull() {
		waitForElementVisible(driver, unSuccessMsg);
		return getElementText(driver, unSuccessMsg);
	}

	public void inputToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, passTextbox);
		sendKeyToElement(driver, passTextbox, passWord);

	}

}
