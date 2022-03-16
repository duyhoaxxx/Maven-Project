package pageUIs.nopCommerce.user.TopMenuPageUI;

public class MenuComputersPageUI {
    public static final String DYNAMIC_TITLE_CATEGORY = "//h2[@class='title']//a[text()=' %s ']";
    public static final String DYNAMIC_PRODUCT_NAME = "//h2[@class='product-title']//a[text()='%s']";
    public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";

    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='add-to-wishlist']/button";
    public static final String ADD_TO_CART_BUTTON = "//button[@id='add-to-cart-button-1']";
    public static final String RESULT_MESSAGE = "//p[@class='content']";
    public static final String CLOSE_RESULT_MESSAGE_BUTON = "//div[@id='bar-notification']//span";

    public static final String PRODUCT_INDEX_BY_NAME = "//div[@class='item-box']//a[text()='%s']/preceding::div[@class='item-box']";
    public static final String ADD_TO_COMPARE_LIST_BUTTON_BY_NAME = "//div[@class='item-box']//a[text()='%s']//parent::h2//parent::div//button[@class='button-2 add-to-compare-list-button']";

    public static final String BUILD_COMPUTER_PROCESSOR_DROPDOWN = "//select[@id='product_attribute_1']";
    public static final String BUILD_COMPUTER_RAM_DROPDOWN = "//select[@id='product_attribute_2']";
    public static final String BUILD_COMPUTER_HDD_RADIO = "//label[text()='%s']";
    public static final String BUILD_COMPUTER_OS_RADIO = "//label[text()='%s']";
    public static final String BUILD_COMPUTER_SOFTWARE_CHECKBOX = "//label[text()='%s']/parent::li/input";
    public static final String BUILD_COMPUTER_NUMBER_BUY_TEXTBOX = "//input[@id='product_enteredQuantity_1']";

    public static final String PRODUCT_PRICE = "//div[@class='product-price']//span";
    public static final String UPDATE_BUTTON = "//button[@id='add-to-cart-button-1']";

}
