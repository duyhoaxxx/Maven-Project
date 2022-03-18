package pageObjects.nopCommerce.user.MyAccountPageObject;

import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.BasePageUser;
import pageObjects.nopCommerce.user.MenuPageObject.UserShoppingCartPageObject;
import pageUIs.nopCommerce.user.MyAccountPageUI.OrdersPageUI;

public class UserOrdersPageObject extends BasePageUser {
    private WebDriver driver;

    public UserOrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderNumberDisplay(String orderNumber) {
        return isElementDisplay(driver, OrdersPageUI.ORDER_NUMBER, orderNumber);
    }

    public void clickToDetailsButtonByOrderNumber(String orderNumber) {
        int rowIndex;
        if (isElementUndisplayed(driver, OrdersPageUI.ROW_INDEX_BY_ORDER_NUMBER, orderNumber))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, OrdersPageUI.ROW_INDEX_BY_ORDER_NUMBER, orderNumber) + 1;
        clickToElement(driver, OrdersPageUI.DETAILS_BUTTON, String.valueOf(rowIndex));
    }

    public boolean isOpenDetailsOrderByNumber(String orderNumber) {
        return getElementText(driver, OrdersPageUI.ORDER_NUMBER_IN_ORDER_INFO).contains(orderNumber);

    }

    public String getOrderDate() {
        return getElementText(driver, OrdersPageUI.ORDER_DATE_IN_ORDER_INFO);
    }

    public String getOrderTotal() {
        return getElementText(driver, OrdersPageUI.ORDER_TOTAL_IN_ORDER_INFO);
    }

    public boolean isOrderDateVerify(String orderDate) {
        return orderDate.equals(getOrderDate());
    }

    public boolean isOrderTotalVerify(String orderTotal) {
        return orderTotal.equals(getOrderTotal());
    }

    private boolean isBillingAddressInfo(String key, String value) {
        if (getElementText(driver, OrdersPageUI.BILLING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT, key).contains(value))
            return true;
        return false;
    }

    public boolean isCheckInformationBillingAdr(GlobalConstants.AddressInfo addressInfo) {
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
        if (getElementText(driver, OrdersPageUI.SHIPPING_ADDRESS_AT_CONFIRM_ORDER_BY_TEXT, key).contains(value))
            return true;
        return false;
    }

    public boolean isCheckInformationShippingAdr(GlobalConstants.AddressInfo addressInfo) {
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
        return getElementText(driver, OrdersPageUI.PAYMENT_METHOD_AT_CONFIRM_ORDER).contains(payMethod);
    }

    public boolean isCheckProductNameDisplay(String productName) {
        return isElementDisplay(driver, OrdersPageUI.PRODUCT_NAME_AT_CONFIRM_ORDER, productName);
    }


    public String getNumberQuantityByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, OrdersPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, OrdersPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, OrdersPageUI.QUANTITY_VALUE, String.valueOf(rowIndex));
        return result;
    }

    public String getUnitPriceByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, OrdersPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, OrdersPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, OrdersPageUI.UNIT_PRICE, String.valueOf(rowIndex));
        return result;
    }

    public String getTotalPriceByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, OrdersPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, OrdersPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, OrdersPageUI.TOTAL_PRICE, String.valueOf(rowIndex));
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


    public boolean isCheckShippingMethod(String shipMethod) {
        return getElementText(driver, OrdersPageUI.SHIPPING_METHOD_AT_CONFIRM_ORDER).contains(shipMethod);
    }

    public UserShoppingCartPageObject clickToReOrderButton() {
        clickToElement(driver, OrdersPageUI.REORDER_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }
}
