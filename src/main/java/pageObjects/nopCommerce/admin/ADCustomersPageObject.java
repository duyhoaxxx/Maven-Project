package pageObjects.nopCommerce.admin;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommerce.admin.ADCustomersPageUI;

import java.util.List;

public class ADCustomersPageObject extends BasePageAdmin {
    private WebDriver driver;

    public ADCustomersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        clickToElement(driver, ADCustomersPageUI.ADD_NEW_BUTTON);
    }

    public void inputNewCustomerInfoForm(WebDriver driver, GlobalConstants.CustomerInfo customerInfo) {
        RemoveAllCustomerRoles();
        EnterToTextboxByID(driver, "Email", customerInfo.email);
        EnterToTextboxByID(driver, "Password", customerInfo.password);
        EnterToTextboxByID(driver, "FirstName", customerInfo.fname);
        EnterToTextboxByID(driver, "LastName", customerInfo.lname);
        if (customerInfo.gender.equals("Male"))
            ClickToRadioButtonByID(driver, "Gender_Male");
        else
            ClickToRadioButtonByID(driver, "Gender_Female");
        EnterToTextboxByID(driver, "DateOfBirth", customerInfo.DOB);
        EnterToTextboxByID(driver, "Company", customerInfo.companyName);
        ClickToCheckboxButtonByID(driver, "IsTaxExempt", customerInfo.isTaxExempt);
        SelectDropdownByID(driver, "VendorId", customerInfo.managerVender);
        ClickToCheckboxButtonByID(driver, "Active", customerInfo.isActive);
        EnterToTextareaByID(driver, "AdminComment", customerInfo.adminComment);
        SelectItemInCustomDropDown(driver, ADCustomersPageUI.NEWS_LETTER_DROPDOWN_BUTTON, ADCustomersPageUI.NEWS_LETTER_DROPDOWN_ITEM, customerInfo.newsletter);
        SelectItemInCustomDropDown(driver, ADCustomersPageUI.CUSTOMER_ROLES_DROPDOWN_BUTTON, ADCustomersPageUI.CUSTOMER_ROLES_DROPDOWN_ITEM, customerInfo.customerRoles);
    }

    private void RemoveAllCustomerRoles() {
        if (!isElementUndisplayed(driver, ADCustomersPageUI.ALL_CUSTOMER_ROLES_ITEM_SELECTED)) {
            List<WebElement> listElement = getListWebElement(driver, ADCustomersPageUI.ALL_CUSTOMER_ROLES_ITEM_SELECTED);
            for (WebElement element : listElement) {
                element.click();
            }
        }
    }

    public String getMessageNewCustomerAddSuccess() {
        return getElementText(driver, ADCustomersPageUI.MESSAGE_NEW_CUSTOMER_ADD_SUCCESS);
    }

    public boolean verifyNewCustomerInfo(GlobalConstants.CustomerInfo customerInfo) {
        if (!getValueTextFromTextboxByID("Email").equals(customerInfo.email))
            return false;
        if (!getValueTextFromTextboxByID("FirstName").equals(customerInfo.fname))
            return false;
        if (!getValueTextFromTextboxByID("LastName").equals(customerInfo.lname))
            return false;
        if (!getValueTextFromTextboxByID("DateOfBirth").equals(customerInfo.DOB))
            return false;
        if (!getValueTextFromTextboxByID("Company").equals(customerInfo.companyName))
            return false;
        if (!getGenderInCustomerForm().equals(customerInfo.gender))
            return false;
        if (!isSelectedDropdownByNameDisplay(customerInfo.newsletter))
            return false;
        if (!isSelectedDropdownByNameDisplay(customerInfo.customerRoles))
            return false;
        if (getValueFromCheckboxByID("Active") != customerInfo.isActive)
            return false;
        return true;
    }

    private String getValueTextFromTextboxByID(String id) {
        return getElementAttribute(driver, ADCustomersPageUI.DYNAMIC_TEXTBOX_BY_ID, "value", id);
    }

    private boolean getValueFromCheckboxByID(String id) {
        return Boolean.valueOf(getElementAttribute(driver, ADCustomersPageUI.DYNAMIC_CHECKBOX_BY_ID, "value", id));
    }

    private String getGenderInCustomerForm() {
        if (isElementSelected(driver, ADCustomersPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, "Gender_Male"))
            return "Male";
        if (isElementSelected(driver, ADCustomersPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, "Gender_Female"))
            return "Female";
        return null;
    }

    private boolean isSelectedDropdownByNameDisplay(String value) {
        return !isElementUndisplayed(driver, ADCustomersPageUI.DYNAMIC_SELECTED_BY_NAME, value);
    }

    public void clickToBackCustomerList() {
        clickToElement(driver, ADCustomersPageUI.BACK_CUSTOMER_LIST);
    }
}
