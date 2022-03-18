package pageObjects.nopCommerce.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.BasePageAdminUI;

public class BasePageAdmin extends BasePage {
    public void ClickLeftMenuByName(WebDriver driver, String name) {
        clickToElement(driver, BasePageAdminUI.DYNAMIC_LEFT_MENU_BY_NAME, name);
    }

    public void ClickToLinkByText(WebDriver driver, String text) {
        clickToElement(driver, BasePageAdminUI.DYNAMIC_LINK_BY_TEXT, text);
    }

    public void clickCustomersLeftMenuDropdown(WebDriver driver) {
        clickToElement(driver, BasePageAdminUI.CUSTOMERS_LEFT_MENU_DROPDOWN);
    }

    public ADCustomersPageObject clickCustomersLeftMenuPage(WebDriver driver) {
        clickToElement(driver, BasePageAdminUI.CUSTOMERS_LEFT_MENU_PAGE);
        return PageGeneratorManager.getCustomersPage(driver);
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
        return getElementText(driver, BasePageAdminUI.MESSAGE_SUCCESS);
    }

    public void openTabSearchEachPage(WebDriver driver) {
        if (!isElementUndisplayed(driver, BasePageAdminUI.SEARCH_TAB_OPEN))
            clickToElement(driver, BasePageAdminUI.SEARCH_TAB_OPEN);
    }

    public void clickToTabByText(WebDriver driver, String value) {
        if (!isElementUndisplayed(driver, BasePageAdminUI.OPEN_TAB_BY_NAME, value))
            clickToElement(driver, BasePageAdminUI.OPEN_TAB_BY_NAME, value);
    }
}
