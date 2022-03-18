package pageObjects.nopCommerce.admin;

import commons.GlobalConstants;
import org.openqa.selenium.JavascriptExecutor;
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
        waitForElementVisible(driver, ADCustomersPageUI.ADD_NEW_CUSTOMER_BUTTON);
        clickToElementByJS(driver, ADCustomersPageUI.ADD_NEW_CUSTOMER_BUTTON);
    }

    public void inputCustomerInfoForm(GlobalConstants.CustomerInfo customerInfo) {
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
        ClickToCheckboxButtonByID(driver, "Active", customerInfo.isActive);
        SelectDropdownByID(driver, "VendorId", customerInfo.managerVender);
        SelectItemInCustomDropDown(driver, ADCustomersPageUI.CUSTOMER_ROLES_DROPDOWN_BUTTON, ADCustomersPageUI.CUSTOMER_ROLES_DROPDOWN_ITEM, customerInfo.customerRoles);
        SelectItemInCustomDropDown(driver, ADCustomersPageUI.NEWS_LETTER_DROPDOWN_BUTTON, ADCustomersPageUI.NEWS_LETTER_DROPDOWN_ITEM, customerInfo.newsletter);
        EnterToTextareaByID(driver, "AdminComment", customerInfo.adminComment);
    }

    public void RemoveAllCustomerRoles() {
        if (!isElementUndisplayed(driver, ADCustomersPageUI.ALL_CUSTOMER_ROLES_ITEM_SELECTED)) {
            List<WebElement> listElement = getListWebElement(driver, ADCustomersPageUI.ALL_CUSTOMER_ROLES_ITEM_SELECTED);
            for (WebElement element : listElement) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].click();", element);
                sleepInSecond(1);
            }
        }
    }

    public void SelectItemInCustomerRoleByText(String value) {
        SelectItemInCustomDropDown(driver, ADCustomersPageUI.CUSTOMER_ROLES_DROPDOWN_BUTTON, ADCustomersPageUI.CUSTOMER_ROLES_DROPDOWN_ITEM, value);
    }

    public boolean verifyCustomerInfo(GlobalConstants.CustomerInfo customerInfo) {
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

    public boolean isNameDisplayedInResultCustemerSearch(String name) {
        System.out.println(name);
        List<WebElement> listWE = getListWebElement(driver, ADCustomersPageUI.ALL_NAME_IN_RESULT_SEARCH);
        for (WebElement element : listWE) {
            System.out.println(element.getText());
            if (element.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isResultSearchByCustemerRole(String customerRoles) {
        return !isElementUndisplayed(driver, ADCustomersPageUI.CUSTOMER_ROLE_IN_RESULT_SEARCH_BY_TEXT, customerRoles);
    }

    public void clickToEditButtonInFirstResultSearchCustomer() {
        waitForElementVisible(driver, ADCustomersPageUI.FIRST_EDIT_BUTTON_IN_RESULT);
        clickToElementByJS(driver, ADCustomersPageUI.FIRST_EDIT_BUTTON_IN_RESULT);
        sleepInSecond(2);
    }

    public void inputAddressInfoForm(GlobalConstants.AddressInfo addressInfo) {
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_FirstName", addressInfo.fName);
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_LastName", addressInfo.lName);
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_Email", addressInfo.email);
        EnterToTextboxByID(driver, "Address_Company", addressInfo.companyName);
        SelectDropdownByID(driver, "Address_CountryId", addressInfo.country);
        SelectDropdownByID(driver, "Address_StateProvinceId", addressInfo.state);
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_City", addressInfo.city);
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_Address1", addressInfo.address1);
        EnterToTextboxByID(driver, "Address_Address2", addressInfo.address2);
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_ZipPostalCode", addressInfo.postalCode);
        sleepInSecond(2);
        EnterToTextboxByID(driver, "Address_PhoneNumber", addressInfo.phoneNumber);
        EnterToTextboxByID(driver, "Address_FaxNumber", addressInfo.faxNumber);

        ClickToButtonByText(driver, "Save");
        Loaded(driver);
    }

    public boolean verifyAddressInfo(GlobalConstants.AddressInfo addressInfo) {
        if (!getValueTextFromTextboxByID("Address_FirstName").equals(addressInfo.fName))
            return false;
        if (!getValueTextFromTextboxByID("Address_LastName").equals(addressInfo.lName))
            return false;
        if (!getValueTextFromTextboxByID("Address_Email").equals(addressInfo.email))
            return false;
        if (!getValueTextFromTextboxByID("Address_Company").equals(addressInfo.companyName))
            return false;
        if (!getSelectedDropdownByID("Address_CountryId").equals(addressInfo.country))
            return false;
        if (!getValueTextFromTextboxByID("Address_City").equals(addressInfo.city))
            return false;
        if (!getValueTextFromTextboxByID("Address_Address1").equals(addressInfo.address1))
            return false;
        if (!getValueTextFromTextboxByID("Address_Address2").equals(addressInfo.address2))
            return false;
        if (!getValueTextFromTextboxByID("Address_ZipPostalCode").equals(addressInfo.postalCode))
            return false;
        if (!getValueTextFromTextboxByID("Address_PhoneNumber").equals(addressInfo.phoneNumber))
            return false;
        if (!getValueTextFromTextboxByID("Address_FaxNumber").equals(addressInfo.faxNumber))
            return false;
        return true;
    }

    private String getSelectedDropdownByID(String id) {
        return getElementText(driver, ADCustomersPageUI.DYNAMIC_SELECTED_BY_ID, id);
    }

    public boolean verifyAddressInfoInCustomerByEmail(GlobalConstants.AddressInfo addressInfo) {
        boolean isFname = false, isLname = false, isPhone = false;
        List<WebElement> listElement = getListWebElement(driver, ADCustomersPageUI.ALL_VALUE_IN_ROW_BY_EMAIL, addressInfo.email);
        for (WebElement firstName : listElement) {
            if (firstName.getText().equals(addressInfo.fName)) {
                isFname = true;
                break;
            }
        }
        for (WebElement lastName : listElement) {
            if (lastName.getText().equals(addressInfo.lName)) {
                isLname = true;
                break;
            }
        }
        for (WebElement phone : listElement) {
            if (phone.getText().equals(addressInfo.phoneNumber)) {
                isPhone = true;
                break;
            }
        }
        return (isFname && isLname && isPhone);
    }

    public void clickToEditButtonByEmail(String email) {
        clickToElementByJS(driver, ADCustomersPageUI.EDIT_BUTTON_BY_EMAIL, email);
    }

    public void clickToDeleteButtonByEmail(String email) {
        clickToElementByJS(driver, ADCustomersPageUI.DELETE_BUTTON_BY_EMAIL, email);
    }
}
