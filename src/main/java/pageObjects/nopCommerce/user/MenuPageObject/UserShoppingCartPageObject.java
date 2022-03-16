package pageObjects.nopCommerce.user.MenuPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.TopMenuPageUI.ShoppingCartPageUI;


public class UserShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public UserShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ALL_PRODUCT_IN_SHOPPING_CART, productName))
            return false;
        return true;
    }

    public UserMenuComputersPageObiect clickEditButtonInProductBuildComputer() {
        clickToElement(driver, ShoppingCartPageUI.EDIT_LINK_IN_PRODUCT_BUILD_COMPUTER);
        return PageGeneratorManager.getUserMenuComputersPage(driver);
    }

    public boolean isNumberQuantityDisplayByProductName(String productName, String numberBuy) {
        int rowIndex;
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName))
            rowIndex = 1;
        else rowIndex = getElementSize(driver, ShoppingCartPageUI.ROW_INDEX_BY_NAME_PRODUCT, productName) + 1;
        String result = getElementAttribute(driver, ShoppingCartPageUI.QUANTITY_VALUE, "value", String.valueOf(rowIndex));
        return result.equals(numberBuy);
    }
}
