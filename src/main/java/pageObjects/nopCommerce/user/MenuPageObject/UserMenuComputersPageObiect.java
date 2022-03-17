package pageObjects.nopCommerce.user.MenuPageObject;

import pageObjects.nopCommerce.user.BasePageUser;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.MenuPageUI.MenuComputersPageUI;

public class UserMenuComputersPageObiect extends BasePageUser {
    private WebDriver driver;

    public UserMenuComputersPageObiect(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSubCategoryByName(String titleName) {
        clickToElement(driver, MenuComputersPageUI.DYNAMIC_TITLE_CATEGORY, titleName);
    }

    public void clickToProductByName(String pName) {
        clickToElement(driver, MenuComputersPageUI.DYNAMIC_PRODUCT_NAME, pName);
    }

    public UserProductReviewsPageObiect clickToAddYourReviewLink() {
        clickToElement(driver, MenuComputersPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getProductReviewsPage(driver);
    }

    public void clickToAddToWishlistButton() {
        clickToElement(driver, MenuComputersPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public void clickToAddToCompareListButtonByName(String pName) {
        clickToElement(driver, MenuComputersPageUI.ADD_TO_COMPARE_LIST_BUTTON_BY_NAME, pName);
    }

    public void clickToAddToCartButton() {
        clickToElement(driver, MenuComputersPageUI.ADD_TO_CART_BUTTON);
    }

    public void clickOptionBuildYourOwnComputer(String opProcessor, String opRAM, String opHDD, String opOS, String opSoftware, String numberBuy) {
        selectItemInDefaultDropdown(driver, MenuComputersPageUI.BUILD_COMPUTER_PROCESSOR_DROPDOWN, opProcessor);
        selectItemInDefaultDropdown(driver, MenuComputersPageUI.BUILD_COMPUTER_RAM_DROPDOWN, opRAM);
        clickToElement(driver, MenuComputersPageUI.BUILD_COMPUTER_HDD_RADIO, opHDD);
        clickToElement(driver, MenuComputersPageUI.BUILD_COMPUTER_OS_RADIO, opOS);
        if (!isElementSelected(driver, MenuComputersPageUI.BUILD_COMPUTER_SOFTWARE_CHECKBOX, opSoftware))
            clickToElement(driver, MenuComputersPageUI.BUILD_COMPUTER_SOFTWARE_CHECKBOX, opSoftware);
        senkeyToElement(driver, MenuComputersPageUI.BUILD_COMPUTER_NUMBER_BUY_TEXTBOX, numberBuy);
    }

    public String getPriceProduct() {
        return getElementText(driver, MenuComputersPageUI.PRODUCT_PRICE);
    }

    public void clickToUpdateButton() {
        clickToElement(driver, MenuComputersPageUI.UPDATE_BUTTON);
    }
}
