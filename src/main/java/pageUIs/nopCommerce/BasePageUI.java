package pageUIs.nopCommerce;

public class BasePageUI {

    public static final String WISHLIST_LINK_AT_USER = "//div[@class='header']//a[@class='ico-wishlist']";
    public static final String SHOPPING_CART_LINK_AT_USER = "//div[@class='header']//a[@class='ico-cart']";
    public static final String LOGOUT_LINK_AT_USER = "//div[@class='header']//a[@class='ico-logout']";
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
    public static final String DYNAMIC_TOP_MENU = "//ul[@class='top-menu notmobile']//a[@href='/%s']";

    public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
    public static final String ALL_NAME_PRODUCT = "//div[@class='item-box']//h2[@class='product-title']/a";
    public static final String PRODUCT_DISPLAY_BY_NAME = "//div[@class='item-box']//h2[@class='product-title']/a[text()='%s']";
    public static final String ALL_PRICE_PRODUCT = "//div[@class='item-box']//div[@class='prices']/span";
    public static final String ALL_NAME_IN_MINI_SHOPPING_CART = "//div[@class='name']//a[text()='%s']";
    public static final String PAGE_SIZE_BUTTON = "//select[@id='products-pagesize']";
    public static final String PAGING_BUTTON = "//div[@class='pager']";
    public static final String NEXT_PAGE_BUTTON = "//div[@class='pager']//li[@class='next-page']";
    public static final String PREVIOUS_PAGE_BUTTON = "//div[@class='pager']//li[@class='previous-page']";

    public static final String MESSAGE_BAR_NOTIFICARTION = "//div[@id='bar-notification']//p[@class='content']";
    public static final String CLOSE_BAR_NOTIFICARTION_BUTTON = "//div[@id='bar-notification']//span";

}
