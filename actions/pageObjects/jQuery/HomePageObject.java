package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByNumber(String pageNumber) {
		waitForElementClickAble(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLable(String headerLable, String value) {
		waitForElementVisible(driver, HomePageUI.TEXTBOX_SEARCH, headerLable);
		sendKeyToElement(driver, HomePageUI.TEXTBOX_SEARCH, value, headerLable);
		pressKeyToElement(driver, HomePageUI.TEXTBOX_SEARCH, Keys.ENTER, headerLable);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_NUMBER_ACTIVE, pageNumber);
		return isElementDisplay(driver, HomePageUI.PAGE_NUMBER_ACTIVE, pageNumber);

	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSizes(driver, HomePageUI.TOTAl_PAGINATION);
		System.out.println("Totale size =" + totalPage);
		List<String> allRowValueAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(1);

			List<WebElement> allRowElementEachPage = getListElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// in ra tất cả các giá trị row ra - tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println("----------------------------");
			System.out.println(value);

		}
		return allRowValueAllPage;
	}

}
