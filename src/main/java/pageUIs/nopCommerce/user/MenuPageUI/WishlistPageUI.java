package pageUIs.nopCommerce.user.MenuPageUI;

public class WishlistPageUI {

    public static final String ALL_PRODUCT_IN_WISHLIST = "//td[@class='product']//a[@class='product-name']";
    public static final String PRODUCT_IN_WISHLIST_BY_NAME = "//td[@class='product']//a[text()='%s']";
    public static final String WISHLIST_URL_FOR_SHARING = "//a[@class='share-link']";

    public static final String ROW_INDEX_BY_NAME = "//a[text()='%s']/preceding::td[@class='add-to-cart']";
    public static final String ADD_TO_CART_ITEM_BY_ROW_INDEX = "//tr[%s]//td[@class='add-to-cart']";
    public static final String REMOVE_ITEM_BY_ROW_INDEX = "//tr[%s]//td[@class='remove-from-cart']/button";
    public static final String ADD_TO_CART_BUTTON = "//button[@name='addtocartbutton']";
    public static final String UPDATE_WISHLIST_BUTTON = "//button[@id='updatecart']";
    public static final String NO_DATA_MESSAGE = "//div[@class='no-data']";

}
