package pageObjects.nopCommerce.user.MenuPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.ShoppingCartPageUI;


public class UserShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public UserShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, ShoppingCartPageUI.PRODUCT_IN_SHOPPING_CART_BY_NAME, productName))
            return false;
        return true;
    }

    public UserMenuComputersPageObiect clickEditButtonInProductBuildComputer() {
        clickToElement(driver, ShoppingCartPageUI.EDIT_LINK_IN_PRODUCT_BUILD_COMPUTER);
        return PageGeneratorManager.getUserMenuComputersPage(driver);
    }

    public String getNumberQuantityByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementAttribute(driver, ShoppingCartPageUI.QUANTITY_VALUE, "value", String.valueOf(rowIndex));
        return result;
    }

    public String getUnitPriceByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, ShoppingCartPageUI.UNIT_PRICE, String.valueOf(rowIndex));
        return result;
    }

    public String getTotalPriceByProductName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementText(driver, ShoppingCartPageUI.TOTAL_PRICE, String.valueOf(rowIndex));
        return result;
    }

    public void clickToRemoveButtonByNameProduct(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON, String.valueOf(rowIndex));
    }

    private String getInformationProductByName(String productName) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.INFORMATION_PRODUCT, String.valueOf(rowIndex)))
            return null;
        result = getElementText(driver, ShoppingCartPageUI.INFORMATION_PRODUCT, String.valueOf(rowIndex));
        return result;
    }

    public boolean isInfomationProduct(String productName, String opProcessor, String opRAM, String opHDD, String opOS, String opSoftware) {
        String result = getInformationProductByName(productName);
        if (result != null) {
            if (result.contains(opProcessor) && result.contains(opRAM) && result.contains(opHDD) && result.contains(opOS) && result.contains(opSoftware))
                return true;
            return false;
        }
        return false;
    }

    public boolean isTotalPriceProduct(String productName, String numberBuy) {
        float unitPrice = Float.parseFloat(getUnitPriceByProductName(productName).replace("$", "").replace(",", "").trim());
        float totalPrice = Float.parseFloat(getTotalPriceByProductName(productName).replace("$", "").replace(",", "").trim());
        return totalPrice == (unitPrice * Float.parseFloat(numberBuy));
    }

    public void clickToUpdateShoppingCartButton() {
        if (!isElementUndisplayed(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON))
            clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
    }

    public String getResultMessage() {
        return getElementText(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
    }

    public int getNumberProductInShoppingCart() {
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ALL_PRODUCT_IN_SHOPPING_CART))
            return 0;
        else
            return getElementSize(driver, ShoppingCartPageUI.ALL_PRODUCT_IN_SHOPPING_CART);

    }

    public void inputToQuantityByProductName(String productName, String number) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        senkeyToElement(driver, ShoppingCartPageUI.QUANTITY_VALUE, number, String.valueOf(rowIndex));
    }

    public void clickToAgreeWithTermsOfServices(boolean status) {
        if (isElementSelected(driver, ShoppingCartPageUI.AGREE_TERMS_OF_SERVICES_CHECKBOX) != status)
            clickToElement(driver, ShoppingCartPageUI.AGREE_TERMS_OF_SERVICES_CHECKBOX);
    }

    public UserCheckoutPageObject clickToCheckoutButton() {
        clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        return PageGeneratorManager.getCheckoutPage(driver);
    }
}
