package pageUIs.nopCommerce.admin;

public class ADCustomersPageUI {
    public static final String ADD_NEW_CUSTOMER_BUTTON = "//div[@class='float-right']//a[@class='btn btn-primary']";
    public static final String NEWS_LETTER_DROPDOWN_BUTTON = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/parent::div";
    public static final String NEWS_LETTER_DROPDOWN_ITEM = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']//li";
    public static final String CUSTOMER_ROLES_DROPDOWN_BUTTON = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
    public static final String CUSTOMER_ROLES_DROPDOWN_ITEM = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String ALL_CUSTOMER_ROLES_ITEM_SELECTED = "//span[@title='delete']";

    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_CHECKBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_SELECTED_BY_NAME = "//span[normalize-space()='%s']";
    public static final String DYNAMIC_SELECTED_BY_ID = "//select[@id='%s']/option[@selected='selected']";

    public static final String ALL_NAME_IN_RESULT_SEARCH = "//tbody//tr//td[3]";
    public static final String CUSTOMER_ROLE_IN_RESULT_SEARCH_BY_TEXT = "//tbody//tr//td[text()='%s']";
    public static final String FIRST_EDIT_BUTTON_IN_RESULT = "//tbody/tr[1]//a[text()='Edit']";

    public static final String ALL_VALUE_IN_ROW_BY_EMAIL = "//td[normalize-space()='%s']/parent::tr/td";
    public static final String EDIT_BUTTON_BY_EMAIL = "//td[normalize-space()='%s']/parent::tr/td//a[text()='Edit']";
    public static final String DELETE_BUTTON_BY_EMAIL = "//td[normalize-space()='%s']/parent::tr/td//a[text()='Delete']";

}
