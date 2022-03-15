package pageObjects.nopCommerce.user.TopMenuPageObject;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommerce.user.TopMenuPageUI.MenuComputersPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void clickToSortByDropdown(String key) {
        selectItemInDefaultDropdown(driver, MenuComputersPageUI.SORT_BY_DROPDOWN, key);
        sleepInSecond(2);
        waitForElementClickable(driver, MenuComputersPageUI.LAST_PICTURE_PRODUCT);
    }

    public boolean isSortedNameAscending() {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementName = getListWebElement(driver, MenuComputersPageUI.ALL_NAME_PRODUCT);
        for (WebElement element : listElementName) {
            listResults.add(element.getText());
        }
        List<String> listSort = new ArrayList<>();
        for (String item : listResults) {
            listSort.add(item);
        }
        Collections.sort(listSort);
        return listSort.equals(listResults);
    }

    public boolean isSortedNameDescending() {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementName = getListWebElement(driver, MenuComputersPageUI.ALL_NAME_PRODUCT);
        for (WebElement element : listElementName) {
            listResults.add(element.getText());
        }
        List<String> listSort = new ArrayList<>();
        for (String item : listResults) {
            listSort.add(item);
        }
        Collections.sort(listSort);
        Collections.reverse(listSort);
        return listSort.equals(listResults);
    }

    public boolean isSortedPriceAscending() {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementPrice = getListWebElement(driver, MenuComputersPageUI.ALL_PRICE_PRODUCT);
        for (WebElement element : listElementPrice) {
            listResults.add(element.getText());
        }
        List<String> listSort = new ArrayList<>();
        for (String item : listResults) {
            listSort.add(item);
        }
        Collections.sort(listSort);
        return listSort.equals(listResults);

    }

    public boolean isSortedPriceDescending() {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementPrice = getListWebElement(driver, MenuComputersPageUI.ALL_PRICE_PRODUCT);
        for (WebElement element : listElementPrice) {
            listResults.add(element.getText());
        }
        List<String> listSort = new ArrayList<>();
        for (String item : listResults) {
            listSort.add(item);
        }
        Collections.sort(listSort);
        Collections.reverse(listSort);
        return listSort.equals(listResults);
    }

    public void clickToPageSizeButton(String key) {
        selectItemInDefaultDropdown(driver, MenuComputersPageUI.PAGE_SIZE_BUTTON, key);
        sleepInSecond(2);
    }

    public boolean isNumberProductDisplay(int value) {
        return (getElementSize(driver, MenuComputersPageUI.ALL_NAME_PRODUCT) > value) ? false : true;
    }

    public boolean isPagingButtonDisplay() {
        return !isElementUndisplayed(driver, MenuComputersPageUI.PAGING_BUTTON);
    }

    public boolean isNextPageButtonDisplay() {
        return !isElementUndisplayed(driver, MenuComputersPageUI.NEXT_PAGE_BUTTON);
    }

    public boolean isPreviousPageButtonDisplay() {
        return !isElementUndisplayed(driver, MenuComputersPageUI.PREVIOUS_PAGE_BUTTON);
    }

    public void clickToNextPageButton() {
        if (isNextPageButtonDisplay())
            clickToElement(driver, MenuComputersPageUI.NEXT_PAGE_BUTTON);
        sleepInSecond(2);
    }

    public void clickToPreviousPageButton() {
        if (isPreviousPageButtonDisplay())
            clickToElement(driver, MenuComputersPageUI.PREVIOUS_PAGE_BUTTON);
        sleepInSecond(2);
    }

    public void clickToAddToWishlistButton() {
        clickToElement(driver, MenuComputersPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public String getMessageResult() {
        String result = getElementText(driver, MenuComputersPageUI.RESULT_MESSAGE);
        clickToElement(driver, MenuComputersPageUI.CLOSE_RESULT_MESSAGE_BUTON);
        return result;
    }
}
