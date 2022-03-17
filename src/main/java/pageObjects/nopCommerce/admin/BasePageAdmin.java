package pageObjects.nopCommerce.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.BasePageAdminUI;

public class BasePageAdmin extends BasePage {
    public void clickLeftMenuByName(WebDriver driver, String name) {
        clickToElement(driver, BasePageAdminUI.DYNAMIC_LEFT_MENU_BY_NAME, name);
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
}
