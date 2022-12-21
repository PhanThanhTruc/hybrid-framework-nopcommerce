package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "XPath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String TEXTBOX_SEARCH = "Xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div /following-sibling::input";
	public static final String PAGE_NUMBER_ACTIVE = "Xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAl_PAGINATION = "Xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_INDEX = "Xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "Xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "Xpath=//tbody/tr/td[@data-key='country']";

	// index của cột mà mình cần enter vào/click/select vào;
	public static final String COLUM_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String ICON_NAME_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]/td/button[@title='%s']";

	public static final String LOAD_BUTTON = "xpath=//button[@id='btnLoad']";
}
