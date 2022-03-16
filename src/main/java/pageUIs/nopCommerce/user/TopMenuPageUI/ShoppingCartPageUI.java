package pageUIs.nopCommerce.user.TopMenuPageUI;

public class ShoppingCartPageUI {

    public static final String ALL_PRODUCT_IN_SHOPPING_CART = "//td[@class='product']//a[text()='%s']";
    public static final String EDIT_LINK_IN_PRODUCT_BUILD_COMPUTER = "//td[@class='product']//a[text()='Build your own computer']/parent::td//div[@class='edit-item']//a";

    public static final String ROW_INDEX_BY_NAME_PRODUCT = "//td[@class='product']//a[text()='%s']/preceding::td[@class='product']";
    public static final String QUANTITY_VALUE = "(//td[@class='quantity'])[%s]/input";
}
