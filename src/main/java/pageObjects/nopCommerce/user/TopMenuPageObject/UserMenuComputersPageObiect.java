package pageObjects.nopCommerce.user.TopMenuPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.TopMenuPageUI.MenuComputersPageUI;

public class UserMenuComputersPageObiect extends BasePage {
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

    public String getMessageResult() {
        String result = getElementText(driver, MenuComputersPageUI.RESULT_MESSAGE);
        clickToElement(driver, MenuComputersPageUI.CLOSE_RESULT_MESSAGE_BUTON);
        return result;
    }

    public void clickToAddToCompareListButtonByName(String pName) {
        clickToElement(driver,MenuComputersPageUI.ADD_TO_COMPARE_LIST_BUTTON_BY_NAME,pName);
    }
}
