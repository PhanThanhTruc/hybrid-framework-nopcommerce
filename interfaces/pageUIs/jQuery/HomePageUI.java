package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "XPath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String TEXTBOX_SEARCH = "Xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div /following-sibling::input";
	public static final String PAGE_NUMBER_ACTIVE = "Xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAl_PAGINATION = "Xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_INDEX = "Xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "Xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "Xpath=//tbody/tr/td[@data-key='country']";
}
