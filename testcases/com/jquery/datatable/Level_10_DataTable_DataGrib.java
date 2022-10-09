package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrib extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	HomePageObject homePage;
	List<String> allCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowser(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("10"));

		homePage.openPagingByNumber("15");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("15"));

		homePage.openPagingByNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("5"));

		homePage.openPagingByNumber("9");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("9"));

	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshToPage(driver);

		homePage.enterToHeaderTextboxByLable("Females", "384187");
		homePage.enterToHeaderTextboxByLable("Country", "Afghanistan");
		homePage.enterToHeaderTextboxByLable("Males", "407124");
		homePage.enterToHeaderTextboxByLable("Total", "791312");

		homePage.sleepInSecond(3);

		homePage.enterToHeaderTextboxByLable("Females", "764956");
		homePage.enterToHeaderTextboxByLable("Country", "Arab Rep of Egypt");
		homePage.enterToHeaderTextboxByLable("Males", "802948");
		homePage.enterToHeaderTextboxByLable("Total", "1567904");

		homePage.sleepInSecond(3);
	}
	@Test
	public void Table_03_Enter_To_Header() {
		allCountryValues=homePage.getValueEachRowAtAllPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
