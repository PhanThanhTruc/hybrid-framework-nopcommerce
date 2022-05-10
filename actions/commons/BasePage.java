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

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}

	private List<WebElement> getListElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropDownn(WebDriver driver, String xpathLocator, String valueText) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(valueText);
	}

	public String getFirtSelectItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectInCustomDropdown(WebDriver driver, String parentElementBy, String childBy,
			String expectedTextItem) {
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeOut);
		expliciWait.until(ExpectedConditions.elementToBeClickable(getByXpath(parentElementBy))).click();
		List<WebElement> allItem = expliciWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childBy)));
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

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attribute) {
		return getWebElement(driver, xpathLocator).getAttribute(attribute);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String cssValue) {
		return getWebElement(driver, xpathLocator).getCssValue(cssValue);
	}

	public String getHexaColorFormRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSizes(WebDriver driver, String xpathLocator) {
		return getListElements(driver, xpathLocator).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}

	public boolean isElementEnanble(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
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

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathLocator));
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

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathLocator));
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

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitForElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, xpathLocator)));
	}

	public void waitForElementClickAble(WebDriver driver, String xpathLocator) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	public void sleepInSecond(long timeOutInSecond) {
		try {
			Thread.sleep(timeOutInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private long longTimeOut = 30;
	private long shortTimeout = 5;

}
