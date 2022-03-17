package pageUIs.nopCommerce.admin;

public class BasePageAdminUI {
    public static final String DYNAMIC_LEFT_MENU_BY_NAME = "//p[normalize-space()='%s']";
    public static final String CUSTOMERS_LEFT_MENU_DROPDOWN = "//a[@href='#']//p[contains(text(),'Customers')]";
    public static final String CUSTOMERS_LEFT_MENU_PAGE = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]";
    public static final String LEFT_HEADER_PAGE = "//h1[@class='float-left']";
}
