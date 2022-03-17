package pageObjects.nopCommerce.user.MenuPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.CheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
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
}
