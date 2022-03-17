package pageObjects.nopCommerce.user.MenuPageObject;

import pageObjects.nopCommerce.user.BasePageUser;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.CheckoutPageUI;

public class UserCheckoutPageObject extends BasePageUser {
    private WebDriver driver;

    public UserCheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToShipSameAddressCheckbox(boolean status) {
        if (isElementSelected(driver, CheckoutPageUI.SHIP_SAME_ADDRESS_CHECKBOX) != status)
            clickToElement(driver, CheckoutPageUI.SHIP_SAME_ADDRESS_CHECKBOX);
    }

    public void clickToContinueButtonBillingAddress() {
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_ADDRESS);
    }

    public void clickToContinueButtonShippingMethod() {
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
    }

    public void clickToPayByCheque() {
        clickToElement(driver, CheckoutPageUI.PAY_BY_CHEQUE_RADIO);
    }

    public void clickToPayByCreditCard() {
        clickToElement(driver, CheckoutPageUI.PAY_BY_CREDIT_CARD_RADIO);
    }

    public void clickToContinueButtonPaymentMethod() {
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_METHOD);
    }

    public void clickToContinueButtonPaymentInfo() {
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_INFO);
    }

    public void clickToContinueButtonShippingAddress() {
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_ADDRESS);
    }

    public void clickToConfirmButton() {
        clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
    }

    public String getMessageOrderSuccess() {
        return getElementText(driver, CheckoutPageUI.MESSAGE_ORDER_SUCCESS);
    }

    public String getOrderNumber() {
        return getElementText(driver, CheckoutPageUI.ORDER_NUMBER).replace("ORDER NUMBER: ", "").trim();
    }

    private boolean isBillingAddressInfo(String key, String value) {
        if (getElementText(driver, CheckoutPageUI.BILLING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT, key).contains(value))
            return true;
        return false;
    }

    public boolean isCheckInformationBillingAdr(GlobalConstants.AddressInformation addressInfo) {
        if (!isBillingAddressInfo("name", addressInfo.fName))
            return false;
        if (!isBillingAddressInfo("name", addressInfo.lName))
            return false;
        if (!isBillingAddressInfo("email", addressInfo.email))
            return false;
        if (!isBillingAddressInfo("phone", addressInfo.phoneNumber))
            return false;
        if (!isBillingAddressInfo("fax", addressInfo.faxNumber))
            return false;
        if (!isBillingAddressInfo("company", addressInfo.companyName))
            return false;
        if (!isBillingAddressInfo("address1", addressInfo.address1))
            return false;
        if (!isBillingAddressInfo("address2", addressInfo.address2))
            return false;
        if (!isBillingAddressInfo("city-state-zip", addressInfo.city))
            return false;
        if (!isBillingAddressInfo("city-state-zip", addressInfo.postalCode))
            return false;
        if (!isBillingAddressInfo("country", addressInfo.country))
            return false;
        return true;
    }

    private boolean isShippingAddressInfo(String key, String value) {
        if (getElementText(driver, CheckoutPageUI.SHIPPING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT, key).contains(value))
            return true;
        return false;
    }

    public boolean isCheckInformationShippingAdr(GlobalConstants.AddressInformation addressInfo) {
        if (!isShippingAddressInfo("name", addressInfo.fName))
            return false;
        if (!isShippingAddressInfo("name", addressInfo.lName))
            return false;
        if (!isShippingAddressInfo("email", addressInfo.email))
            return false;
        if (!isShippingAddressInfo("phone", addressInfo.phoneNumber))
            return false;
        if (!isShippingAddressInfo("fax", addressInfo.faxNumber))
            return false;
        if (!isShippingAddressInfo("company", addressInfo.companyName))
            return false;
        if (!isShippingAddressInfo("address1", addressInfo.address1))
            return false;
        if (!isShippingAddressInfo("address2", addressInfo.address2))
            return false;
        if (!isShippingAddressInfo("city-state-zip", addressInfo.city))
            return false;
        if (!isShippingAddressInfo("city-state-zip", addressInfo.postalCode))
            return false;
        if (!isShippingAddressInfo("country", addressInfo.country))
            return false;
        return true;
    }

    public boolean isCheckPaymentMethod(String payMethod) {
        return getElementText(driver, CheckoutPageUI.PAYMENT_METHOD_AT_CONFIRM_ORDER).contains(payMethod);
    }

    public boolean isCheckProductNameDisplay(String productName) {
        return isElementDisplay(driver, CheckoutPageUI.PRODUCT_NAME_AT_CONFIRM_ORDER, productName);
    }


    public String getNumberQuantityByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, CheckoutPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, CheckoutPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, CheckoutPageUI.QUANTITY_VALUE, String.valueOf(rowIndex));
        return result;
    }

    public String getUnitPriceByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, CheckoutPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, CheckoutPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, CheckoutPageUI.UNIT_PRICE, String.valueOf(rowIndex));
        return result;
    }

    public String getTotalPriceByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, CheckoutPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, CheckoutPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, CheckoutPageUI.TOTAL_PRICE, String.valueOf(rowIndex));
        return result;
    }

    public boolean isConfirmUnitPriceByName(String productName, String unitPrice) {
        return unitPrice.equals(getUnitPriceByProductName(productName));
    }

    public boolean isConfirmQtyByName(String productName, String numberQty) {
        return numberQty.equals(getNumberQuantityByProductName(productName));
    }

    public boolean isConfirmTotalPriceByName(String productName, String totalPrice) {
        return totalPrice.equals(getTotalPriceByProductName(productName));
    }

    public void clickToDetailsLink() {
        clickToElement(driver, CheckoutPageUI.DETAILS_LINK);
    }

    public String getOrderDate() {
        return getElementText(driver, CheckoutPageUI.ORDER_DATE_IN_ORDER_INFO);
    }

    public String getOrderTotal() {
        return getElementText(driver, CheckoutPageUI.ORDER_TOTAL_IN_ORDER_INFO);
    }

    public void inputVisaCardFormInPaymentInfo(String typeCard, String cardName, String cardNumber, String expMonth, String expYear, String cardCode) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.CARD_TYPE_PAYMENT_INFO_DROPDOWN, typeCard);
        senkeyToElement(driver, CheckoutPageUI.CARD_NAME_PAYMENT_INFO_TEXTBOX, cardName);
        senkeyToElement(driver, CheckoutPageUI.CARD_NUMBER_PAYMENT_INFO_TEXTBOX, cardNumber);
        selectItemInDefaultDropdown(driver, CheckoutPageUI.CARD_EXP_DATE_MONTH_PAYMENT_INFO_DROPDOWN, expMonth);
        selectItemInDefaultDropdown(driver, CheckoutPageUI.CARD_EXP_DATE_YEAR_PAYMENT_INFO_DROPDOWN, expYear);
        senkeyToElement(driver, CheckoutPageUI.CARD_CODE_PAYMENT_INFO_TEXTBOX, cardCode);
    }

    public void clickToShipMethodByGround() {
        clickToElement(driver, CheckoutPageUI.SHIPPING_BY_GROUND);
    }

    public void clickToShipMethodByNextDayAir() {
        clickToElement(driver, CheckoutPageUI.SHIPPING_BY_NEXT_DAY_AIR);
    }

    public void clickToShipMethodBy2ndDayAir() {
        clickToElement(driver, CheckoutPageUI.SHIPPING_BY_2ND_DAY_AIR);
    }

    public boolean isCheckShippingMethod(String shipMethod) {
        return getElementText(driver, CheckoutPageUI.SHIPPING_METHOD_AT_CONFIRM_ORDER).contains(shipMethod);
    }

    public void selectAddressInBillingAddress(String value) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_DROPDOWN, value);
    }

    public void inputNewAddressFormInBillingAddress(GlobalConstants.AddressInformation addressBilling) {
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.fName, "FirstName");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.lName, "LastName");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.email, "Email");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.companyName, "Company");
        selectItemInDefaultDropdown(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_DROPDOWN_BY_ID, addressBilling.country, "CountryId");
        selectItemInDefaultDropdown(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_DROPDOWN_BY_ID, addressBilling.state, "StateProvinceId");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.city, "City");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.address1, "Address1");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.address2, "Address2");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.postalCode, "ZipPostalCode");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.phoneNumber, "PhoneNumber");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_BILLING_TEXTBOX_BY_ID, addressBilling.faxNumber, "FaxNumber");
    }

    public void selectAddressInShippingAddress(String value) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_DROPDOWN, value);
    }


    public void inputNewAddressFormInShippingAddress(GlobalConstants.AddressInformation addressBilling) {
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.fName, "FirstName");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.lName, "LastName");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.email, "Email");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.companyName, "Company");
        selectItemInDefaultDropdown(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_DROPDOWN_BY_ID, addressBilling.country, "CountryId");
        selectItemInDefaultDropdown(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_DROPDOWN_BY_ID, addressBilling.state, "StateProvinceId");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.city, "City");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.address1, "Address1");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.address2, "Address2");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.postalCode, "ZipPostalCode");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.phoneNumber, "PhoneNumber");
        senkeyToElement(driver, CheckoutPageUI.NEW_ADDRESS_IN_SHIPPING_TEXTBOX_BY_ID, addressBilling.faxNumber, "FaxNumber");
    }

}
