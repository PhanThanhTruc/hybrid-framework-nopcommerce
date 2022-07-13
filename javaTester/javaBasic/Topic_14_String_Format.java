package javaBasic;

public class Topic_14_String_Format {
	public static String CUSTOMER_INFOR_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static String ADDRESS_LINK = "///div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String REWARD_POINTS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String DYNAMIC_SIDEBAR_LINK_PGAE_NAME = "//ul[@class='list']//a[text()='%s']";

	public static String DYNAMIC_LINK_PGAE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {
//		clickToSidebar(CUSTOMER_INFOR_LINK);
//		clickToSidebar(ADDRESS_LINK);
//		clickToSidebar(REWARD_POINTS_LINK);
//		clickToSidebar(MY_PRODUCT_REVIEW_LINK);
//		clickToLink(DYNAMIC_SIDEBAR_LINK_PGAE_NAME, "Customer info");
//		clickToLink(DYNAMIC_SIDEBAR_LINK_PGAE_NAME, "Addresses");
//		clickToLink(DYNAMIC_SIDEBAR_LINK_PGAE_NAME, "Reward points");
		clickToLink(DYNAMIC_LINK_PGAE_NAME, "account-navigation", "Addresses");
		clickToLink(DYNAMIC_LINK_PGAE_NAME, "footer-upper", "Search");
	}

//	public static void clickToSidebar(String locator) {
//		// System.out.println("Click to" + locator);
//
//	}

//	public static void clickToLink(String locatorDynamic, String pageName) {
//		// String locator = String.format(locatorDynamic, pageName);
//		// System.out.println("Locator is:" + locator);
//	}

//	public static void clickToLink(String locatorDynamic, String areName, String pageName) {
//		String locator = String.format(locatorDynamic, areName, pageName);
//		System.out.println("Locator is:" + locator);
//	}

	public static void clickToLink(String locatorDynamic, String...params) {
		String locator = String.format(locatorDynamic, (Object[]) params);
		System.out.println("Locator is:" + locator);
	}
}
