package pageUIs.nopCommerce.user.MyAccountPageUI;

public class OrdersPageUI {
    public static final String ORDER_NUMBER = "//div[@class='title']//strong[text()='Order Number: %s']";
    public static final String ROW_INDEX_BY_ORDER_NUMBER = "//div[@class='title']//strong[text()='Order Number: %s']/preceding::div[@class='section order-item']";
    public static final String DETAILS_BUTTON = "(//div[@class='section order-item'])[%s]//div[@class='buttons']//button";
    public static final String ORDER_NUMBER_IN_ORDER_INFO = "//div[@class='order-number']";

    public static final String ORDER_DATE_IN_ORDER_INFO = "//div[@class='order-overview']//li[@class='order-date']";
    public static final String ORDER_TOTAL_IN_ORDER_INFO = "//div[@class='order-overview']//li[@class='order-total']/strong";

    public static final String SHIPPING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT = "//div[@class='shipping-info']//li[@class='%s']";
    public static final String BILLING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT = "//div[@class='billing-info']//li[@class='%s']";
    public static final String PAYMENT_METHOD_AT_CONFIRM_ORDER = "//div[@class='payment-method-info']//li[@class='payment-method']";
    public static final String SHIPPING_METHOD_AT_CONFIRM_ORDER = "//div[@class='shipping-method-info']//li[@class='shipping-method']//span[@class='value']";

    public static final String PRODUCT_NAME_AT_CONFIRM_ORDER = "//td[@class='product']//a[text()='%s']";
    public static final String ROW_INDEX_BY_NAME_PRODUCT = "//td[@class='product']//a[text()='%s']/preceding::td[@class='product']";
    public static final String QUANTITY_VALUE = "(//td[@class='quantity'])[%s]/span";
    public static final String UNIT_PRICE = "(//td[@class='unit-price'])[%s]/span";
    public static final String TOTAL_PRICE = "(//td[@class='total'])[%s]/span";

    public static final String REORDER_BUTTON = "//button[@class='button-1 re-order-button']";
}
