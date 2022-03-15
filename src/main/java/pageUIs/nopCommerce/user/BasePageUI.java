package pageUIs.nopCommerce.user;

public class BasePageUI {

    public static final String WISHLIST_LINK_AT_USER = "//div[@class='header']//a[@class='ico-wishlist']";
    public static final String LOGOUT_LINK_AT_USER = "//a[@class='ico-logout']";
    public static final String LOGOUT_LINK_AT_ADMIN = "//a[text()='Logout']";

    public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//a[text()='%s']";
    public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";

    public static final String DYNAMIC_MY_ACCOUNT_PAGE_TITLE = "//div[@class='page-title']//h1[text()='My account - %s']";
    public static final String DYNAMIC_MY_ACCOUNT_PAGE_LINK = "//div[@class='listbox']//a[text()='%s']";
    public static final String DYNAMIC_PAGE_TITLE = "//div[@class='page-title']//h1[text()='%s']";
    public static final String DYNAMIC_TOP_MENU = "//ul[@class='top-menu notmobile']//a[text()='%s']";
}
