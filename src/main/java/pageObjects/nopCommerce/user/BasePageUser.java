package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.MenuPageObject.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.MenuPageObject.UserWishlistPageObject;
import pageUIs.nopCommerce.BasePageUI;

public class BasePageUser extends BasePage {

    public void openHeaderPageByName(WebDriver driver, String headerPage) {
        String locator = getDynamicXpath(BasePageUI.DYNAMIC_PAGE_HEADER, headerPage);
        waitForElementClickable(driver, locator);
        clickToElement(driver, locator);
    }

    public void openFooterPageByName(WebDriver driver, String footerPage) {
        String locator = getDynamicXpath(BasePageUI.DYNAMIC_PAGE_FOOTER, footerPage);
        waitForElementClickable(driver, locator);
        clickToElement(driver, locator);
    }

    public UserHomePageObject ClickToLogoutLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_USER);
        clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public AdminLoginPageObject ClickToLogoutLinkAtAdminPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
        clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

    public UserWishlistPageObject ClickToWishlistLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.WISHLIST_LINK_AT_USER);
        clickToElement(driver, BasePageUI.WISHLIST_LINK_AT_USER);
        return PageGeneratorManager.getWishlistPage(driver);
    }

    public UserShoppingCartPageObject ClickToShoppingCartLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.SHOPPING_CART_LINK_AT_USER);
        clickToElement(driver, BasePageUI.SHOPPING_CART_LINK_AT_USER);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public boolean isMyAccountPageTitleDisplayedByName(WebDriver driver, String pageName) {
        String locator = getDynamicXpath(BasePageUI.DYNAMIC_MY_ACCOUNT_PAGE_TITLE, pageName);
        return isElementDisplay(driver, locator);
    }

    public boolean isPageTitleDisplayedByName(WebDriver driver, String pageName) {
        String locator = getDynamicXpath(BasePageUI.DYNAMIC_PAGE_TITLE, pageName);
        return isElementDisplay(driver, locator);
    }

    public void openMyAccountPageByName(WebDriver driver, String pageName) {
        String locator = getDynamicXpath(BasePageUI.DYNAMIC_MY_ACCOUNT_PAGE_LINK, pageName);
        clickToElement(driver, locator);
    }

    public void openTopMenuByName(WebDriver driver, String menuName) {
        clickToElement(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
    }

    public void clickToSortByDropdown(WebDriver driver, String key) {
        selectItemInDefaultDropdown(driver, BasePageUI.SORT_BY_DROPDOWN, key);
        sleepInSecond(2);
    }

    public boolean isSortedNameAscending(WebDriver driver) {
        List<String> listResults = new ArrayList<>();
        List<WebElement> listElementName = getListWebElement(driver, BasePageUI.ALL_NAME_PRODUCT);
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
        List<WebElement> listElementName = getListWebElement(driver, BasePageUI.ALL_NAME_PRODUCT);
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
        List<WebElement> listElementPrice = getListWebElement(driver, BasePageUI.ALL_PRICE_PRODUCT);
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
        List<WebElement> listElementPrice = getListWebElement(driver, BasePageUI.ALL_PRICE_PRODUCT);
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
        selectItemInDefaultDropdown(driver, BasePageUI.PAGE_SIZE_BUTTON, key);
        sleepInSecond(2);
    }

    public boolean isNumberProductDisplay(WebDriver driver, int value) {
        return (getElementSize(driver, BasePageUI.ALL_NAME_PRODUCT) > value) ? false : true;
    }

    public boolean isPagingButtonDisplay(WebDriver driver) {
        return !isElementUndisplayed(driver, BasePageUI.PAGING_BUTTON);
    }

    public boolean isNextPageButtonDisplay(WebDriver driver) {
        return !isElementUndisplayed(driver, BasePageUI.NEXT_PAGE_BUTTON);
    }

    public boolean isPreviousPageButtonDisplay(WebDriver driver) {
        return !isElementUndisplayed(driver, BasePageUI.PREVIOUS_PAGE_BUTTON);
    }

    public void clickToNextPageButton(WebDriver driver) {
        if (isNextPageButtonDisplay(driver))
            clickToElement(driver, BasePageUI.NEXT_PAGE_BUTTON);
        sleepInSecond(2);
    }

    public void clickToPreviousPageButton(WebDriver driver) {
        if (isPreviousPageButtonDisplay(driver))
            clickToElement(driver, BasePageUI.PREVIOUS_PAGE_BUTTON);
        sleepInSecond(2);
    }

    public boolean isProductNameDisplay(WebDriver driver, String pName) {
        if (isElementUndisplayed(driver, BasePageUI.PRODUCT_DISPLAY_BY_NAME, pName))
            return false;
        return true;
    }

    public boolean isProductNameInMiniShoppingCart(WebDriver driver, String pName) {
        hoverMouseToElement(driver, BasePageUI.SHOPPING_CART_LINK_AT_USER);
        return isElementEnable(driver, BasePageUI.ALL_NAME_IN_MINI_SHOPPING_CART, pName);
    }

    public String getBarNotificationSuccess(WebDriver driver) {
        return getElementText(driver, BasePageUI.MESSAGE_BAR_NOTIFICARTION);
    }

    public void clickCLoseButtonBarNotification(WebDriver driver) {
        clickToElement(driver, BasePageUI.CLOSE_BAR_NOTIFICARTION_BUTTON);
    }
}
