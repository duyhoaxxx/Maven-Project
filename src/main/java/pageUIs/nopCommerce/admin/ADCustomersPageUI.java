package pageUIs.nopCommerce.admin;

public class ADCustomersPageUI {
    public static final String ADD_NEW_BUTTON = "//a[@class='btn btn-primary']";
    public static final String NEWS_LETTER_DROPDOWN_BUTTON = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/parent::div";
    public static final String NEWS_LETTER_DROPDOWN_ITEM = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']//li";
    public static final String CUSTOMER_ROLES_DROPDOWN_BUTTON = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
    public static final String CUSTOMER_ROLES_DROPDOWN_ITEM = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String ALL_CUSTOMER_ROLES_ITEM_SELECTED = "//span[@title='delete']";

    public static final String MESSAGE_NEW_CUSTOMER_ADD_SUCCESS = "//div[@class='alert alert-success alert-dismissable']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_CHECKBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_SELECTED_BY_NAME = "//span[normalize-space()='%s']";

    public static final String BACK_CUSTOMER_LIST = "//a[normalize-space()='back to customer list']";


}
