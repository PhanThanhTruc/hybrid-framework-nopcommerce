package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.nopCommerce.user.BasePageUI;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeOut);
		return explicitwait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void canceltAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public void getTexttAlert(WebDriver driver) {
		waitForAlertPresence(driver).getText();
	}

	public void sendKeytAlert(WebDriver driver, String text) {
		waitForAlertPresence(driver).sendKeys(text);
	}

	public void switchToWindowByID(WebDriver driver, String idWindow) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			if (!id.equals(idWindow)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByPageTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String window : allWindow) {
			driver.switchTo().window(window);
			sleepInSecond(2);
			String actualTitle = driver.getTitle().trim();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentPageId) {
		Set<String> allId = driver.getWindowHandles();
		for (String window : allId) {
			if (!window.equals(parentPageId)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentPageId);
		sleepInSecond(3);
	}

//	private By getByXpath(String locatorType) {
//		return By.xpath(xpathLocator);
//	}

	private By getByLocator(String locatorType) {
		By by = null;
		System.out.println("hello" + locatorType);
		if (locatorType.startsWith("id") || locatorType.startsWith("Id") || locatorType.startsWith("ID")) {
//			locatorType=locatorType.substring(3);
//			by=By.id(locatorType);
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("Xpath") || locatorType.startsWith("XPath") || locatorType.startsWith("XPATH")
				|| locatorType.startsWith("xpath")) {
			by = By.xpath(locatorType.substring(6));
		} else if (locatorType.startsWith("Css") || locatorType.startsWith("CSS") || locatorType.startsWith("css")) {
			by = By.className(locatorType.substring(4));
		} else if (locatorType.startsWith("name") || locatorType.startsWith("Name") || locatorType.startsWith("NAME")) {
			by = By.className(locatorType.substring(5));
		} else if (locatorType.startsWith("Class") || locatorType.startsWith("CLASS")
				|| locatorType.startsWith("class")) {
			by = By.className(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;
	}

	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	private List<WebElement> getListElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void sendKeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropDownn(WebDriver driver, String locatorType, String valueText) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(valueText);
	}

	public String getFirtSelectItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectInCustomDropdown(WebDriver driver, String parentElementBy, String childBy,
			String expectedTextItem) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeOut);
		expliciWait.until(ExpectedConditions.elementToBeClickable(getByLocator(parentElementBy))).click();
		List<WebElement> allItem = expliciWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childBy)));
		for (WebElement webElement : allItem) {
			if (webElement.getText().trim().equals(expectedTextItem)) {
				if (webElement.isDisplayed()) {
					webElement.click();
				} else {
					JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
					jsExcutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
					webElement.click();
				}
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attribute) {
		return getWebElement(driver, locatorType).getAttribute(attribute);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String cssValue) {
		return getWebElement(driver, locatorType).getCssValue(cssValue);
	}

	public String getHexaColorFormRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSizes(WebDriver driver, String locatorType) {
		return getListElements(driver, locatorType).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}

	public boolean isElementEnanble(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locatorType)));
	}

	public void waitForElementClickAble(WebDriver driver, String locatorType) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForAllElementVisible(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustometInforPage(driver);
	}

	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForAllElementVisible(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReview(WebDriver driver) {
		waitForAllElementVisible(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForAllElementVisible(driver, BasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserHomePageObject clickToLogoutLinkAtUser(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_USER);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdmin(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public void sleepInSecond(long timeOutInSecond) {
		try {
			Thread.sleep(timeOutInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private long longTimeOut = 40;
	private long shortTimeout = 5;

}
