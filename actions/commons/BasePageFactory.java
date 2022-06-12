package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private long longTimeOut = 30;
	private long shortTimeout = 5;

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

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementInVisible(WebDriver driver, WebElement element) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForAllElementInVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void waitForElementClickAble(WebDriver driver, WebElement element) {
		WebDriverWait expliciwait = new WebDriverWait(driver, longTimeOut);
		expliciwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public void sleepInSecond(long timeOutInSecond) {
		try {
			Thread.sleep(timeOutInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
