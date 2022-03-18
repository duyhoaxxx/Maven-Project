package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.nopCommerce.admin.ADLoginPageObject;
import pageObjects.nopCommerce.user.MenuPageObject.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.MenuPageObject.UserWishlistPageObject;
import pageUIs.nopCommerce.user.BasePageUserUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePageUser extends BasePage {

    public void openHeaderPageByName(WebDriver driver, String headerPage) {
        String locator = getDynamicXpath(BasePageUserUI.DYNAMIC_PAGE_HEADER, headerPage);
        waitForElementClickable(driver, locator);
        clickToElement(driver, locator);
    }

    public void openFooterPageByName(WebDriver driver, String footerPage) {
        String locator = getDynamicXpath(BasePageUserUI.DYNAMIC_PAGE_FOOTER, footerPage);
        waitForElementClickable(driver, locator);
        clickToElement(driver, locator);
    }

    public UserHomePageObject ClickToLogoutLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUserUI.LOGOUT_LINK_AT_USER);
        clickToElementByJS(driver, BasePageUserUI.LOGOUT_LINK_AT_USER);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public UserWishlistPageObject ClickToWishlistLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUserUI.WISHLIST_LINK_AT_USER);
        clickToElementByJS(driver, BasePageUserUI.WISHLIST_LINK_AT_USER);
        return PageGeneratorManager.getWishlistPage(driver);
    }

    public UserShoppingCartPageObject ClickToShoppingCartLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUserUI.SHOPPING_CART_LINK_AT_USER);
        clickToElementByJS(driver, BasePageUserUI.SHOPPING_CART_LINK_AT_USER);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public boolean isMyAccountPageTitleDisplayedByName(WebDriver driver, String pageName) {
        String locator = getDynamicXpath(BasePageUserUI.DYNAMIC_MY_ACCOUNT_PAGE_TITLE, pageName);
        return isElementDisplay(driver, locator);
    }

    public boolean isPageTitleDisplayedByName(WebDriver driver, String pageName) {
        String locator = getDynamicXpath(BasePageUserUI.DYNAMIC_PAGE_TITLE, pageName);
        return isElementDisplay(driver, locator);
    }

    public void openMyAccountPageByName(WebDriver driver, String pageName) {
        String locator = getDynamicXpath(BasePageUserUI.DYNAMIC_MY_ACCOUNT_PAGE_LINK, pageName);
        clickToElementByJS(driver, locator);
    }

    public void openTopMenuByName(WebDriver driver, String menuName) {
        clickToElement(driver, BasePageUserUI.DYNAMIC_TOP_MENU, menuName);
    }

    public void clickToSortByDropdown(WebDriver driver, String key) {
        selectItemInDefaultDropdown(driver, BasePageUserUI.SORT_BY_DROPDOWN, key);
        sleepInSecond(2);
    }

    public boolean isSortedNameAscending(WebDriver driver) {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementName = getListWebElement(driver, BasePageUserUI.ALL_NAME_PRODUCT);
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

    public boolean isSortedNameDescending(WebDriver driver) {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementName = getListWebElement(driver, BasePageUserUI.ALL_NAME_PRODUCT);
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

    public boolean isSortedPriceAscending(WebDriver driver) {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementPrice = getListWebElement(driver, BasePageUserUI.ALL_PRICE_PRODUCT);
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

    public boolean isSortedPriceDescending(WebDriver driver) {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementPrice = getListWebElement(driver, BasePageUserUI.ALL_PRICE_PRODUCT);
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

    public void clickToPageSizeButton(WebDriver driver, String key) {
        selectItemInDefaultDropdown(driver, BasePageUserUI.PAGE_SIZE_BUTTON, key);
        sleepInSecond(2);
    }

    public boolean isNumberProductDisplay(WebDriver driver, int value) {
        return (getElementSize(driver, BasePageUserUI.ALL_NAME_PRODUCT) > value) ? false : true;
    }

    public boolean isPagingButtonDisplay(WebDriver driver) {
        return !isElementUndisplayed(driver, BasePageUserUI.PAGING_BUTTON);
    }

    public boolean isNextPageButtonDisplay(WebDriver driver) {
        return !isElementUndisplayed(driver, BasePageUserUI.NEXT_PAGE_BUTTON);
    }

    public boolean isPreviousPageButtonDisplay(WebDriver driver) {
        return !isElementUndisplayed(driver, BasePageUserUI.PREVIOUS_PAGE_BUTTON);
    }

    public void clickToNextPageButton(WebDriver driver) {
        if (isNextPageButtonDisplay(driver))
            clickToElement(driver, BasePageUserUI.NEXT_PAGE_BUTTON);
        sleepInSecond(2);
    }

    public void clickToPreviousPageButton(WebDriver driver) {
        if (isPreviousPageButtonDisplay(driver))
            clickToElement(driver, BasePageUserUI.PREVIOUS_PAGE_BUTTON);
        sleepInSecond(2);
    }

    public boolean isProductNameDisplay(WebDriver driver, String pName) {
        if (isElementUndisplayed(driver, BasePageUserUI.PRODUCT_DISPLAY_BY_NAME, pName))
            return false;
        return true;
    }

    public String getBarNotificationSuccess(WebDriver driver) {
        return getElementText(driver, BasePageUserUI.MESSAGE_BAR_NOTIFICARTION);
    }

    public void clickCLoseButtonBarNotification(WebDriver driver) {
        clickToElement(driver, BasePageUserUI.CLOSE_BAR_NOTIFICARTION_BUTTON);
    }

    public UserHomePageObject clickLOGOIMAGE(WebDriver driver) {
        clickToElement(driver, BasePageUserUI.HEADER_LOGO);
        return PageGeneratorManager.getUserHomePage(driver);
    }

}
