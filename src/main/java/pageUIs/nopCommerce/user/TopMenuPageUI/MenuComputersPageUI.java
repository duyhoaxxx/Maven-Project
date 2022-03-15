package pageUIs.nopCommerce.user.TopMenuPageUI;

public class MenuComputersPageUI {
    public static final String DYNAMIC_TITLE_CATEGORY = "//h2[@class='title']//a[text()=' %s ']";
    public static final String DYNAMIC_PRODUCT_NAME = "//h2[@class='product-title']//a[text()='%s']";
    public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
    public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
    public static final String ALL_NAME_PRODUCT = "//div[@class='item-box']//h2[@class='product-title']/a";
    public static final String ALL_PRICE_PRODUCT = "//div[@class='item-box']//div[@class='prices']/span";

    public static final String LAST_PICTURE_PRODUCT = "(//div[@class='picture'])[last()]";
    public static final String PAGE_SIZE_BUTTON = "//select[@id='products-pagesize']";
    public static final String PAGING_BUTTON = "//div[@class='pager']";
    public static final String NEXT_PAGE_BUTTON = "//div[@class='pager']//li[@class='next-page']";
    public static final String PREVIOUS_PAGE_BUTTON = "//div[@class='pager']//li[@class='previous-page']";

    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='add-to-wishlist']/button";
    public static final String RESULT_MESSAGE = "//p[@class='content']";
    public static final String CLOSE_RESULT_MESSAGE_BUTON = "//div[@id='bar-notification']//span";



}
