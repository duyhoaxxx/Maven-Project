package pageObjects.nopCommerce.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.BasePageAdminUI;

public class BasePageAdmin extends BasePage {
    public void Loaded(WebDriver driver) {
        waitForElementInvisible(driver, BasePageAdminUI.LOADING_PAGE_ICON);
    }

    public void ClickLeftMenuByName(WebDriver driver, String name) {
        clickToElementByJS(driver, BasePageAdminUI.DYNAMIC_LEFT_MENU_BY_NAME, name);
    }

    public void ClickToLinkByText(WebDriver driver, String text) {
        clickToElement(driver, BasePageAdminUI.DYNAMIC_LINK_BY_TEXT, text);
    }

    public void clickCustomersLeftMenuDropdown(WebDriver driver) {
        clickToElementByJS(driver, BasePageAdminUI.CUSTOMERS_LEFT_MENU_DROPDOWN);
        sleepInSecond(2);
    }

    public ADCustomersPageObject clickCustomersLeftMenuPage(WebDriver driver) {
        clickToElement(driver, BasePageAdminUI.CUSTOMERS_LEFT_MENU_PAGE);
        return PageGeneratorManager.getCustomersPage(driver);
    }

    public void waitLoadedPageByHeaderName(WebDriver driver, String headerName) {
        waitForElementVisible(driver, BasePageAdminUI.LEFT_HEADER_PAGE_BY_NAME, headerName);
    }

    public String getFloatLeftHeaderPage(WebDriver driver) {
        return getElementText(driver, BasePageAdminUI.LEFT_HEADER_PAGE);
    }

    public String getAllResultSearch(WebDriver driver) {
        return String.valueOf(getElementSize(driver, BasePageAdminUI.ALL_RESULT_DATA_SEARCH));
    }

    public boolean isNoDataInTableByID(WebDriver driver, String id) {
        return (!isElementUndisplayed(driver, BasePageAdminUI.NO_DATA_IN_TABLE_MESSAGE_BY_ID, id));
    }

    public String getMessageNoDataInTableByID(WebDriver driver, String id) {
        return getElementText(driver, BasePageAdminUI.NO_DATA_IN_TABLE_MESSAGE_BY_ID, id);
    }

    public String getMessageSuccess(WebDriver driver) {
        String result = getElementText(driver, BasePageAdminUI.MESSAGE_SUCCESS);
        closeMessageNotify(driver);
        return result;
    }

    private void closeMessageNotify(WebDriver driver) {
        clickToElementByJS(driver, BasePageAdminUI.CLOSE_MESSAGE_NOTIFY_BUTTON);
    }

    public void openTabSearchEachPage(WebDriver driver) {
        if (!isElementUndisplayed(driver, BasePageAdminUI.SEARCH_TAB_OPEN))
            clickToElementByJS(driver, BasePageAdminUI.SEARCH_TAB_OPEN);
    }

    public void clickToTabByText(WebDriver driver, String value) {
        if (!isElementUndisplayed(driver, BasePageAdminUI.OPEN_TAB_BY_NAME, value))
            clickToElementByJS(driver, BasePageAdminUI.OPEN_TAB_BY_NAME, value);
    }
}
