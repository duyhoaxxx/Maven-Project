package pageUIs.nopCommerce.user.MenuPageUI;

public class ShoppingCartPageUI {
    public static final String ALL_PRODUCT_IN_SHOPPING_CART = "//td[@class='product']//a";
    public static final String PRODUCT_IN_SHOPPING_CART_BY_NAME = "//td[@class='product']//a[text()='%s']";
    public static final String EDIT_LINK_IN_PRODUCT_BUILD_COMPUTER = "//td[@class='product']//a[text()='Build your own computer']/parent::td//div[@class='edit-item']//a";

    public static final String ROW_INDEX_BY_NAME_PRODUCT = "//td[@class='product']//a[text()='%s']/preceding::td[@class='product']";
    public static final String QUANTITY_VALUE = "(//td[@class='quantity'])[%s]/input";
    public static final String REMOVE_BUTTON = "(//td[@class='remove-from-cart'])[%s]/button";
    public static final String UNIT_PRICE = "(//td[@class='unit-price'])[%s]/span";
    public static final String TOTAL_PRICE = "(//td[@class='subtotal'])[%s]/span";
    public static final String INFORMATION_PRODUCT = "(//td[@class='product'])[%s]/div[@class='attributes']";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "//button[@id='updatecart']";
    public static final String NO_DATA_MESSAGE = "//div[@class='no-data']";

    public static final String AGREE_TERMS_OF_SERVICES_CHECKBOX = "//div[@class='terms-of-service']//input";
    public static final String CHECKOUT_BUTTON = "//button[@id='checkout']";
}
