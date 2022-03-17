package pageUIs.nopCommerce.user.MenuPageUI;

public class CheckoutPageUI {
    public static final String SHIP_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";
    public static final String CONTINUE_BUTTON_AT_BILLING_ADDRESS = "//div[@id='checkout-step-billing']//button[text()='Continue']";
    public static final String CONTINUE_BUTTON_AT_SHIPPING_ADDRESS = "//div[@id='checkout-step-shipping']//button[text()='Continue']";
    public static final String CONTINUE_BUTTON_AT_SHIPPING_METHOD = "//div[@id='checkout-step-shipping-method']//button[text()='Continue']";
    public static final String CONTINUE_BUTTON_AT_PAYMENT_METHOD = "//div[@id='checkout-step-payment-method']//button[text()='Continue']";
    public static final String CONTINUE_BUTTON_AT_PAYMENT_INFO = "//div[@id='checkout-step-payment-info']//button[text()='Continue']";
    public static final String CONFIRM_BUTTON = "//div[@id='checkout-step-confirm-order']//button[text()='Confirm']";

    public static final String PAY_BY_CHEQUE_RADIO = "//input[@id='paymentmethod_0']";
    public static final String PAY_BY_CREDIT_CARD_RADIO = "//input[@id='paymentmethod_1']";

    public static final String MESSAGE_ORDER_SUCCESS = "//div[@class='section order-completed']//div[@class='title']";
    public static final String ORDER_NUMBER = "//div[@class='order-number']";


    public static final String SHIPPING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT = "//div[@class='shipping-info']//li[@class='%s']";
    public static final String BILLING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT = "//div[@class='billing-info']//li[@class='%s']";
    public static final String PAYMENT_METHOD_AT_CONFIRM_ORDER = "//div[@class='payment-method-info']//li[@class='payment-method']";

    public static final String PRODUCT_NAME_AT_CONFIRM_ORDER = "//td[@class='product']//a[text()='%s']";
    public static final String ROW_INDEX_BY_NAME_PRODUCT = "//td[@class='product']//a[text()='%s']/preceding::td[@class='product']";
    public static final String QUANTITY_VALUE = "(//td[@class='quantity'])[%s]/span";
    public static final String UNIT_PRICE = "(//td[@class='unit-price'])[%s]/span";
    public static final String TOTAL_PRICE = "(//td[@class='subtotal'])[%s]/span";

    public static final String DETAILS_LINK = "//div[@class='details-link']/a";
    public static final String ORDER_DATE_IN_ORDER_INFO = "//div[@class='order-overview']//li[@class='order-date']";
    public static final String ORDER_TOTAL_IN_ORDER_INFO = "//div[@class='order-overview']//li[@class='order-total']/strong";


}
