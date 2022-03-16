package pageObjects.nopCommerce.user.MenuPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.WishlistPageUI;

public class UserWishlistPageObject extends BasePage {
    private WebDriver driver;

    public UserWishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, WishlistPageUI.PRODUCT_IN_WISHLIST_BY_NAME, productName))
            return false;
        return true;
    }

    public void clickToURLForSharing() {
        clickToElement(driver, WishlistPageUI.WISHLIST_URL_FOR_SHARING);
    }

    public void clickAddToCartByName(String productName) {
        int rowIndex = getElementSize(driver, WishlistPageUI.ROW_INDEX_BY_NAME, productName);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_ITEM_BY_ROW_INDEX, String.valueOf(rowIndex));
    }

    public UserShoppingCartPageObject clickAddToCartButton() {
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public void clickToRemoveByName(String productName) {
        int rowIndex = getElementSize(driver, WishlistPageUI.ROW_INDEX_BY_NAME, productName);
        clickToElement(driver, WishlistPageUI.REMOVE_ITEM_BY_ROW_INDEX, String.valueOf(rowIndex));
    }

    public void clickToUpdateWishlistButton() {
        if (!isElementUndisplayed(driver, WishlistPageUI.UPDATE_WISHLIST_BUTTON))
            clickToElement(driver, WishlistPageUI.UPDATE_WISHLIST_BUTTON);
    }

    public String getMessageWishlistEmpty() {
        waitForElementVisible(driver, WishlistPageUI.NO_DATA_MESSAGE);
        return getElementText(driver, WishlistPageUI.NO_DATA_MESSAGE);
    }

    public boolean isNoProductDisplayed() {
        return isElementUndisplayed(driver, WishlistPageUI.ALL_PRODUCT_IN_WISHLIST);
    }
}
