package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMsg;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMsg;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMsg;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMsg;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPassErrorMsg;

	@FindBy(xpath = "//div[contains(@class, 'message-error')]//li")
	private WebElement emailExistErrorMsg;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccess;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	public void clickToRegisterButton() {
		waitForElementClickAble(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMsg);
		return getElementText(driver, firstNameErrorMsg);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMsg);
		return getElementText(driver, lastNameErrorMsg);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(driver, emailErrorMsg);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMsg);
		return getElementText(driver, passwordErrorMsg);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPassErrorMsg);
		return getElementText(driver, confirmPassErrorMsg);
	}

	public String getErrorMessageExistEmail() {
		waitForElementVisible(driver, emailExistErrorMsg);
		return getElementText(driver, emailExistErrorMsg);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccess);
		return getElementText(driver, registerSuccess);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastName);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);

	}

	public void clickToLogoutLink() {
		waitForElementClickAble(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

}
