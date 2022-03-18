package pageUIs.nopCommerce.admin;

public class BasePageAdminUI {
    public static final String LOADING_PAGE_ICON = "//div[@id='ajaxBusy']";
    public static final String DYNAMIC_LEFT_MENU_BY_NAME = "//p[normalize-space()='%s']";
    public static final String DYNAMIC_LINK_BY_TEXT = "//a[normalize-space()='%s']";
    public static final String CUSTOMERS_LEFT_MENU_DROPDOWN = "//a[@href='#']//p[contains(text(),'Customers')]/parent::a";
    public static final String CUSTOMERS_LEFT_MENU_PAGE = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]/parent::a";
    public static final String NO_DATA_IN_TABLE_MESSAGE_BY_ID = "//div[@id='%s']//td[@class='dataTables_empty']";
    public static final String ALL_RESULT_DATA_SEARCH = "//tbody/tr";
    public static final String LEFT_HEADER_PAGE = "//h1[@class='float-left']";
    public static final String LEFT_HEADER_PAGE_BY_NAME = "//h1[@class='float-left'][contains(text(),'%s')]";
    public static final String MESSAGE_SUCCESS = "//div[@class='alert alert-success alert-dismissable']";
    public static final String CLOSE_MESSAGE_NOTIFY_BUTTON = "//button[contains(text(),'×')]";

    public static final String SEARCH_TAB_OPEN = "//div[text()='Search']/parent::div//i[@class='far fa-angle-down']";
    public static final String OPEN_TAB_BY_NAME = "//div[contains(text(),'%s')]//parent::div//i[@class='fa toggle-icon fa-plus']";
}
