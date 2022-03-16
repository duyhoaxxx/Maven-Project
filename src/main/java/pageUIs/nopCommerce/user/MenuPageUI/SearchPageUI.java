package pageUIs.nopCommerce.user.MenuPageUI;

public class SearchPageUI {

    public static final String SEARCH_KEYWORD_TEXTBOX = "//input[@id='q']";
    public static final String ADVANCED_SEARCH_CHECKBOX = "//input[@id='advs']";
    public static final String SEARCH_BUTTON = "//button[@class='button-1 search-button']";
    public static final String ERR_MESSAGE = "//div[@class='warning']";
    public static final String NO_RESULT_MESSAGE = "//div[@class='no-result']";
    public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
    public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX = "//input[@id='isc']";
    public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
    public static final String SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX = "//input[@id='sid']";
    public static final String ALL_RESULTS_SEARCH = "//div[@class='item-grid']//h2[@class='product-title']//a";
    public static final String RESULTS_SEARCH_PRODUCT_BY_NAME = "//div[@class='item-grid']//h2[@class='product-title']//a[text()='%s']";
}
