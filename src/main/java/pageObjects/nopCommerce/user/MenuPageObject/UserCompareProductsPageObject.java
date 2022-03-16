package pageObjects.nopCommerce.user.MenuPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.CompareProductsPageUI;

public class UserCompareProductsPageObject extends BasePage {
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
        waitForElementVisible(driver, CompareProductsPageUI.NO_DATA_MESSAGE);
        return getElementText(driver, CompareProductsPageUI.NO_DATA_MESSAGE);
    }
}
