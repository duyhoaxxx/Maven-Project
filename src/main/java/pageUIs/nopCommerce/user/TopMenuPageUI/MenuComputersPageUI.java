package pageUIs.nopCommerce.user.TopMenuPageUI;

public class MenuComputersPageUI {
    public static final String DYNAMIC_TITLE_CATEGORY = "//h2[@class='title']//a[text()=' %s ']";
    public static final String DYNAMIC_PRODUCT_NAME = "//h2[@class='product-title']//a[text()='%s']";
    public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";

    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='add-to-wishlist']/button";
    public static final String RESULT_MESSAGE = "//p[@class='content']";
    public static final String CLOSE_RESULT_MESSAGE_BUTON = "//div[@id='bar-notification']//span";

    public static final String PRODUCT_INDEX_BY_NAME = "//div[@class='item-box']//a[text()='%s']/preceding::div[@class='item-box']";
    public static final String ADD_TO_COMPARE_LIST_BUTTON_BY_NAME = "//div[@class='item-box']//a[text()='%s']//parent::h2//parent::div//button[@class='button-2 add-to-compare-list-button']";

}
