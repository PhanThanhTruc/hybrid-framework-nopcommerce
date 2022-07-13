package pageUIs.nopCommerce.user;

public class RegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
	public static final String FIRST_NAME_ERROR_MSG = "xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MSG = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MSG = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MSG = "xpath=//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MSG = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String EMAIL_EXIST_ERROR_MSG = "xpath=//div[contains(@class, 'message-error')]//li";
	public static final String REGISTER_SUCCESS = "xpath=//div[@class='result']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";

}
