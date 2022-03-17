package pageObjects.nopCommerce.user.MenuPageObject;

import pageObjects.nopCommerce.user.BasePageUser;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.CompareProductsPageUI;

public class UserCompareProductsPageObject extends BasePageUser {
    private WebDriver driver;

    public UserCompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, CompareProductsPageUI.PRODUCT_BY_NAME, productName))
            return false;
        return true;
    }

    public void clickToClearListButton() {
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public String getResultMessage() {
        return getElementText(driver, CompareProductsPageUI.NO_DATA_MESSAGE);
    }
}
